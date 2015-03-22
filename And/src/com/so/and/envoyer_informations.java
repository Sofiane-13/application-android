package com.so.and;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class envoyer_informations  extends MainActivity{
	 private static Socket socket;
	 
	    public static void lance()
	    {
	        try
	        {
	            String host = "localhost";
	            int port = 25000;
	            InetAddress address = InetAddress.getByName(host);
	            socket = new Socket("192.168.1.5", port);
	 
	            //Send the message to the server
	            OutputStream os = socket.getOutputStream();
	            OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);
	 
	            String sendapi = api + "\n";
	            String sendnom = nom_application + "\n";
	            String sendcalculatrice = string_calculatrice +"\n";
                String sendcalendrier = string_calendrier +"\n" ;
                String sendrepertoire = string_repertoire +"\n" ;
	            String sendmessagerie = string_messagerie +"\n";

	 
	           
	            bw.write(sendapi);
	            bw.write(sendnom);
	            bw.write(sendcalculatrice);
	            bw.write(sendcalendrier);
	            bw.write(sendrepertoire);
	            bw.write(sendmessagerie);
	            bw.flush();
	            System.out.println("Message sent to the server : "+sendapi);

	            System.out.println("Message sent to the server : "+sendnom);
	            System.out.println("Message sent to the server : "+sendcalculatrice);
	            System.out.println("Message sent to the server : "+sendcalendrier);
	            System.out.println("Message sent to the server : "+sendrepertoire);
	            System.out.println("Message sent to the server : "+sendmessagerie);
	 
	            
	            
	        }
	        catch (Exception exception)
	        {
	            exception.printStackTrace();
	        }
	        finally
	        {
	            //Closing the socket
	            try
	            {
	                socket.close();
	            }
	            catch(Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }

}
