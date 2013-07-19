package info.mitcc.ilib;

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
		
		listView.setAdapter(detailsAdapter);
		
		Intent intent = getIntent();
		String text = intent.getStringExtra("doc_number");
		detailsAdapter.add(text);
	}
}