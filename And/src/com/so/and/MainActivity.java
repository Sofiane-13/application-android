package com.so.and;





import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity implements OnClickListener {
	
	
	RadioButton rb_ApiLocal,rb_Api19,rb_Api20,rb_Api21;
	CheckBox box_messagerie,box_repertoire,box_calendrier,box_calculatrice;
	Button btn_historique;
	public static String string_messagerie="0",string_repertoire="0",string_calendrier="0",string_calculatrice="0",nom_application,api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initInterface();
        CheckExistence_historique();
        Synchroniserbox();
      
        btn_historique.setOnClickListener(this);
        
        addButtonClickListner();
		
    }
    
    public void addButtonClickListner() {
    	
    	Button btn1 = (Button)findViewById(R.id.btncree);
		Button btn2 = (Button) findViewById(R.id.buttsav);
		Button btn3 = (Button) findViewById(R.id.effacer);
		Button btn4 = (Button) findViewById(R.id.installer);
		
		//nos quatre bouton
		
        btn4.setOnClickListener(new OnClickListener() {
			
			//le bouton pour installer
			@Override
			
			public void onClick(View v) {
				installer_apk();
				
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			
			//le bouton pour effacer  l'historique
			@Override
			public void onClick(View v) {
				Initial_historique.lance();
				
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			//le bouton sauvgarder dans l'historique un nouveau element
			@Override
			public void onClick(View v) {
				//Lire les informations sur l'activity
				Lire_informations();
				
				//Sauvgarder l'application dans le fichier historique
				sauvgarde_appli.lance();
				
				
			}
		});
		
		btn1.setOnClickListener(new OnClickListener() {
			
			//le bouton pour cr�e votre application
			@Override
			public void onClick(View arg) {
				
				//Lire les informations sur l'activity
				Lire_informations();
			
				xml_envoyer.lance();//xml des informations
				
				// appel au thread pour envoyer les informations d�but
				Envoyer_information();
								
				// appel au thread pour recevoire apk d�but
				Recevoire_apk();
								
			}
		});
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	@Override
	public void onClick(View v) {
		
		Intent  myintent = new Intent(this,Act2.class);
	
		startActivity(myintent);
	}
	private void initInterface() {
		/*Ici vousdevez faire toute les associations entre l'interface 
		 * et le code cource
		 * */
		
		    box_calculatrice = (CheckBox) findViewById(R.id.checkBox1);
			box_calendrier = (CheckBox) findViewById(R.id.checkBox2);
			box_messagerie = (CheckBox) findViewById(R.id.checkBox3);
			box_repertoire = (CheckBox) findViewById(R.id.checkBox4);
			btn_historique = (Button) findViewById(R.id.but);
			
	}
	private void CheckExistence_historique() {
		
		//check Existence historique d�but
        try {
			FileCheckExistence.lance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //check Existence historique fin
	}
	private void Synchroniserbox() {
		
		//synchroniser les checkbox d�but
		EditText et =(EditText)findViewById(R.id.editText1);
		et.setText(nom_application);
		if(string_messagerie.equals("1"))box_messagerie.setChecked(true);else  box_messagerie.setChecked(false);
		if(string_repertoire.equals("1"))box_repertoire.setChecked(true);else  box_repertoire.setChecked(false);
		if(string_calendrier.equals("1"))box_calendrier.setChecked(true);else  box_calendrier.setChecked(false);
		if(string_calculatrice.equals("1"))box_calculatrice.setChecked(true);else box_calculatrice.setChecked(false);
		
		
	}
	private void Lire_informations() {
		EditText et =(EditText)findViewById(R.id.editText1);
		nom_application = et.getText().toString();
		if(box_calculatrice.isChecked())string_calculatrice="1"; else string_calculatrice="0";
		if(box_calendrier.isChecked())string_calendrier="1"; else string_calendrier ="0";
		if(box_messagerie.isChecked())string_messagerie="1"; else string_messagerie="0";
		if(box_repertoire.isChecked())string_repertoire="1"; else string_repertoire = "0";
	}
	private void Envoyer_information() {
		new Thread(new Runnable() {
	        @Override
	        public void run() {
	            envoyer_informations.lance(); // call your network method here
	        }
	    }).start();
	}
	
	private void Recevoire_apk() {
		
		new Thread(new Runnable() {
	        @Override
	        public void run() {
	          
	        	recevoire_apk.lancer();
				
	        }   
	          }).start();
	}
	private void installer_apk(){
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    intent.setDataAndType(Uri.fromFile(new File("/data/data/com.so.and/sofiane.apk")), "application/vnd.android.package-archive");
	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(intent);
	}
	
}
