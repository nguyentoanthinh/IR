package crawlweb;

import models.FileProcessor;

/**
 *
 * @author Cuong Nguyen Ngoc
 */
public class CrawlerRunner {
    
    public static void main(String[] args) {
        Crawler clawler = new Crawler();
        clawler.crawl(new FileProcessor().getRssLinks());
    }
}
