package codingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervalList = new ArrayList<Interval>();
		intervalList.add(new Interval(1, 3));
		intervalList.add(new Interval(6, 8));
		intervalList.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 7);
		// ArrayList<Interval> result = insertInterval(intervalList,
		// newInterval);
		ArrayList<Interval> result = insert(intervalList, newInterval);
		for (int i = 0; i < result.size(); i++) {
			Interval tmp = result.get(i);
			System.out.print("[" + tmp.start + ", " + tmp.end + "] ");
		}
		System.out.println();
	}

	private static ArrayList<Interval> insert(ArrayList<Interval> intervalList,
			Interval newInterval) {
		// TODO Auto-generated method stub
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval interval : intervalList) {
			if (newInterval.end < interval.start) {
				result.add(newInterval);
				newInterval = interval;
			} else if (newInterval.start > interval.end) {
				result.add(interval);
			} else if (interval.start < newInterval.end
					|| interval.end > newInterval.start) {
				Interval merged = new Interval(Math.min(interval.start,
						newInterval.start), Math.max(interval.end,
						newInterval.end));
				newInterval = merged;
			}
		}
		result.add(newInterval);
		return result;
	}

	/**
	 * make use of the function 'mergeInterval()'
	 * 
	 * @param intervalList
	 * @param interval
	 * @return
	 */
	private static ArrayList<Interval> insertInterval(
			ArrayList<Interval> intervalList, Interval interval) {
		// TODO Auto-generated method stub
		intervalList.add(interval);
		Collections.sort(intervalList, new IntervalComparator());
		ArrayList<Interval> result = mergeInteval(intervalList);
		return result;
	}

	private static ArrayList<Interval> mergeInteval(
			ArrayList<Interval> intervalList) {
		// TODO Auto-generated method stub
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervalList.get(0);
		for (int i = 1; i < intervalList.size(); i++) {
			Interval cur = intervalList.get(i);
			if (cur.start <= prev.end) {
				Interval merged = new Interval(prev.start, Math.max(cur.end,
						prev.end));
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

class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		return o1.start - o2.start;
	}

}
