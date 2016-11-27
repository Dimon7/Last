/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static last.Client.msg_area;

/**
 *
 * @author dimon
 */
public class Server {
    public static final int PORT = 18000;
    
    static DataInputStream in = null;
    static DataOutputStream out = null;
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket  serverSocket = new ServerSocket(PORT);
        System.out.println("Started, waiting for connection");
        Socket socket = serverSocket.accept();
        
        in = new DataInputStream(socket.getInputStream());
        out =new DataOutputStream(socket.getOutputStream());
        
        String line = "";

        while( !line.equals("exit") ){
            
            
                
                byte[] buf = new byte[32*1024];
                int readBytes = in.read(buf);
                               
                line = new String(buf, 0, readBytes);
                //msg_area.setText("Client>%s" + line);
                System.out.printf("Client>%s", line + "\n");
                
                out.write(line.getBytes());
                
                
        }
    }
}
        

    