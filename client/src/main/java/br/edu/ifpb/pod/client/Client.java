/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


/**
 *
 * @author Maluco Beleza
 */
public class Client {
        
    public static void main(String[] args) throws IOException {
                   
            while(true){
                System.out.println("Client: conectando ao servidor...");
                Socket socket = new Socket("127.0.0.1", 8483);
                InputStream input = socket.getInputStream();
                byte[] b = new byte[1024];
                input.read(b);
                System.out.println(new String(b));
                
                //String msgcli = in.next();
                 String msgcli = "LOGIN:-:jederson@gmail.com";
                socket.getOutputStream().write(msgcli.getBytes());
                socket.getOutputStream().flush();
                
                socket.close();
                break;
            }
    }
}
