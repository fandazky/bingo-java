package server;

import client.myEchoClient;
import java.net.*;
import java.io.*;
import java.util.*;

public class HandleClient extends Thread {
    
    public String nama;
    private Socket client = null;
    public DataInputStream input;
    public DataOutputStream output;
    //private Home homeUI = null;
    private UI_server serverUI = null;
    public myEchoClient clientku = null;
    private int Flag = 0;
    String message;
    String user_tujuan;
    int kalah;
    
    public HandleClient(UI_server data, Socket client) {
        this.client = client;
        this.serverUI = data;
        try {
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            String message = input.readUTF();
            this.nama = message;
            this.setDaemon(true);
            this.start();
        }
        catch(java.io.IOException e) {
        
        }
    }
    
    public HandleClient(myEchoClient info, DataInputStream input) {
        this.input = input;
        this.clientku = info;
    }
    
    public void putus() {
        this.clientku.closeconn();
    }
    
    public void sendMessage(String message)throws IOException {
        output.writeUTF(message);
    }
    
    public void pm(String Message)throws IOException {
        clientku.tulisLog(message);
    }
    
    public int Disconnect() {
        Flag = -1;
        return Flag;
    }
    
    public void run() {
        if(serverUI!=null) {
            while(true) {
                try {
                    message = input.readUTF();

                    if(message.equals("++**Exit**++")) {
                        message = this.nama + " Telah Meninggalkan Room\n";
                        serverUI.writelog("\n"+this.nama+" has been Disconnect\n");
                    } else {                    
                        if(message.contains("#")) {
                            String[] sp = message.split("#");
                            if(sp[1].equals("kalah"));
                            {
                                kalah = 1;
                                serverUI.writemessage(sp[0] + " kalah");
                                serverUI.sendToClient(sp[0] + " kalah");
                            }
                        } else {
                            serverUI.writemessage(message);
                            serverUI.sendToClient(message);
                        }                        
                    }
                }
                catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
 
        if(clientku!=null)  { 
            while(true) {   
                try {
                    message = input.readUTF();
                }
                catch(IOException e) {
                    System.out.println("Masalah pada Thread client");
                }
        
                if (message.equalsIgnoreCase("QUIT")) {
                    clientku.closeconn();
                } else {
                    this.message = message;
                    if(!message.contains("kalah")) {
                        clientku.parsing_input(message);
                        clientku.tulisLog(message);
                    } else {
                        String[] sp = message.split("#");
                        clientku.tulisLog(sp[0]);
                        System.out.println(message);
                        clientku.hentikan();
                    }
                }
            }
        }
    }
}