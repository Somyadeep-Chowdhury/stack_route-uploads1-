package com.stackroute.datamunger.query;

//header class
public class Header {

	private String[] str;

	public Header(String[] str) {
		this.str = str;
	}

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the headers and should override toString() method.
	 */
	public String[] getHeaders() {
		return str;
	}

}
