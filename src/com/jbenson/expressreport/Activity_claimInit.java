package com.jbenson.expressreport;

import java.io.FileInputStream;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity_claimInit extends Activity
{



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.initialize_claim);
		ClaimList claimList = getIntent().getParcelableExtra("parsedClaimList");
		setupContinueClaimBtn(claimList);
		setupCancelClaimBtn();
		
		
	}
	
	private void setupContinueClaimBtn(final ClaimList claimList) {
		// Get reference to the button
		Button continueClaim = (Button) findViewById(R.id.generateBlankClaim);
		
		//Set the click listener to run my code
		continueClaim.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Claim claim = new Claim();
				EditText destination = (EditText) findViewById(R.id.destination_txt);
				EditText startDate = (EditText) findViewById(R.id.startDate_txt);
				EditText endDate = (EditText) findViewById(R.id.endDate_txt);
				EditText travelReason = (EditText) findViewById(R.id.travelReason_txt);
				claim.setDestination(destination.getText().toString());
				claim.setStartDate(startDate.getText().toString());
				claim.setEndDate(endDate.getText().toString());
				claim.setReasonForTravel(travelReason.getText().toString());
				//Toast.makeText(getApplicationContext(), 
                       // "Destination = "+claim.getDestination(), Toast.LENGTH_LONG).show();
				
				claimList.addClaim(claim);
				Intent i = new Intent(Activity_claimInit.this, Activity_claimEdit.class);
				i.putExtra("parsedClaim", claim);
				i.putExtra("parsedClaimList", claimList);
				startActivity(i);
			    }	
			});
	}
	private void setupCancelClaimBtn(){
		// Get reference to the button
				Button cancelClaim = (Button) findViewById(R.id.cancelClaim);
				
		//Set the click listener to run the onClick Code
				cancelClaim.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v){
						finish();
					}
				});
	}
	
}
