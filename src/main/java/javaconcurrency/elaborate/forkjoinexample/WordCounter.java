package javaconcurrency.elaborate.forkjoinexample;

import java.util.concurrent.ForkJoinPool;

public class WordCounter {

	private final ForkJoinPool forkJoinPool = new ForkJoinPool();

	public Long countOccurrencesInParallel(Folder folder, String searchedWord) {
		return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
	}

	public Long countOccurrencesOnSingleThread(Folder folder,
			String searchedWord) {
		long count = 0;
		for (Folder subFolder : folder.getSubFolders()) {
			count = count
					+ countOccurrencesOnSingleThread(subFolder, searchedWord);
		}
		for (Document document : folder.getDocuments()) {
			count = count + occurrencesCount(document, searchedWord);
		}
		return count;
	}

	String[] wordsIn(String line) {
		return line.trim().split("(\\s|\\p{Punct})+");
	}

	public Long occurrencesCount(Document document) {
		long count = 0;
		for (String line : document.getLines()) {
			count += wordsIn(line).length;
		}
		return count;
	}

	public Long occurrencesCount(Document document, String searchedWord) {
		long count = 0;
		for (String line : document.getLines()) {
			count += wordsIn(line).length;
			for (String word : wordsIn(line)) {
				if (searchedWord.equals(word)) {
					count = count + 1;
				}
			}
		}
		return count;
	}
}