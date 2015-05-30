package com.machao.changeui;


import com.machao.changeui.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainClass extends FragmentActivity implements OnClickListener {

	private LinearLayout content;
	private TextView  tv1;
	private TextView  tv2;
	private TextView  tv3;
	private TextView  tv4;
	
	private android.support.v4.app.FragmentManager fm;
	private android.support.v4.app.FragmentTransaction ft;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		content = (LinearLayout)findViewById(R.id.content);	
		tv1 = (TextView)findViewById(R.id.tab1);
		tv2 = (TextView)findViewById(R.id.tab2);
		tv3 = (TextView)findViewById(R.id.tab3);
		tv4 = (TextView)findViewById(R.id.tab4);
		
		tv1.setOnClickListener(this);	
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);
		tv4.setOnClickListener(this);
		
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.content, new fragment2());
		ft.commit();
	}
	
	@Override
	public void onClick(View v) {
		Log.i("changeUI", Integer.toString(v.getId()));
		ft = fm.beginTransaction();
		switch(v.getId()){
			case R.id.tab1:
				ft.replace(R.id.content, new fragment1());
			break;
			
			case R.id.tab2:
				ft.replace(R.id.content, new fragment2());
			break;
			
			case R.id.tab3:
				ft.replace(R.id.content, new fragment3());
			break;
			
			case R.id.tab4:
				ft.replace(R.id.content, new fragment4());
			break;
			
			default:
			break;	
		}
		ft.commit();
		
	};
	
}
