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
	
	static List<Map<String, String>> appliList = new ArrayList<Map<String,String>>();
	
	Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.act2);
        //effacer la liste view
        appliList.clear();
        Tableau.lance();
        
        btn = (Button) findViewById(R.id.le2);
        btn.setOnClickListener(this);
    



        
      
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
	    // le clique sur les item :
	    lv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parentAdapter, View view, int position,long id) {
	    		// We know the View is a TextView so we can cast it
	    		TextView clickedView = (TextView) view;
	    		 Toast.makeText(Act2.this, "Item with id ["+id+"] - Position ["+position+"] -application ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();
	    		 ism=Tableau.getnom(position);
	    		 m=Tableau.getmessage(position);
	    		 re=Tableau.getrepertoire(position);
	    		 cale=Tableau.getcalendrier(position);
	    		 ca=Tableau.getcalculatrice(position);
	    		
	    	
	    		 
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
		// TODO Auto-generated method stub
		//effacer notre liste
		
		Intent  myintent = new Intent(v.getContext(),MainActivity.class);
		startActivity(myintent);
		

	}
	
}
