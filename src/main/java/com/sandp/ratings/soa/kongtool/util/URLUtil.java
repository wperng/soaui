package com.sandp.ratings.soa.kongtool.util;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtil {

    public static String getProtocol(String url) throws MalformedURLException {
	URL urlObj = new URL(url);
	return urlObj.getProtocol();
    }
    
    public static String getDomainName(String url) throws MalformedURLException {
	URL urlObj = new URL(url);
	String domain = urlObj.getHost();
	return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
    
    public static int getPort(String url) throws MalformedURLException  {
	
	URL urlObj = new URL(url);
	int port = urlObj.getPort();
	if(port == -1) {
	    port = urlObj.getDefaultPort();
	}
	   
	return port;
    }
    
    public static String getPath(String url) throws MalformedURLException  {
	
	URL urlObj = new URL(url);
	return urlObj.getPath();
    }
  
    
    public static void main(String[] args) throws Exception {
	System.out.println(URLUtil.getPath("http://api.spglobal.com/test"));
    }

}
