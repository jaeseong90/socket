package com.sjinc.socket.signtower;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SignTowerController {

    SignTowerService signTowerService;

    @Autowired
    public SignTowerController(SignTowerService signTowerService) {
        this.signTowerService = signTowerService;
    }

    @PostMapping(value = "/sendSign/v1")
    public ResponseEntity sendSign(@RequestBody SignTowerRequest signTowerRequest){
        log.info("=====START OF sendSign=======");
        log.info("has req : {}", signTowerRequest);

        SignTowerResponse signTowerResponse = signTowerService.sendData(signTowerRequest);

        log.info("has res : {}",signTowerResponse);
        log.info("=====END OF sendSign=======");

        return ResponseEntity.ok().body(signTowerResponse);
    }

}
