package javaBasic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileOutputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			fileOutputStreamTest("fileOutputTest1.txt");
			fileWriterTest("fileOutputTest2.txt");
			printWriterTest("fileOutputTest3.txt");
			outputStreamWriterTest("fileOutputTest4.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void outputStreamWriterTest(String pathname)
			throws IOException {
		// TODO Auto-generated method stub
		File file = new File(pathname);
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		for (int i = 0; i < 10; i++) {
			osw.write("outputStreamTest");
			osw.append('\n');
		}
		osw.close();

	}

	private static void printWriterTest(String pathname) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(pathname);
		PrintWriter pw = new PrintWriter(file);
		for (int i = 0; i < 10; i++) {
			pw.write("printWriterTest");
			pw.println();
		}
		pw.close();

	}

	private static void fileWriterTest(String pathname) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(pathname);
		FileWriter fw = new FileWriter(file);
		for (int i = 0; i < 10; i++) {
			fw.write("fileWriterTest");
			fw.append('\n');
		}
		fw.close();

	}

	private static void fileOutputStreamTest(String pathname)
			throws IOException {
		// TODO Auto-generated method stub
		File file = new File(pathname);
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for (int i = 0; i < 10; i++) {
			bw.write("fileOutputStreamTest");
			bw.newLine();
		}
		bw.close();

	}

}
