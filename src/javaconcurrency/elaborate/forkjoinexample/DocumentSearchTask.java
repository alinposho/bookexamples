package javaconcurrency.elaborate.forkjoinexample;

import java.util.concurrent.RecursiveTask;


@SuppressWarnings("serial")
class DocumentSearchTask extends RecursiveTask<Long> {
	private final Document document;
	private final String searchedWord;

	DocumentSearchTask(Document document, String searchedWord) {
		super();
		this.document = document;
		this.searchedWord = searchedWord;
	}

	@Override
	protected Long compute() {
		WordCounter counter = new WordCounter();
		return counter.occurrencesCount(document, searchedWord);
	}
}