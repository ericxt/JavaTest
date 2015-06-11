package moreAboutJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

/**
 * merge K sorted list
 * @author txie
 *
 */
public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		
		ListNode list1 = new ListNode(0);
		ListNode temp1 = list1;
		for (int i = 0; i < 5; i ++) {
			temp1.next = new ListNode(i + 3);
			temp1 = temp1.next;
		}
		printListNode(list1);
		ListNode list2 = new ListNode(0);
		ListNode temp2 = list2;
		for (int i = 0; i < 3; i ++) {
			temp2.next = new ListNode(i + 8);
			temp2 = temp2.next;
		}
		printListNode(list2);
		
		lists.add(list1);
		lists.add(list2);
		
		ListNode sortedList = mergeKLists(lists);
		printListNode(sortedList);

	}

	private static void printListNode(ListNode list) {
		// TODO Auto-generated method stub
		if (list == null) {
			System.out.println("list null");
		} else {
			while (list != null) {
				System.out.print(list.val + " ");
				list = list.next;
			}
			System.out.println();
		}
		
	}

	private static ListNode mergeKLists(ArrayList<ListNode> lists) {
		// TODO Auto-generated method stub
		if (lists.size() == 0) {
			return null;
		}

		PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {

					@Override
					public int compare(ListNode o1, ListNode o2) {
						// TODO Auto-generated method stub
						if (o1.val > o2.val) {
							return 1;
						} else if (o1.val < o2.val) {
							return -1;
						} else
							return 0;
					}
				});

		for (ListNode node : lists) {
			if (node != null)
				p.add(node);
		}

		ListNode head = new ListNode(0);
		ListNode q = head;

		while (p.size() > 0) {
			ListNode temp = p.poll();
			q.next = temp;
			if (temp.next != null) {
				p.add(temp.next);
			}
			q = q.next;
		}
		return head.next;
	}

}
