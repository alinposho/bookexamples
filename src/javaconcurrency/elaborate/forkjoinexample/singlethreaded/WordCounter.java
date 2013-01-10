package javaconcurrency.elaborate.forkjoinexample.singlethreaded;


public class WordCounter {

    String[] wordsIn(String line) {
        return line.trim().split("(\\s|\\p{Punct})+");
    }
    
    Long occurrencesCount(Document document, String searchedWord) {
        long count = 0;
        for (String line : document.getLines()) {
        	count += wordsIn(line).length;
//            for (String word : wordsIn(line)) {
//                if (searchedWord.equals(word)) {
//                    count = count + 1;
//                }
//            }
        }
        return count;
    }
}