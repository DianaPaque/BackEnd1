/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networkLayer;
import com.mycompany.ejemplo1.Ejemplo1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NetworkClient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type your name: ");
        String name = in.nextLine();
        System.out.println("Type your last name: ");
        String lastName = in.nextLine();
        Ejemplo1 client = new Ejemplo1("192.168.126.217", 9090);
        String response = client.sendMessage(name, lastName);
        System.out.println(response);
    }
    
     /*
    Properties p = new Properties();
        try {
            p.load(new FileInputStream(new File("configuration.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPDemoClien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPDemoClien.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        System.setProperty("javax.net.ssl.keyStore",certificateRoute);
        System.setProperty("javax.net.ssl.keyStorePassword",certificatePassword);
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.trustStore", certificateRoute);
        System.setProperty("javax.net.ssl.trustStorePassword", certificatePassword);
        System.setProperty("javax.net.ssl.trustStoreType", "PKCS12");

       */
}
