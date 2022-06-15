package structural.proxy;

/**
 * Proxy Structural Pattern
 * Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object.
 * A proxy controls access to the original object, allowing you to perform something either
 * before or after the request gets through to the original object.
 *
 * Identification: Proxies delegate all of the real work to some other object.
 * Each proxy method should, in the end, refer to a service object
 *
 * USAGE
 * Proxy pattern is not much used in Java core lib it is mostly used by the clients like us in our project to fulfill special cases
 * Caching Proxy: The example below
 * When we want a simplified version of a complex or heavy object.
 * Remote proxy: When the original object is present in different address space, and we want to represent it locally
 * Protection Proxy/Smart Proxy: When we want to add a layer of security to the original underlying object to provide controlled access based on access rights of the client.
 * logging proxy: Logs
 *
 * Pros
 * You can control the service object without clients knowing about it.
 * You can manage the lifecycle of the service object when clients don’t care about it.
 * The proxy works even if the service object isn’t ready or is not available.
 * Open/Closed Principle. You can introduce new proxies without changing the service or clients.
 *
 * Cons:
 * The code may become more complicated.
 * The response from the service might get delayed.
 *
 * Java examples using proxy
 * java.rmi.*
 * javax.ejb.EJB;
 * javax.persistence.PersistenceContext
 *
 * Relations with other Patterns:
 * Proxy uses same interface..
 * Adapter provides a different interface
 * Decorator provides it with an enhanced interface. (Similar structure diff intents)
 * Facade vs proxy almost same by Proxy has same interface which makes it interchangeable with proxy and real object
 */



public class Demo {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new YoutubeLibImpl());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YoutubeLibCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");
    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
