package codingInterview.thread;

import java.util.Random;

public class UserThreadOrDemonThread {

	public static void main(String str[]) throws Exception {

		System.out.println("Entry");

		new DemonThread().start();

		Thread.sleep(1000);
		System.out.println("Exit");
		System.out.println("Exit  ----------------------");

	}

}

class DemonThread extends Thread {

	DemonThread() {
		setDaemon(true);//If main thread Exit Daemon thread Exit
	//setDaemon(false);//If main thread Exit User Thread still continue
	}

	static int calcGCD(int A, int B) {
		if (B == 0)
			return A;
		else
			return calcGCD(B, A % B);

	}

	@Override
	public void run() {

		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			//setDaemon(true);//Internally call isAlive method to to 
			
			int A = r.nextInt();
			int B = r.nextInt();
			System.out.println(this.currentThread() + ":" + calcGCD(A, B));
			
		}
		System.out.println(this.currentThread() +"Exit");

	}
	//setDaemon(false);
}
