package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// construct a map
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("SCU", "Sichuang University");
		map.put("USTC", "University of Science and Technology of China");
		map.put("THU", "Tsinghua University");
		map.put("PKU", "Peking University");
		map.put("ZJU", "Zhejiang University");
		System.out.println(map);

		// convert map to arraylist
		/**
		 * ArrayList<String> keyList = new ArrayList<>(map.keySet());
		 * ArrayList<String> valueList = new ArrayList<>(map.values());
		 * ArrayList<Entry<String, String>> entryList = new
		 * ArrayList<>(map.entrySet()); System.out.println(keyList);
		 * System.out.println(valueList); System.out.println(entryList);
		 **/

		/**
		 * iterate over each entry in a map
		 */
		/**
		 * // most efficient for (Entry<String, String> entry : map.entrySet())
		 * { String key = entry.getKey(); String value = entry.getValue();
		 * System.out.println(key + "=" + value); }
		 * 
		 * // also can be like this Iterator<Entry<String, String>> iterator =
		 * map.entrySet().iterator(); while (iterator.hasNext()) { Entry<String,
		 * String> entry = iterator.next(); String key = entry.getKey(); String
		 * value = entry.getValue(); System.out.println(key + "=" + value); }
		 **/

		/**
		 * sort a map on the keys
		 */
		/**
		// convert map to arraylist, and using a comparator
		List<Entry<String, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				Entry<String, String> e1 = (Entry<String, String>) o1;
				Entry<String, String> e2 = (Entry<String, String>) o2;
				return ((String) e1.getKey()).compareTo((String) e2.getKey());
			}

		});
		System.out.println(entryList);

		// sortedmap : new treemap
		SortedMap<String, String> sortedMap = new TreeMap<String, String>(
				new Comparator<String>() {

					@Override
					public int compare(String k1, String k2) {
						// TODO Auto-generated method stub
						return k1.compareTo(k2);
					}
				});
		sortedMap.putAll(map);
		System.out.println(sortedMap);
		**/
		
		/**
		 * sort a map on values
		 */
		List<Entry<String,String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Entry>() {

			@Override
			public int compare(Entry e1, Entry e2) {
				// TODO Auto-generated method stub
				return ((String)e1.getValue()).compareTo((String)e2.getValue());
			}
			
		});
		System.out.println(entryList);

	}

}
