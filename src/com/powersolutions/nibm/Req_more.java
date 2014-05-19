package com.powersolutions.nibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Req_more extends Activity implements OnItemSelectedListener,
		OnClickListener {

	Spinner sp, sp2;
	Button btn;
	EditText name, phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.req_more);
		init();
	}

	private void init() {
		sp = (Spinner) findViewById(R.id.spinner_course);
		sp.setOnItemSelectedListener(this);

		sp2 = (Spinner) findViewById(R.id.spinner1);
		sp2.setOnItemSelectedListener(this);

		btn = (Button) findViewById(R.id.btnSendInfoMail);
		btn.setOnClickListener(this);

		name = (EditText) findViewById(R.id.txtPersonName);
		phone = (EditText) findViewById(R.id.txtPersonPhone);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if (sp.getSelectedItem().toString().equals("Diploma")) {
			loadSpinner(R.array.dip);
		} else if (sp.getSelectedItem().toString().equals("Certificate")) {
			loadSpinner(R.array.certificate);
		} else if (sp.getSelectedItem().toString().equals("Foundation")) {
			loadSpinner(R.array.foundation);
		} else if (sp.getSelectedItem().toString()
				.equals("Workshop and Seminars")) {
			loadSpinner(R.array.workshop);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	private void loadSpinner(int id) {
		List<String> spinnerArray = new ArrayList<String>();
		spinnerArray = Arrays.asList(getResources().getStringArray(id));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, spinnerArray);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Spinner sItems = (Spinner) findViewById(R.id.spinner1);
		sp2.setAdapter(adapter);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String[] email1 = { "info@nibm.lk " };
		String message = "Name : " + name.getText().toString() + 
				"\nContact NO: "+phone.getText().toString()+
				"\nInquiring Course : "+ sp2.getSelectedItem().toString();
		try {
			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, email1);
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Mail from NIBM-info App");
			emailIntent.setType("message/rfc822");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
			startActivity(emailIntent);
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(),
					"Something went wrong with email", Toast.LENGTH_SHORT)
					.show();
		}
	}

}
