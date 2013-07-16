package info.mitcc.ilib;

import info.mitcc.bean.DocNumberBean;
import info.mitcc.bean.SetNumberBean;
import info.mitcc.http.HttpClientConnector;
import info.mitcc.sax.DocNumberXMLParse;
import info.mitcc.sax.SetNumberXMLParse;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class iLibActivity extends Activity {
	Button searchBtn;
	EditText searchContent;
	TextView tv;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        searchBtn = (Button) findViewById(R.id.submitBtn);
        searchContent = (EditText) findViewById(R.id.search_content);
        tv = (TextView) findViewById(R.id.tv);
        
        
        
        searchBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String showText = null;
				String getSetNumberUrl = "http://10.10.16.94/X?op=find&base=zju01&code=wrd&request="
						+ searchContent.getText().toString();
				String set_number = HttpClientConnector.getStringByUrl(getSetNumberUrl);
				SetNumberBean setNumberBean = SetNumberXMLParse.parse(set_number);
				showText = "set_number: " + setNumberBean.getSet_number() + "\n";
				
				String getDocNumberUrl = "http://10.10.16.94/X?op=present&set_no=" + setNumberBean.getSet_number()
						+ "&set_entry=000000001,000000002,03,04,05&format=marc";
				String doc_number = HttpClientConnector.getStringByUrl(getDocNumberUrl);
				DocNumberBean docNumberBean = DocNumberXMLParse.parse(doc_number);
				
//				showText += "doc_number: " + docNumberBean.getDoc_number() + "\n";
				for(int i = 0; i < docNumberBean.getDoc_number().size(); i++)
					showText += "doc_number[" + i + "] :" + docNumberBean.getDoc_number().get(i) + "\n";
				
				if(setNumberBean != null)
					tv.setText(showText);
				
			}
		});
    }
}
