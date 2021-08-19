package com.sjinc.socket.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Slf4j
public class SocketUtil {

    //자원반납처리 필요
    public static byte[] sendData(String host,int port, byte[] sendData, int readLength){

        byte[] result = new byte[readLength];
        OutputStream os     = null;
        InputStream is     = null;

        log.info("START OF sendDATA");
        byteTokenString(sendData);
        log.info("END OF sendDATA");

        try (Socket socket  = new Socket(host,port) ) {

            socket.setSoTimeout(1000 *5);

            os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            dos.write(sendData);
            dos.flush();

            dis.readFully(result);


            log.info("START OF readData");
            byteTokenString(result);
            log.info("END OF readData");

        }catch(Exception ex){
            log.error(ex.getMessage());
        }finally {

        }

        return result;
    }

    private static void byteTokenString(byte[] param){
        StringBuffer sb = new StringBuffer();

        for(byte b : param){
            sb.append(String.format("%02X", b & 0xff));
        }

        log.info(sb.toString());

    }

}
