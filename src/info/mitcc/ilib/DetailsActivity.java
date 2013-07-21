package info.mitcc.ilib;

import java.util.*;

import info.mitcc.bean.Book;
import info.mitcc.bean.BookStatus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		setContentView(R.layout.details);
		
		listView = (ListView) findViewById(R.id.detailsListView);
		detailsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		Intent intent = getIntent();
		book = (Book) intent.getSerializableExtra("book");
		detailsAdapter.add("书名 : " + book.bookName);
		detailsAdapter.add("作者 : " + book.author);
		detailsAdapter.add("图书编号 : " + book.doc_number);
		detailsAdapter.add("出版社 : " + book.press);
		
		listView.setAdapter(detailsAdapter);
		
//		String getBookStatusUrl = "http://10.10.16.94/X?op=item-data&base=zju01&doc_number=" 
//				+ book.doc_number;
//		bookStatus = BookStatusXMLParse.parse(getBookStatusUrl);

		
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(DetailsActivity.this, BookStatusActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("status", book.doc_number);
				startActivity(intent);
			}
		});
	}
}