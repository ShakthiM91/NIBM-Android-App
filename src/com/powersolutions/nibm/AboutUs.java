package com.powersolutions.nibm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class AboutUs extends Activity implements ViewFactory {

	ImageSwitcher imgSwitch;
	int images[] = {R.drawable.sample4,R.drawable.sample7,R.drawable.sample8};
	int messageCount = images.length;
	int currentIndex = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus);
		init();
	}

	private void init(){
		imgSwitch=(ImageSwitcher)findViewById(R.id.imgSwitchAbout);
		imgSwitch.setFactory(this);
		Animation in = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_out_right);
		imgSwitch.setInAnimation(in);
		imgSwitch.setOutAnimation(out);
		
		
		changeImg();
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
		new CountDownTimer(3000, 1000) { // adjust the milli seconds here

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
