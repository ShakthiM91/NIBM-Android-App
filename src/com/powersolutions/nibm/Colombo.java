package com.powersolutions.nibm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Colombo extends Activity implements OnClickListener {

	Button manageCall, manageMail, misCall, misMail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colombo);
		init();
	}

	private void init() {
		manageCall = (Button) findViewById(R.id.btnCallColomboMange);
		manageCall.setOnClickListener(this);

		manageMail = (Button) findViewById(R.id.btnMailColomboMange);
		manageMail.setOnClickListener(this);

		misCall = (Button) findViewById(R.id.btnCallColMis);
		misCall.setOnClickListener(this);

		misMail = (Button) findViewById(R.id.btnMailColMis);
		misMail.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnCallColomboMange:
			try {
				Intent call = new Intent(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:0112685806"));
				startActivity(call);
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(
						getApplicationContext(),
						"Something went wrong calling Colombo Managemnt Program Office",
						Toast.LENGTH_SHORT).show();
			}
			break;

		case R.id.btnMailColomboMange:
			String[] email = { "info@nibm.lk" };
			try {
				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, email);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"Mail from NIBM-info App");
				emailIntent.setType("plain/text");
				// emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				// message);
				startActivity(emailIntent);
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(),
						"Something went wrong with email", Toast.LENGTH_SHORT)
						.show();
			}
			break;

		case R.id.btnCallColMis:
			try {
				Intent call = new Intent(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:0112667769"));
				startActivity(call);
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(
						getApplicationContext(),
						"Something went wrong calling Colombo Managemnt Program Office",
						Toast.LENGTH_SHORT).show();
			}

			break;

		case R.id.btnMailColMis:
			String[] email1 = { "infomis@nibm.lk" };
			try {
				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent
						.putExtra(android.content.Intent.EXTRA_EMAIL, email1);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"Mail from NIBM-info App");
				emailIntent.setType("plain/text");
				// emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				// message);
				startActivity(emailIntent);
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(),
						"Something went wrong with email", Toast.LENGTH_SHORT)
						.show();
			}

			break;
		}
	}

}
