package com.sjinc.socket.signtower;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignTowerRequest {
    private String r;
    private String g;
    private String y;
    private String s;
}
