package com.getyourguide.mycompany.client.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientErrorResponse {
        private String timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
}
