package com.test;

public class MutiThreadingOnCounterNumber extends Thread {
	
	//define the Total No.Of Threads needed
	public static final int TOTAL_THREADS = 10;
	
	public final static Object obj = new Object();
	
	int threadNo;
	
	static volatile int counter = 1;

	public MutiThreadingOnCounterNumber(int threadNo) {
		this.threadNo = threadNo;
	}

	@Override
	public void run() {
		// in a synchronized block to acquire lock
		synchronized (obj) {
			while (counter <= 100) {
				/*
				 * counter%TOTAL_THREADS == threadNo => e.g: 2%10 = 2, 3%10 = 3, 11%10 = 1, 12%10 = 2 ..,
				 * (counter%TOTAL_THREADS == 0) && (TOTAL_THREADS == threadNo) =>
				 * 10%10 will be 0, and this must be printed by 10 th thread only, ie the highest thread.
				 */
				if ((counter % TOTAL_THREADS == threadNo)
						|| ((counter % TOTAL_THREADS == 0) && (TOTAL_THREADS == threadNo))) {
					// Display the output as desired
					System.out.println("Thread: " + this.threadNo + " printing" + " " + counter++);
					// notify
					obj.notifyAll();
				} else {
					// current thread not eligible for printing the current counter value, so wait
					// till its notified after incrementing the counter.
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		/*
		 * Creating as many threads as needed.
		 */
		for (int i = 1; i <= TOTAL_THREADS; i++) {
			MutiThreadingOnCounterNumber th = new MutiThreadingOnCounterNumber(i);
			th.start();
		}
	}
}
/*
Output:
Thread: 1 printing 1
Thread: 2 printing 2
Thread: 3 printing 3
Thread: 4 printing 4
Thread: 5 printing 5
Thread: 6 printing 6
Thread: 7 printing 7
Thread: 8 printing 8
Thread: 9 printing 9
Thread: 10 printing 10
Thread: 1 printing 11
Thread: 2 printing 12
Thread: 3 printing 13
Thread: 4 printing 14
.
.
.
*/