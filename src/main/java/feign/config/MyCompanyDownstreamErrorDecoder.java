package feign.config;

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
        errorDetails.put("method",methodKey);
        errorDetails.put("responseDetails",response.body().toString());

        String errorReason = response.reason();

        if(response.status() == HttpStatus.BAD_REQUEST.value()){
            return new MyCompanyServiceException(400, errorReason, errorDetails);
        }
        else if (response.status() ==HttpStatus.INTERNAL_SERVER_ERROR.value()){
            return new MyCompanyTechnicalException(500,errorReason,errorDetails);
        }
        return new MyCompanyTechnicalException(503,"Generic Internal failure",Collections.emptyMap());
    }
}
