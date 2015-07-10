package codingInterview;

import java.util.Arrays;

public class MinStack {
	private int MAX_LEN = 100;
	private int[] arr;
	private int capacity = -1;

	public MinStack() {
		this.arr = new int[MAX_LEN];
		capacity = 0;
	}

	private void push(int elem) {
		if (capacity >= MAX_LEN) {
			System.out.println("out of capacity, extend the capacity");
			arr = Arrays.copyOf(arr, MAX_LEN * 2);
		}
		
		arr[capacity] = elem;
		capacity++;
	}
	
	private int pop() {
		if (capacity <= 0) {
			System.out.println("out of capacity");
			return Integer.MIN_VALUE;
		}
		if (capacity == arr.length / 2 && arr.length > MAX_LEN) {
			System.out.println("narrow the space of stack");
			Arrays.copyOf(arr, arr.length / 2);
		}
		capacity--;
		return arr[capacity];
	}
	
	private int top() {
		if (capacity <= 0) {
			System.out.println("out of range");
			return Integer.MIN_VALUE;
		}
		
		return arr[capacity - 1];
	}
	
	private int getMin() {
		if (capacity <= 0 || capacity >= arr.length) {
			System.out.println("out of range");
			return Integer.MIN_VALUE;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < capacity; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack stack = new MinStack();
		stack.push(5);
		stack.push(3);
		stack.push(10);
		stack.push(0);
		
		for (int i = 0; i < 100; i++) {
			stack.push(i);
		}
		
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.capacity);
		
		System.out.println(stack.getMin());

	}

}
