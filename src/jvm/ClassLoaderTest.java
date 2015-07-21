package jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				// TODO Auto-generated method stub
				String filename = name.substring(name.lastIndexOf(".") + 1)
						+ ".class";
				InputStream is = getClass().getResourceAsStream(filename);
				if (is == null) {
					return super.loadClass(name);
				}

				byte[] b = null;
				try {
					b = new byte[is.available()];
					is.read(b);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return defineClass(name, b, 0, b.length);
			}
		};
		
		Object obj = myClassLoader.loadClass("jvm.ClassLoaderTest").newInstance();
		
		System.out.println(obj.getClass());
		System.out.println(obj instanceof jvm.ClassLoaderTest);

	}

}
