package info.mitcc.ilib;

import java.util.*;

import info.mitcc.bean.BookStatus;
import info.mitcc.sax.BooksStatusXMLParse;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookStatusActivity extends Activity {
	ListView statusListView;
	ArrayAdapter<String> statusAdapter;
	int doc_number;
	List<BookStatus> list;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);
		
		Intent intent = getIntent();
		doc_number =(Integer) intent.getSerializableExtra("status");
		String getBookStatusUrl = "http://10.10.16.94/X?op=item-data&base=zju01&doc_number=" 
				+ doc_number;
		list = BooksStatusXMLParse.parse(getBookStatusUrl);
		
		statusListView = (ListView) findViewById(R.id.statusList);
		statusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).subLibrary.equals("�ܹݲɷ�"))
//				statusAdapter.add("�ܹݲɷ�");
//			if(list.get(i).subLibrary.equals("��Ȫ��������"))
//				statusAdapter.add("��Ȫ��������");
//			if(list.get(i).subLibrary.equals("��Ȫ�������"))
//				statusAdapter.add("��Ȫ�������");
//			if(list.get(i).subLibrary.equals("�㽭��ѧͼ��ݴ洢��"))
//				statusAdapter.add("�㽭��ѧͼ��ݴ洢��");
//			if(list.get(i).subLibrary.equals("��Ȫ������������"))
//				statusAdapter.add("��Ȫ������������");
//			else {
//				statusAdapter.add("�ֹ� : " + list.get(i).subLibrary);
//				statusAdapter.add("����� : " + list.get(i).collection);
//				/* �Ƿ�ɽ� */
//				if(list.get(i).itemStatus.equals("12"))
//					statusAdapter.add("�Ƿ�ɽ� : �ɽ�");
//				else
//					statusAdapter.add("�Ƿ�ɽ� : ���ɽ�");
//				/* �Ƿ��Ѿ���� */
//				if(list.get(i).loanStatus.equals("A"))
//					statusAdapter.add("�Ƿ��Ѿ���� : �ѽ��");
//				else
//					statusAdapter.add("�Ƿ��Ѿ���� : ��δ���");
//			}
			statusAdapter.add("�ֹݡ�" + i + "��: " + list.get(i).subLibrary);
			if(list.get(i).subLibrary.equals("��Ȫ��ͨ���") || list.get(i).equals("�Ͻ�ۻ�����ͨ���")) {
				statusAdapter.add("����� : " + list.get(i).collection);
				/* �Ƿ�ɽ� */
				if(list.get(i).itemStatus.equals("12"))
					statusAdapter.add("�Ƿ�ɽ� : �ɽ�");
				else
					statusAdapter.add("�Ƿ�ɽ� : ���ɽ�");
				/* �Ƿ��Ѿ���� */
				if(list.get(i).loanStatus.equals("A"))
					statusAdapter.add("�Ƿ��Ѿ���� : �ѽ��");
				else
					statusAdapter.add("�Ƿ��Ѿ���� : ��δ���");
			}
		}
		statusListView.setAdapter(statusAdapter);
	}
}
