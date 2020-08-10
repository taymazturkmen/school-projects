package ex01;

import java.util.Scanner;

public class KeyValueStore {

	Scanner sc = new Scanner(System.in);
	int size;

	boolean keyFound = false;

	public KeyValueStore(int size) {
		this.size = size;
	}

	KeyValuePair[] arrayObjectPairs = new KeyValuePair[20];
	int count;

	public KeyValuePair[] getArrayObjectPairs() {
		return this.arrayObjectPairs;
	}

	public void setArrayObjectPairs(KeyValuePair[] arrayObjectPairs) {
		this.arrayObjectPairs = arrayObjectPairs;
	}

	public String newKVP(String key, String value) {

		for (int i = 0; i < count; i++) {
			if (arrayObjectPairs[i].key.equals(key)) {
				keyFound = true;
				throw new IllegalArgumentException("That key already exists");
			}
		}
		if (keyFound == false) {
			KeyValuePair kvp = new KeyValuePair(key, value);
			arrayObjectPairs[count] = new KeyValuePair(key, value);
			arrayObjectPairs[count] = kvp;
			System.out.println("key " + (count + 1) + " is " + arrayObjectPairs[count].key + ", value is "
					+ arrayObjectPairs[count].value);
			count++;
		}

		keyFound = false;
		return value;
	}

	public String getKVP(String key) {
		String result = "";

		for (int i = 0; i < count; i++) {
			if (arrayObjectPairs[i].key.equals(key)) {
				result = arrayObjectPairs[i].value;
				keyFound = true;
				System.out.println("Your value is " + arrayObjectPairs[i].value);
			}
		}
		if (keyFound == false) {
			throw new IllegalArgumentException("No such key");
		}
		keyFound = false;

		return result;
	}

	public String updateKVP(String key, String newValue) {
		for (int i = 0; i < count; i++) {
			if (arrayObjectPairs[i].key.equals(key)) {
				keyFound = true;
				arrayObjectPairs[i].value = newValue;
				System.out.println("Your new value for " + key + " is " + arrayObjectPairs[i].value);

			}

		}
		if (keyFound == false) {
			throw new IllegalArgumentException("No such key");
		}
		keyFound = false;

		return newValue;

	}

	public String deleteKVP(String key) {
		int counter = 0;
		for (int i = 0; i < count; i++) {
			if (arrayObjectPairs[i].key.equals(key)) {
				counter = i;
				keyFound = true;
				for (int j = i; j < count - 1; j++) {
					keyFound = true;
					arrayObjectPairs[j].key = arrayObjectPairs[j + 1].key;
					arrayObjectPairs[j].value = arrayObjectPairs[j + 1].value;
				}

				arrayObjectPairs[count - 1] = null;
				count--;
			}
		}
		if (keyFound == false) {
			throw new IllegalArgumentException("No such key");
		}
		keyFound = false;
		System.out.println("Pair has been deleted");
		return key;
	}

}
