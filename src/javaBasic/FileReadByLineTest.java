package javaBasic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadByLineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File(".");
		File file = null;
		try {
			file = new File(dir.getCanonicalPath() + File.separator
					+ "test.txt");
			String pathString = file.getPath();
			Path path = Paths.get(pathString);
			fileRead1(file);
			fileRead2(file);
			fileRead3(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fileRead3(Path path) {
		// TODO Auto-generated method stub
		Charset charSet = Charset.forName("utf8");
		try {
			BufferedReader br = Files.newBufferedReader(path, charSet);
			String line;
			System.out.println(">>> fileRead3");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fileRead2(File file) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			System.out.println(">>> fileRead2");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fileRead1(File file) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			System.out.println(">>> fileRead1");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
