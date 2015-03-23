package com.so.and;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class recevoire_apk extends MainActivity {
	
	public static void lancer() {
		
     new Thread(new Runnable() {
   
    	@Override
    public void run() {
      try{
	Socket s = new Socket("192.168.1.5", 4000) ;

	ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
	
	
		
	
	byte [] buffer = (byte[]) ois.readObject();
	FileOutputStream fos = new FileOutputStream("/data/data/com.so.and/sofiane.apk");
	fos.write(buffer);
	
	
	}catch (ClassNotFoundException e){
        e.printStackTrace();	
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }
}      	
         ).start();
    
   
  }

}