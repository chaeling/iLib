package info.mitcc.ilib;

import info.mitcc.bean.Books;
import info.mitcc.bean.SetNumberBean;
import info.mitcc.sax.BooksInfoXMLParse;
import info.mitcc.sax.SetNumberXMLParse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class iLibActivity extends Activity {
	Button searchBtn;
	EditText searchContent;
	TextView tv;
	ListView listView;
	ArrayAdapter<String> listAdapter;
	Books books;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        searchBtn = (Button) findViewById(R.id.submitBtn);
        searchContent = (EditText) findViewById(R.id.search_content);
        tv = (TextView) findViewById(R.id.tv);
        
        listView = (ListView) findViewById(R.id.mainListView);
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        
        searchBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				listAdapter.clear();
				String getSetNumberUrl = null;
				try {
					getSetNumberUrl = "http://10.10.16.94/X?op=find&base=zju01&code=wrd&request="
							+ URLEncoder.encode(searchContent.getText().toString(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				SetNumberBean setNumberBean = SetNumberXMLParse.parse(getSetNumberUrl);

				String getBooksInfoUrl = "http://10.10.16.94/X?op=present&set_no=" + setNumberBean.getSet_number()
						+ "&set_entry=01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30&format=marc";
				books = BooksInfoXMLParse.parse(getBooksInfoUrl);
				for(int i = 0; i < books.books.size(); i++)
					listAdapter.add(books.books.get(i).bookName);
			}
		});
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(iLibActivity.this, DetailsActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("book", books.getBooks().get(position));
				startActivity(intent);
			}
		});
    }
}