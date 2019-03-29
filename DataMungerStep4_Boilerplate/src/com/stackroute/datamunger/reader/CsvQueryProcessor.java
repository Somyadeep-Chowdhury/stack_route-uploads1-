package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	BufferedReader br;
	String fileName;

	/*
	 * parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName=fileName;
		br= new BufferedReader(new FileReader(fileName));
	
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */
	@Override
	public Header getHeader() throws IOException {
		//Header h1=new Header();
		br= new BufferedReader(new FileReader(fileName));
		String line1=br.readLine();
		String[] l1=line1.split(",");

		// TODO Auto-generated method stub
		return new Header(l1);
	}
	

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {

		//br= new BufferedReader(new FileReader(fileName));
		//br.readLine();
		String s = br.readLine();

		String[] str = s.split(",", -1);
		String[] dt = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			dt[i] = findDataType(str[i]).getClass().getName();
		}

		DataTypeDefinitions dtd = new DataTypeDefinitions(dt);
		return dtd;
		// TODO Auto-generated method stub
		
		// checking for Integer
		
		// checking for floating point numbers
				
		// checking for date format dd/mm/yyyy
		
		// checking for date format mm/dd/yyyy
		
		// checking for date format dd-mon-yy
		
		// checking for date format dd-mon-yyyy
		
		// checking for date format dd-month-yy
		
		// checking for date format dd-month-yyyy
		
		// checking for date format yyyy-mm-dd

	}

	private Object findDataType (String value)
	{
		Object ob= new Object();
		if(Pattern.matches("[0-9]+",value))
		{
			ob=Integer.parseInt(value);
		}
		else if(Pattern.matches("[a-zA-Z ]+",value))
		{
			ob=value;
		}
		else if(Pattern.matches("[+-]?([0-9]*[.])?[0-9]+",value))
		{
			ob=Float.parseFloat(value);
		}
		else if(Pattern.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}",value))
		{
			if(Integer.parseInt(value.split("/")[0])<31 && Integer.parseInt(value.split("/")[1])<=12)
			{
				try {
					ob=new SimpleDateFormat("dd/mm/yyyy").parse(value);
				}catch (ParseException e)
				{
					e.printStackTrace();
				}
			}else
			{
				try {
					ob=new SimpleDateFormat("mm/dd/yyyy").parse(value);
				}catch (ParseException e)
				{
					e.printStackTrace();
				}
			}

		}
		else if(Pattern.matches("[0-9]{2}-[a-zA-Z]{3}-[0-9]{2}",value))
		{
			try {
				ob=new SimpleDateFormat("dd-mon-yy").parse(value);
			}catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		else if(Pattern.matches("[0-9]{2}-[a-zA-Z]{3}-[0-9]{2}",value))
		{
			try {
				ob = new SimpleDateFormat("dd-mon-yy").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(Pattern.matches("[0-9]{2}-[a-zA-Z]{3}-[0-9]{4}",value))
		{
			try {
				ob = new SimpleDateFormat("dd-mon-yyyy").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(Pattern.matches("[0-9]{2}-[a-zA-Z]{3}-[0-9]{2}",value)) {
			try {
				ob = new SimpleDateFormat("dd-mon-yy").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(Pattern.matches("[0-9]{2}-[a-zA-Z]{3,11}-[0-9]{2}",value)) {
			try {
				ob = new SimpleDateFormat("dd-month-yy").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(Pattern.matches("[0-9]{2}-[a-zA-Z]{3,11}-[0-9]{4}",value)) {
			try {
				ob = new SimpleDateFormat("dd-month-yyyy").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(Pattern.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}",value)) {
			try {
				ob = new SimpleDateFormat("yyyy-mm-dd").parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			return ob;
	}
}
