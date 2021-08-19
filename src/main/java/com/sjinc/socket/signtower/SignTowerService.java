package com.sjinc.socket.signtower;

import com.sjinc.socket.socket.SocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SignTowerService {

    @Value("${signtower.ip}")
    private String signtowerip;
    @Value("${signtower.port}")
    private String signtowerport;

    public SignTowerResponse sendData(SignTowerRequest signTowerRequest){
        try{

            int red = Integer.parseInt(signTowerRequest.getR());
            int yellow =  Integer.parseInt(signTowerRequest.getY());
            int green = Integer.parseInt(signTowerRequest.getG());
            int sound = Integer.parseInt(signTowerRequest.getS());

            byte[] sendData = {0x57, 0x00, (byte)red, (byte)yellow, (byte)green, 0x00, 0x00,(byte)sound,0x00,0x00 };

            byte[] readData = SocketUtil.sendData(signtowerip,Integer.parseInt(signtowerport),sendData,sendData.length);

        }catch(Exception ex){
            log.error(ex.getMessage());
            return SignTowerResponse.builder().responseCd(SignTowerResponse.RESULT_FAIL).build();
        }
        return SignTowerResponse.builder().responseCd(SignTowerResponse.RESULT_SUCCESS).build();
    }

}
