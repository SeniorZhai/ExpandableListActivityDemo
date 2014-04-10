package com.dev_zhai.expandablelistactivitydemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends ExpandableListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<Map<String,String>> groups = new ArrayList<Map<String,String>>();
		Map<String, String> group1 = new HashMap<String, String>();
		Map<String, String> group2 = new HashMap<String, String>();
		group1.put("group", "DOTA");
		group2.put("group","DiaBlo");
		groups.add(group1);
		groups.add(group2);
		//
		List<Map<String, String>> child1 = new ArrayList<Map<String,String>>();
		Map<String, String> childData1 = new HashMap<String, String>();
		Map<String, String> childData2 = new HashMap<String, String>();
		childData1.put("child", "Dota1");
		childData2.put("child", "Dota2");
		child1.add(childData1);
		child1.add(childData2);
		//
		List<Map<String, String>> child2 = new ArrayList<Map<String,String>>();
		Map<String, String> child2Data1 = new HashMap<String, String>();
		Map<String, String> child2Data2 = new HashMap<String, String>();
		Map<String, String> child2Data3 = new HashMap<String, String>();
		child2Data1.put("child", "DiaBlo1");
		child2Data2.put("child", "DiaBlo2");
		child2Data3.put("child", "DiaBlo3");
		child2.add(child2Data1);
		child2.add(child2Data2);
		child2.add(child2Data3);
		//
		List<List<Map<String,String>>> childs = new ArrayList<List<Map<String,String>>>();
		childs.add(child1);
		childs.add(child2);
		SimpleExpandableListAdapter adapter = 
				new SimpleExpandableListAdapter(
						this, 					//context
						groups,					//一级目录数据
						R.layout.group, 		//一级目录样式布局文件
						new String[]{"group"},	//指定一级目录数据的key
						new int[]{R.id.group},	//指定一级目录数据显示控件的id
						childs, 				//二级目录的数据
						R.layout.child, 		//二级目录样式布局文件
						new String[]{"child"},	//指定二级目录数据的
						new int[]{R.id.child}	//指定二级目录数据显示控件的
				);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
