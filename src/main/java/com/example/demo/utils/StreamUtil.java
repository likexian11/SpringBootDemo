package com.example.demo.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class StreamUtil {

	public static String readString(InputStream ins) throws IOException  {
		int i = -1; 
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        while((i=ins.read())!=-1){ 
        	baos.write(i); 
        } 
       return baos.toString(); 
	}

	public static void io(InputStreamReader inputStreamReader, StringWriter writer) {
		// TODO Auto-generated method stub
		
	}
    
}
