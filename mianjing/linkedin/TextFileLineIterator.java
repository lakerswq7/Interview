package mianjing.linkedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Implement a (Java) Iterable object that iterates lines one by one from a text file..
 */
public class TextFileLineIterator {
	public class TextFile implements Iterable<String> {
		Scanner scanner;
		public TextFile(String fileName) { // please implement this
			try {
				scanner = new Scanner(new File(fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Begin reading the file, line by line. The returned Iterator.next()
		 * will return a line.
		 */
		@Override
		public Iterator<String> iterator() {
			return new Iterator<String>() {

				public boolean hasNext() {
					return scanner.hasNext();
				}

				@Override
				public String next() {
					if (scanner.hasNext()) {
						return scanner.nextLine();
					} else {
						return null;
					}
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
				
			};
		}
	}
	
	/*
	 * 另外一种写法，用BufferedReader
	 */
	public class TextFile2 implements Iterable<String> {

		private BufferedReader br;

		public TextFile2(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		@Override
		public Iterator<String> iterator() {
			return new Iterator<String>() {
				@Override
				public boolean hasNext() {
					try {
						br.mark(1);
						if (br.read() < 0) {
							return false;
						}
						br.reset();
						return true;
					} catch (IOException e) {
						return false;
					}
				}

				@Override
				public String next() {
					try {
						return br.readLine();
					} catch (IOException e) {
						return null;
					}
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

			};
		}
	}
}
