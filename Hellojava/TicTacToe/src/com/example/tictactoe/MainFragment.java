package com.example.tictactoe;

import com.example.tictactoe.utils.PrintOutUtils;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MainFragment extends Fragment {
	private AlertDialog mDialog;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState){
		PrintOutUtils.printMessage("1");
		View rootView = inflater.inflate(R.layout.fragment_main, container,false);
		//添加处理按钮的代码
		View aboutButton = rootView.findViewById(R.id.about_button);
		
		PrintOutUtils.printMessage("2");
		aboutButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				PrintOutUtils.printMessage("3");
				AlertDialog.Builder buidler = new AlertDialog.Builder(getActivity());
				buidler.setTitle(R.string.about_title);
				buidler.setMessage(R.string.about_text);
				buidler.setCancelable(false);
				buidler.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						PrintOutUtils.printMessage("点击了OK");
					}


				});
				mDialog = buidler.show();
				PrintOutUtils.printMessage("对话框显示了");
			}
		});
		return rootView;
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		PrintOutUtils.printMessage("4");
		//如果about对话框未关闭，就将其关闭
		if(mDialog != null) {
			mDialog.dismiss();
		}
	}
}



