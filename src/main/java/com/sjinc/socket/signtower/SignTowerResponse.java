package com.sjinc.socket.signtower;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignTowerResponse {
    private String responseCd;
    private String responseMessage;

    public static final String RESULT_SUCCESS = "A";
    public static final String RESULT_FAIL = "B";
}
