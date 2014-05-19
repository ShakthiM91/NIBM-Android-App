package com.powersolutions.nibm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Regional extends Activity implements OnClickListener{

	Button bColombo, bKandy, bKuru, bGalle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regional);
		init();
	}
	
	private void init(){
		bColombo=(Button)findViewById(R.id.btnColombo);
		bColombo.setOnClickListener(this);
		
		bKandy=(Button)findViewById(R.id.btnKandy);
		bKandy.setOnClickListener(this);
		
		bKuru=(Button)findViewById(R.id.btnKuru);
		bKuru.setOnClickListener(this);
		
		bGalle=(Button)findViewById(R.id.btnGalle);
		bGalle.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnColombo:
			startActivity(new Intent(Regional.this, Colombo.class));
			break;
		case R.id.btnGalle:
			startActivity(new Intent(Regional.this, Galle.class));
			break;
		case R.id.btnKuru:
			startActivity(new Intent(Regional.this, Kurunagala.class));
			break;
			
		case R.id.btnKandy:
			startActivity(new Intent(Regional.this, Kandy.class));
			break;
		}
		
	}

}
