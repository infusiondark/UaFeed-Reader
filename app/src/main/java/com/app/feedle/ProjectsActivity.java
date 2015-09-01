package com.app.feedle;

import android.view.Menu;
import java.net.URLEncoder;

import com.app.uafeed.AboutActivity;
import com.app.uafeed.MainActivity;
import com.app.uafeed.activity.HomeActivity;

import com.feedleit.uafeednews.R;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectsActivity extends Activity {
	 	Button button_ab;
	    Button button_rt;

	    
	 
	    ImageView image_market;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projects);
		 setupUI();
	}
	 private void setupUI() {
		  button_ab=(Button)findViewById(R.id.button_at);
		  button_ab.setOnClickListener(button1Click);
	    
		  button_rt=(Button)findViewById(R.id.button_rt);        	     
		  button_rt.setOnClickListener(button2Click);
		  
		 
		  
		  image_market=(ImageView) findViewById(R.id.imageView_view);
		  image_market.setOnClickListener(imageClick); 
	    }
	    
	  private OnClickListener button2Click=new OnClickListener(){
	        @Override
	        public void onClick(View v) {

	        	Intent marketIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
	                    "http://market.android.com/details?id=" + getPackageName()));
	                  startActivity(marketIntent2);    
	        }
	    };
	    
	    private OnClickListener button3Click=new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        	Intent Intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(
	                    "http://bmm-studio.mobi"));
	                  startActivity(Intent3);  
	       }
	    }; 

	    private OnClickListener button1Click=new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        
	        	Intent intent = new Intent(ProjectsActivity .this, AboutActivity.class);
	        	startActivity(intent);
	       }
	    }; 
	    private OnClickListener imageClick=new OnClickListener(){
	        @Override
	    public void onClick(View v){
	        	

	        	Intent marketIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
	                    "http://market.android.com/details?id=com.app.nexuswallpapers" ));
	                  startActivity(marketIntent2);    
	    	
	        }
	    };      
	

}
