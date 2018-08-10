package codingInterview.thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class UserThreadOrDemonExecutor {

	public static void main(String str[]) throws Exception {

		System.out.println("Entry");

		ThreadFactory thf = new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {

				System.out.println("Called THread Factory");
 				Thread th = new Thread(r);
				th.setDaemon(false);
				return th;
			}
		};

		Executor service = Executors.newFixedThreadPool(2, thf);
		for (int i = 0; i < 2; i++)
			service.execute(new DemonThreadEx());

		System.out.println("Exit  ----------------------");

	}

}

class DemonThreadEx implements Runnable {
	static int count = 1;

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
			// setDaemon(true);//Internally call isAlive method to to

			int A = r.nextInt();
			int B = r.nextInt();
			System.out.println("Runnable" + count + ":" + calcGCD(A, B));

		}
		System.out.println("Runnable" + count++ + "Exit");

	}
	// setDaemon(false);
}
