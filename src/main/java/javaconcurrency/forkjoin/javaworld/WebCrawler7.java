package javaconcurrency.forkjoin.javaworld;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Madalin Ilie
 */
public class WebCrawler7 implements LinkHandler {

    private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
//    private final Collection<String> visitedLinks = Collections.synchronizedList(new ArrayList<>());
    private String url;
    private ForkJoinPool mainPool;

    public WebCrawler7(String startingURL, int maxThreads) {
        this.url = startingURL;
        mainPool = new ForkJoinPool(maxThreads);
    }

    private void startCrawling() {
        mainPool.invoke(new LinkFinderAction(this.url, this));
    }

    @Override
    public int size() {
        return visitedLinks.size();
    }

    @Override
    public void addVisited(String s) {
        visitedLinks.add(s);
    }

    @Override
    public boolean visited(String s) {
        return visitedLinks.contains(s);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        new WebCrawler7("http://www.javaworld.com", 64).startCrawling(); // Do not use this site or any other important site since you will be banned!
    	new WebCrawler7("localhost", 64).startCrawling();
    }

	@Override
	public void queueLink(String link) throws Exception {
		throw new NotImplementedException();
		
	}
}