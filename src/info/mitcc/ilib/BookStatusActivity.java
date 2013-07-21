package info.mitcc.ilib;

import java.util.*;

import info.mitcc.bean.BookStatus;
import info.mitcc.sax.BooksStatusXMLParse;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookStatusActivity extends Activity {
	ListView statusListView;
	ArrayAdapter<String> statusAdapter;
	int doc_number;
	List<BookStatus> list;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);
		
		Intent intent = getIntent();
		doc_number =(Integer) intent.getSerializableExtra("status");
		String getBookStatusUrl = "http://10.10.16.94/X?op=item-data&base=zju01&doc_number=" 
				+ doc_number;
		list = BooksStatusXMLParse.parse(getBookStatusUrl);
		
		statusListView = (ListView) findViewById(R.id.statusList);
		statusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).subLibrary.equals("总馆采访"))
//				statusAdapter.add("总馆采访");
//			if(list.get(i).subLibrary.equals("玉泉理工阅览室"))
//				statusAdapter.add("玉泉理工阅览室");
//			if(list.get(i).subLibrary.equals("玉泉样本书库"))
//				statusAdapter.add("玉泉样本书库");
//			if(list.get(i).subLibrary.equals("浙江大学图书馆存储馆"))
//				statusAdapter.add("浙江大学图书馆存储馆");
//			if(list.get(i).subLibrary.equals("玉泉工具书阅览室"))
//				statusAdapter.add("玉泉工具书阅览室");
//			else {
//				statusAdapter.add("分馆 : " + list.get(i).subLibrary);
//				statusAdapter.add("索书号 : " + list.get(i).collection);
//				/* 是否可借 */
//				if(list.get(i).itemStatus.equals("12"))
//					statusAdapter.add("是否可借 : 可借");
//				else
//					statusAdapter.add("是否可借 : 不可借");
//				/* 是否已经借出 */
//				if(list.get(i).loanStatus.equals("A"))
//					statusAdapter.add("是否已经借出 : 已借出");
//				else
//					statusAdapter.add("是否已经借出 : 尚未借出");
//			}
			statusAdapter.add("分馆【" + i + "】: " + list.get(i).subLibrary);
			if(list.get(i).subLibrary.equals("玉泉流通书库") || list.get(i).equals("紫金港基础流通书库")) {
				statusAdapter.add("索书号 : " + list.get(i).collection);
				/* 是否可借 */
				if(list.get(i).itemStatus.equals("12"))
					statusAdapter.add("是否可借 : 可借");
				else
					statusAdapter.add("是否可借 : 不可借");
				/* 是否已经借出 */
				if(list.get(i).loanStatus.equals("A"))
					statusAdapter.add("是否已经借出 : 已借出");
				else
					statusAdapter.add("是否已经借出 : 尚未借出");
			}
		}
		statusListView.setAdapter(statusAdapter);
	}
}
