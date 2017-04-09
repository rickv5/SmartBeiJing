package com.example.browersintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText urlText;
	private Button goButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取指向各个用户界面元素的句柄
		urlText = (EditText) findViewById(R.id.url_field);
		urlText.setSelection(urlText.getText().length());
		goButton = (Button) findViewById(R.id.go_button);
		//为go按钮添加点击事件
		goButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openBrowser();//用意图打开浏览器
			}

			private void openBrowser() {
				String s1 = urlText.getText().toString();
				if (s1.equalsIgnoreCase("http://")) {
					Toast.makeText(getApplicationContext(), "-_-欧欧-_-，请输入网址", 0).show();
				}else if(s1 != null && s1.startsWith("http://")){
					
					Uri uri = Uri.parse(s1);
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
				}
				else {
					Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent1);
				}
				
			}
		});
		//为urlText添加按下软键盘或物理键盘的特殊处理事件
		urlText.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_GO) {
					openBrowser();//用意图打开浏览器
					InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
					return true;
				}
				return false;
			}

			private void openBrowser() {
				String s1 = urlText.getText().toString();
				if (s1.equalsIgnoreCase("http://")) {
					Toast.makeText(getApplicationContext(), "-_-欧欧-_-，请输入网址", 0).show();
				}else if(s1 != null && s1.startsWith("http://")){
					
					Uri uri = Uri.parse(s1);
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
				}
				else {
					Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent1);
				}
			}
		});
	}

}
