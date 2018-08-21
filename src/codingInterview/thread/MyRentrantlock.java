package codingInterview.thread;

import java.util.concurrent.locks.ReentrantLock;

public class MyRentrantlock {

	Thread t = new Thread() {

		@Override
		public void run() {

			ReentrantLock r = new ReentrantLock();
			r.lock();

			System.out.println("lock() : lock count :" + r.getHoldCount());

			interrupt();
			System.out.println("Current thread is intrupted");
			r.tryLock();
			System.out.println("tryLock() on intrupted thread lock count :" + r.getHoldCount());
			try {
				r.lockInterruptibly();
				System.out.println("lockInterruptibly() --NOt executable statement" + r.getHoldCount());
			} catch (InterruptedException e) {
				r.lock();
				System.out.println("Error");
			} finally {
				r.unlock();
			}

			System.out.println("lockInterruptibly() not able to Acqurie lock: lock count :" + r.getHoldCount());

			r.unlock();
			System.out.println("lock count :" + r.getHoldCount());
			r.unlock();
			System.out.println("lock count :" + r.getHoldCount());

		}

	};

	public static void main(String str[]) {
		MyRentrantlock m = new MyRentrantlock();
		m.t.start();

		System.out.println("");
	}

}
