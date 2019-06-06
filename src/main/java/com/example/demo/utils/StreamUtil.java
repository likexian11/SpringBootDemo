package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class StreamUtil {
    private static final String TAG = "StreamUtil";

    private StreamUtil() {
    }

    public static void sendInt(OutputStream os, int intValue) throws IOException {
        os.write(ByteUtil.getBytes(intValue));
        os.flush();
    }

    public static void sendString(OutputStream os, String stringValue) throws IOException {
        byte[] bytes = stringValue.getBytes("UTF-8");
        // 发送字符串字节数组长度
        sendInt(os, bytes.length);
        // 发送字符串内容
        os.write(bytes);
        os.flush();
    }

    public static int receiveInt(InputStream is) throws IOException {
        byte[] bytes = new byte[4];
        is.read(bytes);
        return ByteUtil.getInt(bytes);
    }

    public static String receiveString(InputStream is) throws IOException {
        // 接收字符串长度
        int length = receiveInt(is);
        // 接收字符串内
        byte[] results = new byte[length];
        is.read(results);
        return new String(results, "UTF-8");
    }

    public static int readInt(ByteArrayInputStream bais) throws IOException {
        byte[] ints = new byte[4];
        bais.read(ints);
        return ByteUtil.getInt(ints);
    }

    public static String readString(InputStream ins) throws IOException {
        byte[] lens = new byte[2];
        ins.read(lens);
        byte[] strs = new byte[ByteUtil.getShort(lens)];
        ins.read(strs);
        return new String(strs, "UTF-8");
    }

    public static void writeInt(ByteArrayOutputStream baos, int intValue) throws IOException {
        baos.write(ByteUtil.getBytes(intValue));
    }

    public static void writeString(ByteArrayOutputStream baos, String stringValue) throws IOException {
        byte[] strs = null;
        try {
            strs = stringValue.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // can not reachable
        }
        baos.write(ByteUtil.getBytes((short) strs.length));
        baos.write(strs);
    }

    public static void close(Closeable stream, String errMsg) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                //Logger.e(TAG, errMsg);
            }
        }
    }

	public static void io(InputStreamReader inputStreamReader, StringWriter writer) {
		int result = 0 ;
		try {
			while( (result = inputStreamReader.read()) != -1){  //一次只读一个字符
				writer.write( result ); //一次只写一个字符
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
