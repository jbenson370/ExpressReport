package com.jbenson.expressreport;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class Activity_claimEdit extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.claim_editor);
		
		Claim claim = getIntent().getParcelableExtra("parsedClaim");
		ClaimList claimList = getIntent().getParcelableExtra("parsedClaimList");
		
		setupAddItemBtn(claim, claimList);
		setupSaveExitBtn(claim, claimList);
	}
	

	private void setupAddItemBtn(final Claim claim, final ClaimList claimList) {
		// Get reference to the button
		Button addItem = (Button) findViewById(R.id.addItem);
		
		//Set the click listener to run my code
		addItem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Activity_claimEdit.this, Activity_itemNew.class);
				i.putExtra("parsedClaim", claimList);
				i.putExtra("parsedClaim", claim);
				int itemRequestCode = 1;
				startActivityForResult(i, itemRequestCode);
			    }	
			});
		
	}
	private void setupSaveExitBtn(final Claim claim, final ClaimList claimList) {
		// Get reference to the button
				Button saveExit = (Button) findViewById(R.id.save_exit_btn);
				
				//Set the click listener to run my code
				saveExit.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						claimList.removeClaim(claim);
						claimList.addClaim(claim);
						finish();
					    }	
					});
		
	}
	protected void onActivityResult (int requestCode, int resultCode, Intent data){
		if (resultCode == RESULT_OK){
			Item item = data.getParcelableExtra("parsedItem");
			
			Claim claim = data.getParcelableExtra("parsedClaim");
			ClaimList claimList = data.getParcelableExtra("parsedClaimList");
			claim.addClaimItem(item);
			claimList.removeClaim(claim);
			claimList.addClaim(claim);
			populateListView(claim, claimList);
			
		}
		if (resultCode == 2){
			Claim claim = data.getParcelableExtra("parsedClaim");
			ClaimList claimList = data.getParcelableExtra("parsedClaimList");
			populateListView(claim, claimList);
		}
		
	
	}
		
	
	private void populateListView(Claim claim, ClaimList claimList) {
		ArrayList<Item> itemList = claim.getClaimItems();
		
		ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,R.layout.items_display ,itemList);
		
		ListView list = (ListView) findViewById(R.id.item_listView);
		list.setAdapter(adapter);
		continueBuilding(claim, claimList);
		
		
	}

	private void continueBuilding(Claim claim, ClaimList claimList) {
		setupAddItemBtn(claim, claimList);
		
	}
}

