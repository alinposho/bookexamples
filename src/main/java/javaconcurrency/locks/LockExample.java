package javaconcurrency.locks;

import java.util.concurrent.locks.*;
import java.util.*;
import java.text.*;

public class LockExample {
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
			LockExample.report("The Listener requests the lock.");
			LockExample.this_lock.lock();
			LockExample.report("The Listener acquires the lock.");
			if (LockExample.message == 0) {
				LockExample.report("The Speaker has sent nothing.");
				LockExample.report("The Listener will check again later.");
				try {
					Thread.sleep(800);
				} catch (InterruptedException ie) {
					// ie
				}
			} else {
				LockExample.report("The Listener just received "
						+ Integer.toString(LockExample.message)
						+ " from the Speaker.");
				LockExample.message = 0;
			}
			LockExample.report("The Listener releases the lock.");
			LockExample.this_lock.unlock();
		}
	}
}

class SpeakerThread extends Thread {
	int counter = 0;

	public void run() {
		while (true) {
			while (0 != LockExample.message) {
				try {
					LockExample
							.report("The Speaker waits for the Listener to catch up.");
					Thread.sleep(30);
				} catch (InterruptedException ie) {
				}
			}
			counter++;
			LockExample.report("The Speaker requests the lock.");
			LockExample.this_lock.lock();
			LockExample.report("The Speaker acquires the lock.");
			LockExample
					.report("The Speaker takes a nap--a model for real work it might otherwise do.");
			try {
				Thread.sleep((int) (2000 * Math.random()));
			} catch (InterruptedException ie) {
			}
			LockExample.message = counter;
			LockExample.report("The Speaker releases the lock.");
			LockExample.this_lock.unlock();
		}
	}
}