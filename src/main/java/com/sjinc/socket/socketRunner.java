package com.sjinc.socket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Component
public class socketRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {


        try{
            ServerSocket serverSocket = new ServerSocket(30002);

            //자원반납
            while (true){
                Socket socket = serverSocket.accept();
                log.info("START OF SOCKET");

                DataInputStream dis =  new  DataInputStream(socket.getInputStream());

                byte[] data = new byte[10];
                dis.readFully(data);

                DataOutputStream dos = new DataOutputStream((socket.getOutputStream()));

                dos.write(data);
                dos.flush();

                log.info("END OF SOCKET");
            }

        }catch (Exception ex){

        }
    }

}
