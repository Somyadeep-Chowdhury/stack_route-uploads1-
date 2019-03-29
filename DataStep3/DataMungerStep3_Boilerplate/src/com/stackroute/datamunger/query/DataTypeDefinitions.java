package com.stackroute.datamunger.query;

public class DataTypeDefinitions {

	private String[] s;

	public DataTypeDefinitions(String[] s) {
		this.s = s;
	}

	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */

	public String[] getDataTypes() {
		return s;
	}

}