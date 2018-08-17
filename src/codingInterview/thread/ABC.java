package codingInterview.thread;

import java.util.concurrent.locks.ReentrantLock;

class ClassABC {
	static String abc;
};

public class ABC {
	static enum EnumABC {
		A, C, B
	};

	public static void main(String[] args) {

		ReentrantLock rlock = new ReentrantLock(true);
		// 1. new ReentrantLock(boolean fairness); FCFC
		// 2. false ... Can't expect
		// lock interface
		ClassABC.abc = "A";
		new AThread(rlock).start();
		new BThread(rlock).start();
		new CThread(rlock).start();

	}

}

class AThread extends Thread {
	ReentrantLock rlock;

	public AThread(ReentrantLock rlock) {
		super();
		this.rlock = rlock;

	}

	@Override
	public void run() {

		while (true) {
			rlock.lock();
			try {
				if ("A".equalsIgnoreCase(ClassABC.abc)) {
					System.out.print(ClassABC.abc);
					ClassABC.abc = "B";
				} else {
//					System.out.println(a);
				}

			} finally {
				rlock.unlock();

				try {
					// rlock.wait();
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

class BThread extends Thread {
	ReentrantLock rlock;

	public BThread(ReentrantLock rlock) {
		super();
		this.rlock = rlock;

	}

	@Override
	public void run() {
		while (true) {
			rlock.lock();
			try {

				if ("B".equalsIgnoreCase(ClassABC.abc)) {
					System.out.print(ClassABC.abc);
					ClassABC.abc = "C";
				}

			} finally {
				rlock.unlock();
				try {
					// rlock.wait();
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}

class CThread extends Thread {
	ReentrantLock rlock;

	public CThread(ReentrantLock rlock) {
		super();
		this.rlock = rlock;

	}

	@Override
	public void run() {
		while (true) {
			rlock.lock();
			try {
				if ("C".equalsIgnoreCase(ClassABC.abc)) {
					System.out.print(ClassABC.abc);
					ClassABC.abc = "A";
				}

			} finally {
				rlock.unlock();

				try {
//					rlock.wait();
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
