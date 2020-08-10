package ex01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class KVPOutputStream extends OutputStream {
	boolean fileExists = false;
	FileOutputStream outStream;

	@Override
	public void write(int arg0) throws IOException {
		// Kann ignoriert werden
	}

	public void writeKVP(KeyValuePair kvp) throws IOException {
		if (fileExists == false) {
			outStream = new FileOutputStream("test.txt");

				outStream.write(kvp.key.length());
				outStream.write(kvp.value.length());
				outStream.write(kvp.key.getBytes());
				outStream.write(kvp.value.getBytes());
				System.out.println("Progress has been saved!");
				fileExists = true;

			}
		 else {

				outStream.write(kvp.key.length());
				outStream.write(kvp.value.length());
				outStream.write(kvp.key.getBytes());
				outStream.write(kvp.value.getBytes());

			}

		}

	}
