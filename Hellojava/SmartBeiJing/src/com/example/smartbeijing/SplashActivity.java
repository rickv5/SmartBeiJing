package com.example.smartbeijing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉当前页的标题栏
		this.setTitle("智慧北京");
		
		initView();//界面
		
		initAnimation();//初始化动画
	}

	private void initAnimation() {
		// TODO Auto-generated method stub
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_splash);
		ImageView iv_splash_pic = (ImageView) findViewById(R.id.iv_splash_pic);
	}

}
