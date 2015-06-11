package moreAboutJava;

import java.io.File;
import java.io.IOException;

public class FileDirOperationsTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("dirCreationTest");
		boolean isExist = dir.mkdir();
		if (!isExist && dir.isDirectory() && dir.listFiles().length == 0) {
			System.out.println("an empty directory");
			if (dir.delete()) {
				System.out.println("delete");
			} else {
				System.out.println("not delete");
			}
		} else if (!isExist && dir.isDirectory()) {
			System.out.println("not empty directory");
			File[] listFiles = dir.listFiles();
			for (File f : listFiles) {
				f.delete();
			}
		} else if (isExist) {
			System.out.println("not exist");
			System.exit(0);
		}
		dir.mkdir();

		for (int i = 0; i < 10; i++) {
			File file = new File(dir, "fileCreationTest" + i);
			file.createNewFile();
		}

		// file.delete();

		File[] fileList = dir.listFiles();
		for (File f : fileList) {
			System.out.println(f);
		}
		
	}

}
