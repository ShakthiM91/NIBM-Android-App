package com.powersolutions.nibm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Galle extends Activity implements OnClickListener{

	Button call, mail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.galle);
		init();
	}

	private void init(){
		call=(Button)findViewById(R.id.btnCallGalle);
		call.setOnClickListener(this);
		
		mail=(Button)findViewById(R.id.btnMailGalle);
		mail.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnCallGalle:
			try {
				Intent call = new Intent(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:0915636363"));
				startActivity(call);
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(
						getApplicationContext(),
						"Something went wrong calling Kandy Program Office",
						Toast.LENGTH_SHORT).show();
			}
			break;

		case R.id.btnMailGalle:
			String[] email1 = { "galle@nibm.lk " };
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
