/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Fandazky23
 */
import server.HandleClient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class myEchoClient {
    private UI_client UIclient;
    private int PORT;
    private InetAddress host;
    DataInputStream input = null;
    DataOutputStream output = null;
    public Socket link = null;
    public HandleClient infoClient;
    public String username;
    private Form_Koneksi koneksiku;
    private UI_clientAi UIclientAi;

    
    myEchoClient() {
    }
    
    myEchoClient(UI_client client, InetAddress host, int PORT, String nama) {
        this.UIclient = client;
        this.host = host;
        this.PORT = PORT;
        this.username = nama;
    }
    
    myEchoClient(UI_clientAi client, InetAddress host, int PORT, String nama) {
        this.UIclientAi = client;
        this.host = host;
        this.PORT = PORT;
        this.username = nama;
    }

    
    public void makeClient() {
        try {
            System.out.println("halo " + this.username);
            link = new Socket(host, PORT);
            input = new DataInputStream(link.getInputStream());
            output = new DataOutputStream(link.getOutputStream());
            infoClient = new HandleClient(this, input);
            infoClient.setDaemon(true);
            infoClient.nama = username;
            infoClient.start();
            output.writeUTF(username);
            
            if(UIclient!=null) {
                UIclient.writelog(infoClient.nama + " has been connected to server\n");
                UIclient.setUsername(infoClient.nama);
            } else {
                UIclientAi.writelog(infoClient.nama + " has been connected to server\n");
                //UIclientAi.setUsername(infoClient.nama);
            }
        }
        
        catch(Exception ex) {
        }
    }
    
    public void closeconn() {
        if(link==null)System.exit(1);
        int flag = infoClient.Disconnect();
        String Dis = "++**Exit**++";
        
        try {
            output.writeUTF(Dis);
            link.close();            
        }
        
        catch(IOException e) {
        }
        
        System.exit(1); 
    }
    
    public void tulisLog(String log) {
        if(UIclient!=null) {
            UIclient.writelog(log);
        } else {
            UIclientAi.writelog(log);
        }
    }
    
    public void broadcast(String message) {
        try {
            System.out.println("cek broadcast : " + message + "*");
            output.writeUTF(message);
        }
        catch(Exception e) {
            
        }
    }
      
    public void parsing_input(String s) {
        //System.out.println("cek parsing input" + s);
        String sp[];
        
        if(s.contains(" ")) {
            sp = s.split(" ");
            if(UIclient!=null) {
                UIclient.terima = sp[2];
            } else {
                UIclientAi.terima = sp[2];
            }
        }
        if(UIclient!=null) {
            this.UIclient.cek();
        } else {
            this.UIclientAi.cek();
        }
    }
    
    public void hentikan() {
        if(UIclient!=null) {
            UIclient.berhenti();
        } else {
            UIclientAi.berhenti();
            UIclientAi.setSelesai();
        }
    }
}