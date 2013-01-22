package javaconcurrency.locks;

import java.util.concurrent.locks.*;
import java.util.*;
import java.text.*;

public class lock_example {
	public static Lock this_lock = new ReentrantLock();

	public static void main(String[] args) throws Exception {
		ListenerThread lt = new ListenerThread();
		SpeakerThread st = new SpeakerThread();
		lt.start();
		st.start();
	}

	public static int message = 0;

	public static void report(String label) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.S");
		String time_of_day = sdf.format(now.getTime());
		System.out.format("%s:  %s\n", time_of_day, label);
	}
}

class ListenerThread extends Thread {
	public void run() {
		while (true) {
			lock_example.report("The Listener requests the lock.");
			lock_example.this_lock.lock();
			lock_example.report("The Listener acquires the lock.");
			if (lock_example.message == 0) {
				lock_example.report("The Speaker has sent nothing.");
				lock_example.report("The Listener will check again later.");
				try {
					Thread.sleep(800);
				} catch (InterruptedException ie) {
					// ie
				}
			} else {
				lock_example.report("The Listener just received "
						+ Integer.toString(lock_example.message)
						+ " from the Speaker.");
				lock_example.message = 0;
			}
			lock_example.report("The Listener releases the lock.");
			lock_example.this_lock.unlock();
		}
	}
}

class SpeakerThread extends Thread {
	int counter = 0;

	public void run() {
		while (true) {
			while (0 != lock_example.message) {
				try {
					lock_example
							.report("The Speaker waits for the Listener to catch up.");
					Thread.sleep(30);
				} catch (InterruptedException ie) {
				}
			}
			counter++;
			lock_example.report("The Speaker requests the lock.");
			lock_example.this_lock.lock();
			lock_example.report("The Speaker acquires the lock.");
			lock_example
					.report("The Speaker takes a nap--a model for real work it might otherwise do.");
			try {
				Thread.sleep((int) (2000 * Math.random()));
			} catch (InterruptedException ie) {
			}
			lock_example.message = counter;
			lock_example.report("The Speaker releases the lock.");
			lock_example.this_lock.unlock();
		}
	}
}