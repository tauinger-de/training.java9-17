package jj.appl;

import java.lang.reflect.Field;

import jj.util.log.Log;

public class Application {

	public static void main(String args[]) throws Exception {
		demoLatin1();
		demoUTF16();
		demoPerformance();
	}

	static void demoLatin1() throws Exception {
		Log.logMethodCall();
		inspect(new char[] { 'a', 'b', 'c' });
	}

	static void demoUTF16() throws Exception {
		Log.logMethodCall();
		inspect(new char[] { 500, 501, 502 });
	}

	private static void inspect(char[] content) throws NoSuchFieldException, IllegalAccessException {
		Class<?> cls = String.class;
		Field fieldValue = cls.getDeclaredField("value");
		Field fieldCoder = cls.getDeclaredField("coder");
		fieldValue.setAccessible(true);
		fieldCoder.setAccessible(true);
		System.out.println(fieldValue);
		System.out.println(fieldCoder);
		String s = String.valueOf(content);
		byte[] value = (byte[])fieldValue.get(s);
		System.out.println(value.length);
		for(byte v : value) 
			System.out.print((char)v);
		System.out.println();
		byte coder = (byte)fieldCoder.get(s);
		System.out.println(coder);
	}
	
	static void demoPerformance() throws Exception {
		Log.logMethodCall();
		System.out.println("running...");
		final int N = 10000;
		final int M = 5000;
		final int SIZE = 256;
		int n1 = 0;
		int n2 = 0;
		int duration1 = 0;
		int duration2 = 0;
		// Latin1-chars
		char[] array1 = new char[SIZE];
		for(int i = 0; i < SIZE; i++) 
			array1[i] = (char)i;
		// UTF16-chars
		char[] array2 = new char[SIZE];
		for(int i = 0; i < SIZE; i++) 
			array2[i] = (char)(i + SIZE);
		final String string1A = new String(array1);
		final String string1B = new String(array1);
		final String string2A = new String(array2);
		final String string2B = new String(array2);
		for(int i = 0; i < N; i++) {
			{
				long start = System.nanoTime();
				for(int j = 0; j < M; j++)
					n1 += string1A.compareTo(string1B);
				duration1 += (System.nanoTime() - start);
			}
			{
				long start = System.nanoTime();
				for(int j = 0; j < M; j++)
					n2 += string2A.compareTo(string2B);
				duration2 += (System.nanoTime() - start);
			}
		}
		System.out.println(n1);
		System.out.println(n2);
		System.out.println("Latin1 : " + duration1);
		System.out.println("UTF16  : " + duration2);
	}
	
	/*
    String(char[] value, int off, int len, Void sig) {
        if (len == 0) {
            this.value = "".value;
            this.coder = "".coder;
            return;
        }
        if (COMPACT_STRINGS) {
            byte[] val = StringUTF16.compress(value, off, len);
            if (val != null) {
                this.value = val;
                this.coder = LATIN1;
                return;
            }
        }
        this.coder = UTF16;
        this.value = StringUTF16.toBytes(value, off, len);
    }
	 */
}