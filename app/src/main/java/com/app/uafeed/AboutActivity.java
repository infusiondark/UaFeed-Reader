package com.app.uafeed;



import android.view.Menu;
import java.net.URLEncoder;

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

public class AboutActivity extends Activity {
	 Button button3;
	    Button button2;
	    Button button1;
	    
	    TextView tvShow;
	    TextView tvShow_company;
	    ImageView image1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		 tvShow = (TextView) findViewById(R.id.textView1);
		 tvShow_company = (TextView) findViewById(R.id.textView2);
		 setupUI();
	
	}


	
	  private void setupUI() {
		  button1=(Button)findViewById(R.id.button1);
		  button1.setOnClickListener(button1Click);
	    
		  button2=(Button)findViewById(R.id.button2);        	     
		  button2.setOnClickListener(button2Click);
		  
		  button3=(Button)findViewById(R.id.button3);        	     
		  button3.setOnClickListener(button3Click);
		  
		  image1=(ImageView) findViewById(R.id.imageView1);
		  image1.setOnClickListener(imageClick); 
	    }
	    
	  private OnClickListener button2Click=new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        	final Intent email = new Intent(android.content.Intent.ACTION_SENDTO);
				String uriText = "mailto:muhabohdan@hotmail.com" +
						"?subject=" + URLEncoder.encode("UAFeed NEws Feedback"); 
				email.setData(Uri.parse(uriText));
				try {
					startActivity(email);
				} catch (Exception e) {
					
				}
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
	        
	        	Intent marketIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
	                    "http://market.android.com/details?id=" + getPackageName()));
	                  startActivity(marketIntent2);    
	       }
	    }; 
	    private OnClickListener imageClick=new OnClickListener(){
	        @Override
	    public void onClick(View v){
	        	
	        	Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.vk.com/mukhabm"));
	                  startActivity(MyIntent); 
	    	
	        }
	    };      
  
}