package info.mitcc.ilib;

import info.mitcc.bean.BookBean;
import info.mitcc.bean.Books;
import info.mitcc.bean.SetNumberBean;
import info.mitcc.sax.BookInfoXMLParse;
import info.mitcc.sax.BooksInfoXMLParse;
import info.mitcc.sax.SetNumberXMLParse;
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
	
//	BookBean bookBean;
	Books newBookBean;
	
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
				String getSetNumberUrl = "http://10.10.16.94/X?op=find&base=zju01&code=wrd&request="
						+ searchContent.getText().toString();
//				String set_number = HttpClientConnector.getStringByUrl(getSetNumberUrl);
				SetNumberBean setNumberBean = SetNumberXMLParse.parse(getSetNumberUrl);
				
//				String getDocNumberUrl = "http://10.10.16.94/X?op=present&set_no=" + setNumberBean.getSet_number()
//						+ "&set_entry=000000001,000000002,03,04,05&format=marc";
//				String doc_number = HttpClientConnector.getStringByUrl(getDocNumberUrl);
//				docNumberBean = DocNumberXMLParse.parse(doc_number);
				
				String getBooksInfoUrl = "http://10.10.16.94/X?op=present&set_no=" + setNumberBean.getSet_number()
						+ "&set_entry=000000001,000000002,03,04,05&format=marc";
//				String booksInfosXml = HttpClientConnector.getStringByUrl(getBooksInfoUrl);
//				System.out.println("booksInfosXml = " + booksInfosXml);
				
//				bookBean = BookInfoXMLParse.parse(getBooksInfoUrl);
				
				newBookBean = BooksInfoXMLParse.parse(getBooksInfoUrl);
				
//				listAdapter.add("set_number : " + setNumberBean.getSet_number());
				
//				for(int i = 0; i < docNumberBean.getDoc_number().size(); i++) {
//					listAdapter.add("doc_number[" + i + "] : " + docNumberBean.getDoc_number().get(i));
//				}
				
//				for(int i = 0; i < bookBean.getDoc_number().size(); i++) 
//					listAdapter.add("Name[" + i + "] : " + bookBean.getBookName().get(i));
				
				for(int i = 0; i <newBookBean.books.size(); i++)
					listAdapter.add("Name[" + i + "] : " + newBookBean.books.get(i).bookName);
			}
		});
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(iLibActivity.this, DetailsActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				intent.putExtra("doc_number", bookBean.getBookName().get(position).toString());
				intent.putExtra("doc_number", newBookBean.books.get(position).bookName);
				startActivity(intent);
			}
		});
    }
}