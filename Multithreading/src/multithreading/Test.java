package multithreading;

public class Test implements Runnable {
	String msg;
	private long sleepMills;
	
	public Test(String msg, long sleepMills) {
		this.msg=msg;
		this.sleepMills = sleepMills;
	}
	
	public static void main(String[] args) {
		Runnable printer = new Test("B",1000);
		Thread thread = new Thread(printer);
		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("A");
		}
	}

	public void run() {
		for(int i=0;i<10;i++){
			try{
				Thread.sleep(sleepMills);
			}
			catch(InterruptedException e){
				throw new RuntimeException(e);
			}
			System.out.println(msg);
		}	
	}
}
