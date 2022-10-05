package com.getyourguide.mycompany.client.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientErrorMapper {

    public static ClientErrorResponse getClientError(Response response){
        ClientErrorResponse message =null;
        try (InputStream bodyIs = response.body()
            .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ClientErrorResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Mapping failed for the response object received. Investigate further");
        }
        return message;
    }
}
