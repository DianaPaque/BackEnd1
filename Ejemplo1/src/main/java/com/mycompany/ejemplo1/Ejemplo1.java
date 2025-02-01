/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class Ejemplo1 {
    private String serverAddress;
    private int port;
    private Socket clientSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Ejemplo1(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }
    
    public void connect() throws IOException{
        //SSLSockedFactory sockedFactory = (SSLSockedFactory.getDefault());
        // clientSocked = (SSLSocked)sockedFactory.createSocked(serverAddres, port);
        clientSocket = new Socket(serverAddress, port);
        System.out.println("Connection established");
        inputStream = new DataInputStream(clientSocket.getInputStream());
        outputStream = new DataOutputStream(clientSocket.getOutputStream());
    }
    
    public String sendMessage(String name, String lastName){
        String response = "Error";
        try {
            connect();
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(":").append(lastName);
            String message = sb.toString();
            System.out.println("Sending: "+message);
            outputStream.writeUTF(message);
            response = inputStream.readUTF();
            System.out.println("Response: "+response);
        } catch (IOException ex) {
            System.out.println("Client error: "+ex.getMessage());
        } finally {
            closeConnection();
        }
        return response;
    }
    
    public void closeConnection(){
        try{
            if(inputStream != null){
            inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
            if(clientSocket != null){
                clientSocket.close();
            }
        }catch(IOException ex){
            System.out.println("Error closing connection: "+ex.getMessage());
        }
        
        
    }
    
    
}
