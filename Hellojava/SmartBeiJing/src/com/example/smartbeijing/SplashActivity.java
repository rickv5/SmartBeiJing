package com.example.smartbeijing;

import com.example.utils.MyConstains;
import com.example.utils.PrintOutUtils;
import com.example.utils.SPUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	private ImageView iv_pic;
	private AnimationSet as;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉当前页的标题栏
		this.setTitle("智慧北京");
		
		initView();//界面
		
		initAnimation();//初始化动画
		
		initEvent();//初始化事件
		
		startAnimation();//开始动画
	}
	
	

	private void initEvent() {
		// TODO Auto-generated method stub
		as.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// 监听动画开始事件
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// 监听动画结束的事件，判断是否进入设置向导界面
				if(SPUtils.getBoolean(getApplicationContext(), MyConstains.IS_GUID_FINISH, false)) {
					PrintOutUtils.printOut("进入主界面");
				}else {
					PrintOutUtils.printOut("进入设置向导界面");
				}
			}
		});
	}



	private void startAnimation() {
		// TODO Auto-generated method stub
		//开始播放动画
		iv_pic.startAnimation(as);
	}

	private void initAnimation() {
		as = new AnimationSet(true);
		
		//旋转动画
		RotateAnimation ra = new RotateAnimation(0, 360, 
				Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(4000);
		ra.setFillAfter(true);
		
		//渐变动画
		AlphaAnimation aa = new AlphaAnimation(0, 1);
		aa.setDuration(4000);
		aa.setFillAfter(true);
		
		//缩放动画
		ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(4000);
		sa.setFillAfter(true);
		
		//添加动画到动画集
		as.addAnimation(sa);
		as.addAnimation(aa);
		as.addAnimation(ra);
	}

	private void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_splash);
		iv_pic = (ImageView) findViewById(R.id.iv_splash_pic);
	}

}
