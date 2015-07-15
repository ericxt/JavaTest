package jvm;

public class FinalizeEscapeGC {
	private static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive() {
		System.out.println("yes, i am still alive.");
	}
	
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		SAVE_HOOK = new FinalizeEscapeGC();
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, i am dead.");
		}
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, i am dead.");
		}

	}

}
