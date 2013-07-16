package info.mitcc.http;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class HttpClientConnector {
	public static String getStringByUrl(String url) {
		String outputString = "";
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		try {
			outputString = httpClient.execute(httpGet, responseHandler);
			Log.i("iLib", "Connect successfully!");
		} catch (Exception e) {
			Log.i("iLab", "Connect failed!");
		}
		httpClient.getConnectionManager().shutdown();
		return outputString;
	}
}
