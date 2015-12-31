package server;

import client.UI_client;
import java.io.*;
import java.net.*;
import java.util.*;

public class myEchoServer implements Runnable {
    private ServerSocket servSock;
    private int PORT;
    public UI_server formInduk;
    public UI_client formKlien;
    public HandleClient[] clients;
    public Socket klien;
    public Thread thread = null;
    public int clientCount = 0;
    
    public myEchoServer() {
    }
    
    private void addThread(Socket socket) {
         if (clientCount < clients.length) {  
	    clients[clientCount] = new HandleClient(formInduk, socket);
	    try {  
                clientCount++; 
	    }
	    catch(Exception e) {  
	      	formInduk.writelog(" Error opening thread: " + e.getMessage() + "\n"); 
	    } 
	}
    } 
    
    public void run() {
       this.formInduk.writelog("[server] EchoServer Thread has been started\n");
       System.out.println("ini :" + clients.length);
       while (thread != null) {  
            try{
                if (this.clientCount ==0 ) {
                    this.formInduk.writelog("[server] Waiting for a new client ...\n");
                } else {
                    this.formInduk.writelog("[server] Waiting for other clients ...\n"); 
                }
                Socket in = servSock.accept();
                formInduk.writelog("[server] a new Client has been accepted with IP Address : " + in.getInetAddress().getHostAddress() + "\n");
                 
	        addThread(in); 
	    }
	    catch(Exception ioe) { 
                this.formInduk.writelog("\nServer accept error: \n");
	    }
        }
    }

    public myEchoServer(UI_server formUtama,  int Port) {
        this.formInduk = formUtama;
        clients = new HandleClient[50];
        
        try {
            this.servSock = new ServerSocket(Port);
            this.formInduk.writelog("[server] Building Server  .. \n");    
            this.mulaiThread();
        }
        catch(Exception e) {
        }
    }
    
    public void mulaiThread() {  
    	if (thread == null) {  
            thread = new Thread(this); 
	    thread.start();
	}
    }

} 