package codingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;

	Interval() {
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervalList = new ArrayList<Interval>();
		intervalList.add(new Interval(2, 6));
		intervalList.add(new Interval(1, 3));
		intervalList.add(new Interval(6, 8));
		intervalList.add(new Interval(12, 16));
		intervalList.add(new Interval(8, 10));
		ArrayList<Interval> mergedList = mergeInterval(intervalList);
		for (int i = 0; i < mergedList.size(); i++) {
			Interval interval = mergedList.get(i);
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		}
		System.out.println();
	}

	/**
	 * key : construct a data structure to store the interval data. construct a class Interval
	 * @param intervalList
	 * @return
	 */
	private static ArrayList<Interval> mergeInterval(
			ArrayList<Interval> intervalList) {
		// TODO Auto-generated method stub
		if (intervalList == null || intervalList.size() <= 1) {
			return intervalList;
		}

		Collections.sort(intervalList, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervalList.get(0);
		for (int i = 1; i < intervalList.size(); i++) {
			Interval cur = intervalList.get(i);
			if (prev.end >= cur.start) {
				Interval merged = new Interval(prev.start, Math.max(prev.end,
						cur.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = cur;
			}
		}
		result.add(prev);
		return result;
	}

}
