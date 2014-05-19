package com.powersolutions.nibm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class Menu extends Activity implements OnClickListener, ViewFactory {

	ImageSwitcher imgSwitch;
	Button about, regional, course, site, news;

	static CountDownTimer tim;

	int images[] = { R.drawable.sample4, R.drawable.sample8,R.drawable.colombo,R.drawable.galle,R.drawable.kandy };
	int messageCount = images.length;
	int currentIndex = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		init();
	}

	private void init() {

		imgSwitch = (ImageSwitcher) findViewById(R.id.imgswitchMenu);
		imgSwitch.setFactory(this);
		Animation in = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_out_right);

		// set the animation type to imageSwitcher
		imgSwitch.setInAnimation(in);
		imgSwitch.setOutAnimation(out);

		changeImg();

		about = (Button) findViewById(R.id.btnAbout);
		about.setOnClickListener(this);

		regional = (Button) findViewById(R.id.btnRegional);
		regional.setOnClickListener(this);

		course = (Button) findViewById(R.id.btnCourse);
		course.setOnClickListener(this);
		
		imgSwitch.setOnClickListener(this);
		
		site=(Button)findViewById(R.id.btnSite);
		site.setOnClickListener(this);
		
		news=(Button)findViewById(R.id.btnNews);
		news.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnAbout:
			startActivity(new Intent(Menu.this, AboutUs.class));
			break;
		case R.id.btnRegional:
			startActivity(new Intent(Menu.this, Regional.class));
			break;
		case R.id.btnCourse:
			startActivity(new Intent(Menu.this, Course.class));
			break;
			
		case R.id.imgswitchMenu:
			startActivity(new Intent(Menu.this, News.class));
			break;
			
		case R.id.btnNews:
			startActivity(new Intent(Menu.this, News.class));
			break;
			
		case R.id.btnSite:
			Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nibm.lk"));
			startActivity(myIntent);
			break;
		}
	}

	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return imageView;
	}

	public void changeImg() {
		currentIndex++;
		// If index reaches maximum reset it
		if (currentIndex == messageCount)
			currentIndex = 0;
		imgSwitch.setImageResource(images[currentIndex]);
		timmer();
	}

	public void timmer() {
		tim = new CountDownTimer(3000, 1000) { // adjust the milli seconds here

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub

			}

			public void onFinish() {
				changeImg();
			}

		}.start();

	}

}
