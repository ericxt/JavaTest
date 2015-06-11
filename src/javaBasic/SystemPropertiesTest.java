package javaBasic;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class SystemPropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties sysProperties = System.getProperties();
		Set<Entry<Object, Object>> entrySet = sysProperties.entrySet();
		Iterator<Entry<Object, Object>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<Object, Object> entry = iterator.next();
			System.out.println(entry.getKey() + ">>>" + entry.getValue());
		}

	}

}
