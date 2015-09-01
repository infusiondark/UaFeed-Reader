package com.app.feedle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.feedleit.uafeednews.R;

public class PaidVersion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paid_version);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.paid_version, menu);
		return true;
	}

}
