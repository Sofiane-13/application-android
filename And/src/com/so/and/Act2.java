package com.so.and;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Act2 extends MainActivity implements OnClickListener {
	String choix1,choix2,choix3,choix4;
	static List<Map<String, String>> appliList = new ArrayList<Map<String,String>>();
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.act2);
       
        //effacer la liste view
        appliList.clear();
        
        //appler le tableau d'historique
        Tableau.lance();
        
        Button btn_retoure;
        btn_retoure = (Button) findViewById(R.id.retoure);
        btn_retoure.setOnClickListener(this);
    
      
        // We get the ListView component from the layout
	    ListView lv = (ListView) findViewById(R.id.listView);

	    // This is a simple adapter that accepts as parameter
	    // Context
	    // Data list
	    // The row layout that is used during the row creation
	    // The keys used to retrieve the data
	    // The View id used to show the data. The key number and the view id must match
	    SimpleAdapter simpleAdpt = new SimpleAdapter(this, appliList, android.R.layout.simple_list_item_1, new String[] {"application"}, new int[] {android.R.id.text1});

	    lv.setAdapter(simpleAdpt);
	    
	    // le clique sur les items :
	    lv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parentAdapter, View view, int position,long id) {
	    		// We know the View is a TextView so we can cast it
	    		TextView clickedView = (TextView) view;
	    		 
	    		nom_application=Tableau.getnom(position);
	    		 string_messagerie=Tableau.getmessage(position);
	    		 string_repertoire=Tableau.getrepertoire(position);
	    		 string_calendrier=Tableau.getcalendrier(position);
	    		 string_calculatrice=Tableau.getcalculatrice(position);
	    		
	    		 if(string_messagerie.equals("1"))choix1="choisie";else choix1="non choisie";
	    		 if(string_repertoire.equals("1"))choix2="choisie";else choix2="non choisie";
	    		 if(string_calendrier.equals("1"))choix3="choisie";else choix3="non choisie";
	    		 if(string_calculatrice.equals("1"))choix4="choisie";else choix4="non choisie";
	    		 
	    		 

	    		 Toast.makeText(Act2.this, "nom: ["+clickedView.getText()+"] -repertoire: ["+choix2+"]-calendrier: ["+choix3+"]-calculatrice: ["+choix4+"]-messagerie: ["+choix1+"]", Toast.LENGTH_LONG).show();
	    		 Toast.makeText(Act2.this, "nom: ["+clickedView.getText()+"] -repertoire: ["+choix2+"]-calendrier: ["+choix3+"]-calculatrice: ["+choix4+"]-messagerie: ["+choix1+"]", Toast.LENGTH_LONG).show();
	    		  	    	
	    	}});
		
        
    
    }
    
    
	  	protected static HashMap<String, String> createapplication(String key, String name) {
	  	    HashMap<String, String> application = new HashMap<String, String>();
	  	    application.put(key, name);
	 	 
	  	    return application;
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
		
		
		
		Intent  myintent = new Intent(v.getContext(),MainActivity.class);
		startActivity(myintent);
		

	}
	
}
