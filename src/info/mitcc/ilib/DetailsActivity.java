package info.mitcc.ilib;

import info.mitcc.bean.Book;
import info.mitcc.bean.BookStatus;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailsActivity extends Activity {
	ListView listView;
	ArrayAdapter<String> detailsAdapter;
	List<BookStatus> statusList;
	Book book;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.details);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
		
		listView = (ListView) findViewById(R.id.detailsListView);
		detailsAdapter = new ArrayAdapter<String>(this, R.layout.list_item_2);
		
		Intent intent = getIntent();
		book = (Book) intent.getSerializableExtra("book");
		detailsAdapter.add("���� : " + book.bookName);
		detailsAdapter.add("���� : " + book.author);
		detailsAdapter.add("ͼ���� : " + book.doc_number);
		detailsAdapter.add("������ : " + book.press);
		
		listView.setAdapter(detailsAdapter);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			Intent intent = new Intent(DetailsActivity.this, BookStatusActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("status", book.doc_number);
			startActivity(intent);
		}
		return true;
	}	
}