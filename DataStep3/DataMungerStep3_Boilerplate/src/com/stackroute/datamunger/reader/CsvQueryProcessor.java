package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {


	BufferedReader br;
	String fileName;

	// Parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName=fileName;
		br= new BufferedReader(new FileReader(fileName));
	}

	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 * Note: Return type of the method will be Header
	 */
	
	@Override
	public Header getHeader() throws IOException {

		Header h1=new Header();
		br= new BufferedReader(new FileReader(fileName));
		String line1=br.readLine();
		String[] l1=line1.split(",");
		h1.setStr(l1);
		// read the first line

		// populate the header object with the String array containing the header names
		return h1;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */
	
	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. 
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		br= new BufferedReader(new FileReader(fileName));
		br.readLine();
		String s = br.readLine();

		String[] str = s.split(",", -1);
		String[] dt = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			dt[i] = findDataType(str[i]).getClass().getName();
		}

		DataTypeDefinitions dtd = new DataTypeDefinitions(dt);
		return dtd;

	}

	private Object findDataType (String value)
	{
		try{
		if (value.isEmpty())
		{
			return  value.getClass().getName();
		}

		Integer i = Integer.parseInt(value);

			return i;
		}
		catch (NumberFormatException e)
		{
			return value;
		}
	}

}
