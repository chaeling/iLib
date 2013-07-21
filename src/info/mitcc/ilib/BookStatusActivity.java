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
		if(bookStatus.subLibrary.equals("�ܹݲɷ�"))
			statusAdapter.add("����Ŀ���ڲɹ��С�");
		else {
			statusAdapter.add("�ֹ� : " + bookStatus.subLibrary);
			statusAdapter.add("����� : " + bookStatus.collection);
			/* �Ƿ�ɽ� */
			if(bookStatus.itemStatus.equals("12"))
				statusAdapter.add("�Ƿ�ɽ� : �ɽ�");
			else
				statusAdapter.add("�Ƿ�ɽ� : ���ɽ�");
			/* �Ƿ��Ѿ���� */
			if(bookStatus.loanStatus.equals("A"))
				statusAdapter.add("�Ƿ��Ѿ���� : �ѽ��");
			else
				statusAdapter.add("�Ƿ��Ѿ���� : ��δ���");
			
			statusListView.setAdapter(statusAdapter);
		}
	}
}
