package com.jbenson.expressreport;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupNewClaimBtn();
	}

	private void setupNewClaimBtn() {
		// Get reference to the button
		Button NewClaimBtn = (Button) findViewById(R.id.newClaim_btn);
		
		//Set the click listener to run my code
		NewClaimBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Activity_claimInit.class));
				
			}
		});
	}

	
}
