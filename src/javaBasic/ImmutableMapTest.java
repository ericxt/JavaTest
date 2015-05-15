package javaBasic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapTest {
	// real immutable map initialization
	private static final Map immutableMap;
	static {
		Map amap = new HashMap();
		amap.put(1, "one");
		amap.put(2, "two");
		immutableMap = Collections.unmodifiableMap(amap);
	}

	// fake immutable map initialization
	private static final Map notImmutableMap;
	static {
		notImmutableMap = new HashMap();
		notImmutableMap.put(1, "one");
		notImmutableMap.put(2, "two");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			immutableMap.put(3, "three");
			System.out.println(immutableMap);
		} finally {
			notImmutableMap.put(3, "three");
			System.out.println("notImmutableMap " + notImmutableMap);
		}

	}

}
