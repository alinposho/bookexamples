package javaconcurrency.elaborate.forkjoinexample;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		WordCounter wordCounter = new WordCounter();
		Folder folder = Folder.fromDirectory(new File(args[0]));
		long time = System.currentTimeMillis();
		System.out.println("The number of occurences of the word " + args[1]
				+ "\n in the files from " + args[0] + " folder\n is "
				+ wordCounter.countOccurrencesOnSingleThread(folder, args[1]));
		long newTime = System.currentTimeMillis();
		System.out.println("Execution of the single threaded code took: "
				+ (newTime - time));

		System.out.println("The number of occurences of the word " + args[1]
				+ "\n in the files from " + args[0] + " folder \n is "
				+ wordCounter.countOccurrencesInParallel(folder, args[1]));

		System.out.println("Execution of the multithreaded code took: "
				+ (System.currentTimeMillis() - newTime));
	}
}
