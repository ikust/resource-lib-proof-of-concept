package com.infinum.concept.resourcelib;

import android.app.Activity;
import android.widget.ImageView;

public class LibActivity extends Activity {

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ImageView imageView = new ImageView(this);
		imageView.setImageBitmap(Resources.getBitmapResourceByName(this, "com/infinum/concept/resourcelib", "android_platform.png"));
		
		setContentView(imageView);
	};
}
