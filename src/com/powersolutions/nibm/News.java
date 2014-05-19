package com.powersolutions.nibm;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class News extends ListActivity{

	Document doc = null;
	String xml;
	
	static final String KEY_ITEM = "item"; // parent node
	static final String KEY_ID = "title";
	static final String KEY_NAME = "content";
	static final String KEY_LINK = "link";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newslist);
		init();
	}

	public final String getElementValue(Node elem) {
		Node child;
		if (elem != null) {
			if (elem.hasChildNodes()) {
				for (child = elem.getFirstChild(); child != null; child = child
						.getNextSibling()) {
					if (child.getNodeType() == Node.TEXT_NODE) {
						return child.getNodeValue();
					}
				}
			}
		}
		return "";
	}
	
	public String getValue(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);
		return this.getElementValue(n.item(0));
	}

	private void init() {

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		// get xml string from url
		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(
					"http://sharkz91.0fees.us/news.xml");

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);

		} catch (ParserConfigurationException e) {
			Log.e("Error: ", e.getMessage());
			// return null;
		} catch (SAXException e) {
			Log.e("Error: ", e.getMessage());
			// return null;
		} catch (IOException e) {
			Log.e("Error: ", e.getMessage());
			// return null;
		}

		NodeList nl = doc.getElementsByTagName(KEY_ITEM);
		// looping through all item nodes <item>
		for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, getValue(e, KEY_ID));
			map.put(KEY_NAME, getValue(e, KEY_NAME));
			//map.put(KEY_LINK, "Rs." + getValue(e, KEY_COST));
			//map.put(KEY_DESC, getValue(e, KEY_DESC));

			// adding HashList to ArrayList
			menuItems.add(map);
		}
		
		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.newsitem,
				new String[] { KEY_ID,KEY_NAME}, new int[] {
						R.id.name, R.id.desciption});

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();
	}

}
