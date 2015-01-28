package com.jbenson.expressreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Activity_claimInit extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.initialize_claim);
		
		setupContinueClaimBtn();
		
	}
	
	private void setupContinueClaimBtn() {
		// Get reference to the button
		Button continueClaim = (Button) findViewById(R.id.generateBlankClaim);
		
		//Set the click listener to run my code
		continueClaim.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Activity_claimInit.this, Activity_claimEdit.class));
				
			}
		});
	}	
}
