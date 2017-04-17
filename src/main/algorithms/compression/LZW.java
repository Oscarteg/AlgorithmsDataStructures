package main.algorithms.compression;

import java.util.ArrayList;

/**
 * Created by Oscar and Guus on 13/04/2017.
 */

public class LZW {
	private static int counter = 256;
	private static int counter2 = 256;

	public static ArrayList<Integer> compress(String text) {
		String[] dictionary = createDictionary();
		String previous = "";
		ArrayList<Integer> compressed = new ArrayList<>();

		for (char current : text.toCharArray()) {

			int index = getIndex(previous + current, dictionary);
			if (index != -1) {
				previous = previous + current;
			} else {
				compressed.add(getIndex(previous, dictionary));
				dictionary[counter] = previous + current;
				counter++;
				previous = current + "";
			}
		}
		compressed.add(getIndex(previous, dictionary));
		return compressed;
	}

	public static String decompress(ArrayList<Integer> compressed) {
		String[] dictionary = createDictionary();
		Integer previousIndex = -1;
		String uncompressed = "";

		for (Integer currentIndex : compressed) {
			String currentValue = getString(currentIndex, dictionary);
			uncompressed += currentValue;

			String previousValue = getString(previousIndex, dictionary);
			if (getIndex(previousValue + currentValue, dictionary) == -1) {
				dictionary[counter2] = previousValue + (currentValue.substring(0, 1));
				counter2++;
			}

			previousIndex = currentIndex;

		}

		return uncompressed;
	}

	private static String[] createDictionary() {
		String[] dic = new String[4096];
		for (int i = 0; i <= 255; i++) {
			dic[i] = (char) i + "";
		}
		return dic;
	}

	private static String getString(Integer searchIndex, String[] dictionary) {
		return searchIndex != -1 ? dictionary[searchIndex] : "";
	}

	private static int getIndex(String searchInput, String[] dictionary) {
		try {
			for (int i = 0; i < counter - 1; i++) {
				if (dictionary[i].equals(searchInput)) {
					return i;
				}

			}
			return -1;
		} catch (Exception e) {
			return -1;
		}
	}
}