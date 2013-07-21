package info.mitcc.ilib;

import info.mitcc.bean.BookStatus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookStatusActivity extends Activity {
	ListView statusListView;
	ArrayAdapter<String> statusAdapter;
	BookStatus bookStatus;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);
		
		Intent intent = getIntent();
		bookStatus = (BookStatus) intent.getSerializableExtra("status");
		
		statusListView = (ListView) findViewById(R.id.statusList);
		statusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		if(bookStatus.subLibrary.equals("总馆采访"))
			statusAdapter.add("该书目正在采购中…");
		else {
			statusAdapter.add("分馆 : " + bookStatus.subLibrary);
			statusAdapter.add("索书号 : " + bookStatus.collection);
			/* 是否可借 */
			if(bookStatus.itemStatus.equals("12"))
				statusAdapter.add("是否可借 : 可借");
			else
				statusAdapter.add("是否可借 : 不可借");
			/* 是否已经借出 */
			if(bookStatus.loanStatus.equals("A"))
				statusAdapter.add("是否已经借出 : 已借出");
			else
				statusAdapter.add("是否已经借出 : 尚未借出");
			
			statusListView.setAdapter(statusAdapter);
		}
	}
}
