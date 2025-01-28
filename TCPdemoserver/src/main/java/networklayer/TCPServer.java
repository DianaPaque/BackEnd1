/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networklayer;

import com.mycompany.tcpdemobusiness.NamesManager;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class TCPServer {
    private int port;

    public TCPServer(int port) {
        this.port = port;
    }
    
    public void start(){
        try {
            ServerSocket serverSocked = new ServerSocket(port);
            System.out.println("Server listing on port: " + port);
            while(true){
                // Acepta la conección
                Socket clientSocked = serverSocked.accept();
                System.out.println("Connected from: " + clientSocked.getInetAddress());
                // Definición input - output
                DataInputStream inputStream = new DataInputStream(clientSocked.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocked.getOutputStream());
                
                String clientMessage = inputStream.readUTF();
                clientMessage = clientMessage.trim();
                String[] parts = clientMessage.split(":");
                NamesManager manager = new NamesManager();
                String response = manager.generateMessage(parts[0], parts[1]);
                
                System.out.println("Client message: " + clientMessage);
                System.out.println("Response: " + response);
                outputStream.writeUTF(response);
                clientSocked.close();
                System.out.println("Connection closed");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
