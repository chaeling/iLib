package info.mitcc.ilib;

import info.mitcc.bean.Book;
import info.mitcc.bean.BookStatus;
import info.mitcc.sax.BookStatusXMLParse;
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
	BookStatus bookStatus;
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
		
		String getBookStatusUrl = "http://10.10.16.94/X?op=item-data&base=zju01&doc_number=" 
				+ book.doc_number;
		bookStatus = BookStatusXMLParse.parse(getBookStatusUrl);
		
		System.out.println("bookStatus.subLibrary = " + bookStatus.subLibrary);
		System.out.println("bookStatus.collection = " + bookStatus.collection);
		System.out.println("bookStatus.itemStatus = " + bookStatus.itemStatus);
		System.out.println("bookStatus.loanStatus = " + bookStatus.loanStatus);
		System.out.println("bookStatus.loanDueDate = " + bookStatus.loanDueDate);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(DetailsActivity.this, BookStatusActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("status", bookStatus);
				startActivity(intent);
			}
		});
	}
}