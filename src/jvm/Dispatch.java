package jvm;

public class Dispatch {
	static class QQ {

	}

	static class _360 {

	}

	public static class Father {
		public void hardChoice(QQ arg) {
			System.out.println("Fathre choose QQ");
		}

		public void hardChoice(_360 arg) {
			System.out.println("Father choose 360");
		}
	}

	public static class Son extends Father {
		public void hardChoice(QQ arg) {
			System.out.println("Son choose QQ");
		}

		public void hardChoice(_360 arg) {
			System.out.println("Son choose 360");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father father = new Father();
		Father son = new Son();

		father.hardChoice(new QQ());
		son.hardChoice(new _360());

	}

}
