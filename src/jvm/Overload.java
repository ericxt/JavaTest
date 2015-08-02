package jvm;

import java.io.Serializable;

public class Overload {

//	public static void say(char c) {
//		System.out.println("char");
//	}

	public static void say(int i) {
		System.out.println("int");
	}

	public static void say(long l) {
		System.out.println("long");
	}

	public static void say(Character character) {
		System.out.println("Character");
	}

	public static void say(Serializable ser) {
		System.out.println("Serializable");
	}

	public static void say(Object obj) {
		System.out.println("Object");
	}

	public static void say(char... c) {
		System.out.println("char ...");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		say('c');
	}

}
