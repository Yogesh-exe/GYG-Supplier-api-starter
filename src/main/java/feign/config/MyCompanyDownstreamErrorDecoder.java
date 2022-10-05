package feign.config;

import com.getyourguide.mycompany.client.error.ClientErrorMapper;
import com.getyourguide.mycompany.client.error.ClientErrorResponse;
import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyServiceException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

public class MyCompanyDownstreamErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("method", methodKey);
        errorDetails.put("responseDetails", response.body().toString());

        String errorReason = response.reason();

        //TODO: based on the response that mycompany api returns
        // please return one of the following Exception
        // Following is an example
        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            ClientErrorResponse clientErrorResponse = ClientErrorMapper.getClientError(response);
            return new MyCompanyBusinessException(clientErrorResponse.getStatus(), clientErrorResponse.getMessage(), errorDetails);
        }
        else if(response.status() == HttpStatus.REQUEST_TIMEOUT.value()){
            return new MyCompanyServiceException(408, errorReason, errorDetails);
        }
        else if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new MyCompanyTechnicalException(404, errorReason, errorDetails);
        } else if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new MyCompanyTechnicalException(500, errorReason, errorDetails);
        }
        return new MyCompanyTechnicalException(503, "Generic Internal failure", Collections.emptyMap());
    }
}
