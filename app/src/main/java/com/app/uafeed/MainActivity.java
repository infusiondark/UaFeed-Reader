 package com.app.uafeed;

import java.util.Arrays;
import java.util.List;

import com.app.uafeed.Account;
import com.app.uafeed.Constants;
import com.app.uafeed.LoginActivity;
import com.app.uafeed.MainActivity;
import com.app.uafeed.activity.HomeActivity;
import com.app.uafeed.api.Api;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.support.v4.app.Fragment;


import com.feedleit.uafeednews.R;


public class MainActivity extends Activity 
{
		
	 private final int REQUEST_LOGIN=1;
	 //public static final String APP_PREFERENCES = "myInDBsettings";   
	 //public static final String APP_PREFERENCES_COUNTER = "counter";
	 //int counter;
	 	SharedPreferences mSettings;
	    Button authorizeButton;
	    Button logoutButton;
	    Button facebooklogin;
	    Button in_db_login;
	
	    Account account=new Account();
	    Api api;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	      //�������������� ���������� ������
	        account.restore(this);
	        if(account.access_token!=null){
	        	api=new Api(account.access_token, Const.API_ID);
	        
	        }
	       
        	
	        
	      /*  if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
	    		
	        	finish();
	        	Intent intent2 = new Intent(MainActivity .this, HomeActivity.class);
	        	startActivity(intent2);
	    		
	    	}
	        */
	        setupUI();
	        showButtons();
	        
	    }
	   
	    

	    private void showButtons() 
	    {
			
	    	Action ();
	        if(api!=null){
	            authorizeButton.setVisibility(View.VISIBLE);
	            logoutButton.setVisibility(View.VISIBLE);
	            facebooklogin.setVisibility(View.VISIBLE);
	            in_db_login.setVisibility(View.VISIBLE);

	        			}
	        		else{ 
	        			authorizeButton.setVisibility(View.VISIBLE);
	        			logoutButton.setVisibility(View.GONE);
	        			facebooklogin.setVisibility(View.VISIBLE);
	        			in_db_login.setVisibility(View.VISIBLE);
	        			}
		};



		private void Action() 
		{	//vk
			
		
			if(account.access_token!=null) 
			{
			       api=new Api(account.access_token, Constants.API_ID);
			    	
			        	finish();
			        	Intent intent = new Intent(MainActivity .this, HomeActivity.class);
			        	startActivity(intent);
			        
			    	
			}
			
			
		};

	

		
	
		private void setupUI() 
		{
	        authorizeButton=(Button)findViewById(R.id.authorize);
	        authorizeButton.setOnClickListener(authorizeClick);
	        
	      //  facebooklogin=(Button)findViewById(R.id.fb_login);
	      //  facebooklogin.setOnClickListener(facebookClick);
	        
	        in_db_login=(Button)findViewById(R.id.in_db_login);
	        in_db_login.setOnClickListener(InDBClick);
	        
	        logoutButton=(Button)findViewById(R.id.logout);        	     
	        logoutButton.setOnClickListener(logoutClick);

	        
	    };
	    
	    private OnClickListener authorizeClick=new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	            startLoginActivity();
	        }
	    };
	    

	   
	    private OnClickListener logoutClick=new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	            logOut();
	       }
	    }; 
	    
	    private OnClickListener InDBClick=new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	        	//mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
	        	startLoginDataActivity();
	        }
	    };
	   
	    

		
	    private void startLoginActivity() 
	    {
	        Intent intent = new Intent();
	        intent.setClass(this, LoginActivity.class);
	        startActivityForResult(intent, REQUEST_LOGIN);
	    };
	    
	    private void startLoginDataActivity() 
	    {	
	    	//Editor editor = mSettings.edit();
		//	editor.putInt(APP_PREFERENCES_COUNTER, counter);
			//editor.apply();
	        Intent intent = new Intent();
	        intent.setClass(this, LogInData.class);
	        startActivityForResult(intent, REQUEST_LOGIN);
	    };
	    
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	       
	    	if (requestCode == REQUEST_LOGIN) 
	    	{
	            if (resultCode == RESULT_OK) 
	            {
	                //�������������� ������� 
	                account.access_token=data.getStringExtra("token");
	                account.user_id=data.getLongExtra("user_id", 0);
	                account.save(MainActivity.this);
	               api=new Api(account.access_token, Constants.API_ID);
	               
	                
	                showButtons();
	            }
	        }
	    	
	    }
	    
	  
	     
	    private void logOut() 
	    {
	        api=null;
	        account.access_token=null;
	        account.user_id=0;
	        account.save(MainActivity.this);
	        showButtons();
	    };
	   
	 
}
	    
	    


