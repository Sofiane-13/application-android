package com.so.and;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener {
	public static String ism;
	
	
	CheckBox msg,rep,calen,cal;
	static String m="0",re="0",cale="0",ca="0";
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        btn = (Button) findViewById(R.id.but);
        btn.setOnClickListener(this);
       
     
		cal = (CheckBox) findViewById(R.id.checkBox1);
		calen = (CheckBox) findViewById(R.id.checkBox2);
		msg = (CheckBox) findViewById(R.id.checkBox3);
		rep = (CheckBox) findViewById(R.id.checkBox4);
		EditText et =(EditText)findViewById(R.id.editText1);
		et.setText(ism);
		//test
		System.out.println("ism="+ism);
		System.out.println("m="+m);
		System.out.println("re="+re);
		System.out.println("cale="+cale);
		System.out.println("ca="+ca);
		//test
		
		if(m.equals("1"))msg.setChecked(true);else  msg.setChecked(false);
		if(re.equals("1"))rep.setChecked(true);else  rep.setChecked(false);
		if(cale.equals("1"))calen.setChecked(true);else  calen.setChecked(false);
		if(ca.equals("1"))cal.setChecked(true);else cal.setChecked(false);
		
		addButtonClickListner();
		
    }
    
    public void addButtonClickListner() {
		Button btnNavigator = (Button)findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.buttsav);
		Button btn3 = (Button) findViewById(R.id.efface);
		btn3.setOnClickListener(new OnClickListener() {
			
			//le button effacer l'historique l'historique
			@Override
			public void onClick(View v) {
				Initial_historique.lance();
				
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			
			//le button sauvgarder dans l'historique un nv element
			@Override
			public void onClick(View v) {
				
				EditText et =(EditText)findViewById(R.id.editText1);
				ism = et.getText().toString();
				if(cal.isChecked())ca="1"; else ca="0";
				if(calen.isChecked())cale="1"; else cale ="0";
				if(msg.isChecked())m="1"; else m="0";
				if(rep.isChecked())re="1"; else re = "0";
				
				
				ModifyXMLDOM.lance();
				
				
			}
		});
		
		btnNavigator.setOnClickListener(new OnClickListener() {
			
			//button crée votre application
			@Override
			public void onClick(View arg) {
				// TODO Auto-generated method stub
				
				EditText et =(EditText)findViewById(R.id.editText1);
				ism = et.getText().toString();
				
				
				
				if(cal.isChecked())ca="1";else ca="0";
				if(calen.isChecked())cale="1";else cale ="0";
				if(msg.isChecked())m="1";else m="0";
				if(rep.isChecked())re="1"; else re = "0";
			
				xml_envoyer.lance();
				// apel au thread
				new Thread(new Runnable() {
			        @Override
			        public void run() {
			            Client_socket.lance(); // call your network method here
			        }
			    }).start();
				
				
				//appel au thread
				
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
}
