package ex01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class KVPInputStream extends InputStream {
	FileInputStream fileIn;
	int keyLength;
	int valueLength;
	String key = "";
	String value = "";
	int divisor = 0;
	KeyValueStore kvs = new KeyValueStore(20);

	@Override
	public int read() throws IOException {
		// Kann ignoriert werden
		return 0;
	}

	public void readKVP() throws IOException {
		fileIn = new FileInputStream("ex01/test.txt");
		byte bArray[] = new byte[fileIn.available()];
		fileIn.read(bArray);
		String input = new String(bArray);

		if(input.charAt(0) != ' ' ){
			System.out.println("Saved Storage Found!, importing...");
			while (divisor != bArray.length) {
				keyLength = bArray[divisor];
				valueLength = bArray[divisor + 1];
				for (int i = divisor+2; i < divisor+2+keyLength; i++) {
					key += input.charAt(i);
				}
				for (int i = divisor + keyLength + 2; i <  divisor + keyLength + valueLength + 2; i++) {
					value += input.charAt(i);
				}
				kvs.newKVP(key, value);
				key = "";
				value = "";
				divisor += keyLength + valueLength + 2;
	
	
			}
		}


	}

	public KeyValueStore getKvs() {
		return this.kvs;
	}

	public void setKvs(KeyValueStore kvs) {
		this.kvs = kvs;
	}

}
