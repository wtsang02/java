package com.wtsang02.java.rquestion.parser.util.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpPostBuilder {
	private String url;
	private List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

	public HttpPostBuilder(String url) {
		this.url = url;
	}

	public void addPair(String name, String value) {
		NameValuePair pair = new BasicNameValuePair(name, value);
		nameValuePairs.add(pair);
	}
	public void addAllPair(Collection<? extends NameValuePair> list){
		nameValuePairs.addAll(list);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<NameValuePair> getNameValuePairs() {
		return nameValuePairs;
	}

	public void setNameValuePairs(List<NameValuePair> nameValuePairs) {
		this.nameValuePairs = nameValuePairs;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("Posting to:");
		sb.append(url+"?");
	
		for(int i=0;i<nameValuePairs.size();i++){
			if(i!=0){
				sb.append("&");
			}
			sb.append(nameValuePairs.get(i).getName()+"="+	nameValuePairs.get(i).getValue());
		}
		
		
		return sb.toString();
	}

}
