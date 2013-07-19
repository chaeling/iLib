package info.mitcc.ilib;

import info.mitcc.bean.Book;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailsActivity extends Activity {
	ListView listView;
	ArrayAdapter<String> detailsAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		
		listView = (ListView) findViewById(R.id.detailsListView);
		detailsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		Intent intent = getIntent();
		Book book = (Book) intent.getSerializableExtra("book");
		detailsAdapter.add("���� : " + book.bookName);
		detailsAdapter.add("���� : " + book.author);
		detailsAdapter.add("ͼ���� : " + book.doc_number);
		detailsAdapter.add("������ : " + book.press);
		
		listView.setAdapter(detailsAdapter);
	}
}