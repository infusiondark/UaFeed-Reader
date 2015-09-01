package com.app.uafeed;

import com.app.uafeed.api.Auth;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import com.feedleit.uafeednews.R;

public class LogInData extends Activity {
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Set View to register.xml
    setContentView(R.layout.register_in);
    
    Button loginScreen;
     loginScreen =(Button)findViewById(R.id.btnRegister);
     loginScreen.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View arg0) {
			// Switching to Login Screen/closing register screen
			
			//String[] auth=Auth.parseRedirectUrl(url);
            Intent intent=new Intent();
            intent.putExtra("token", 192435123);
            intent.putExtra("user_id", 892435125);
            setResult(Activity.RESULT_OK, intent);
			finish();
		}
	});
}
}