package javaconcurrency.elaborate.forkjoinexample.singlethreaded;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class Folder {
	private final List<Folder> subFolders;
	private final List<Document> documents;

	Folder(List<Folder> subFolders, List<Document> documents) {
		this.subFolders = subFolders;
		this.documents = documents;
	}

	List<Folder> getSubFolders() {
		return this.subFolders;
	}

	List<Document> getDocuments() {
		return this.documents;
	}

	static Folder fromDirectory(File dir) throws IOException {
		List<Document> documents = new LinkedList<>();
		List<Folder> subFolders = new LinkedList<>();
		for (File entry : dir.listFiles()) {
			if (entry.isDirectory()) {
				subFolders.add(Folder.fromDirectory(entry));
			} else {
				documents.add(Document.fromFile(entry));
			}
		}
		return new Folder(subFolders, documents);
	}
	
	public static void main(String[] args) throws IOException {
		String pathToFolder = ".";
		if(args.length == 1) {
			pathToFolder = args[0];
		}
		
		long wordCount = 0;
		WordCounter counter = new WordCounter();
		String SEARCHED_WORD = "Document";
		
		for(Document document : Folder.fromDirectory(new File(pathToFolder)).getDocuments()) {
			wordCount += counter.occurrencesCount(document, SEARCHED_WORD);
		}
		
		System.out.println("Word count: " + wordCount);
	}
}
