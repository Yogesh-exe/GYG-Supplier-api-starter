package feign.config;

import com.getyourguide.mycompany.client.error.ClientErrorMapper;
import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import com.mycompany.openapi.model.ErrorResponseDTO;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class MyCompanyDownstreamErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        String errorReason = response.reason();

        //TODO: based on the response that mycompany api returns
        // please return one of the following Exception
        // Following is an example
        if (response.status() == HttpStatus.BAD_REQUEST.value()
            || response.status() == HttpStatus.NOT_FOUND.value()) {
            ErrorResponseDTO clientErrorResponse = ClientErrorMapper.getClientError(response);
            return new MyCompanyBusinessException(HttpStatus.valueOf(response.status()),
                clientErrorResponse.getErrorCode(),
                clientErrorResponse.getErroMessage());
        } else if (response.status() == HttpStatus.REQUEST_TIMEOUT.value()) {
            return new MyCompanyTechnicalException(HttpStatus.REQUEST_TIMEOUT, 408, errorReason);
        } else if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new MyCompanyTechnicalException(HttpStatus.INTERNAL_SERVER_ERROR, 500, errorReason);
        }
        return new MyCompanyTechnicalException(HttpStatus.INTERNAL_SERVER_ERROR, 503, "Generic Internal failure");
    }
}
