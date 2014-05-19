package com.powersolutions.nibm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class Course extends Activity implements OnClickListener {
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	ExpandableListView elist;
	
	Button req;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.courses);
		init();
	}

	private void init() {
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.expandableListView1);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader,
				listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);
		
		req=(Button)findViewById(R.id.btnReqMore);
		req.setOnClickListener(this);
	}
	
	

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Diploma Programs");
		listDataHeader.add("Certificate Courses");
		listDataHeader.add("Foundation Courses");
		listDataHeader.add("Workshops And Seminars");

		expListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
				
				
				return false;
			}
		});
		
		// Adding child data
		List<String> dip = new ArrayList<String>();
		String[] dipAr=getResources().getStringArray(R.array.dip);
		for(int i=0;i<dipAr.length;i++){
			dip.add(dipAr[i]);
		}

		List<String> certificate = new ArrayList<String>();
		String[] certAr=getResources().getStringArray(R.array.certificate);
		for(int i=0; i<certAr.length;i++){
			certificate.add(certAr[i]);
		}

		List<String> foundation = new ArrayList<String>();
		String[] foundAr=getResources().getStringArray(R.array.foundation);
		for(int i=0;i<foundAr.length;i++){
			foundation.add(foundAr[i]);
		}
		
		List<String> workshop= new ArrayList<String>();
		String[] ar = getResources().getStringArray(R.array.workshop);
		for(int i=0; i<ar.length;i++){
			workshop.add(ar[i]);
		}

		listDataChild.put(listDataHeader.get(0), dip); // Header, Child data
		listDataChild.put(listDataHeader.get(1), certificate);
		listDataChild.put(listDataHeader.get(2), foundation);
		listDataChild.put(listDataHeader.get(3), workshop);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(this, Req_more.class));
	}

	
}