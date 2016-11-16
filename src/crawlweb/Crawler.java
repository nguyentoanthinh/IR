package crawlweb;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/**
 *
 * @author Cuong Nguyen Ngoc
 */
public class Crawler {
    private FileProcessor fileProcessor = new FileProcessor();

    public void crawl(List<Rss> rSSs) {
        Document docRSS;
        try {
            for(Rss rss : rSSs) {
                docRSS = Jsoup.connect(rss.getLink()).get();
                // get all links
                Elements items = docRSS.select("item");
                for(Element item : items) {
                    Document docContent = Jsoup.connect(item.getElementsByTag("link").text()).get();
                    Element divContent = null;
                    switch(rss.getWebsite()) {
                        case "vietnamnet.vn": 
                            divContent = docContent.getElementById("ArticleContent");
                            break;
                        case "vnexpress.net": 
                            divContent = docContent.getElementsByClass("fck_detail").first();
                            break;
                        case "www.24h.com.vn":
                            divContent = docContent.getElementsByClass("text-conent").first();
                            break;
                    }
                    Article article = new Article();
                    String content = "";
                    if(divContent != null) {
                        for(Element p : divContent.getElementsByTag("p")){
                            if(!p.html().contains("<strong>") && p.hasText() &&
                                    !p.html().contains("<em>")){
                                content += p.text();
                            }
                        }
                        article.setContent(content);
                        article.setCat(rss.getCat());

                        fileProcessor.generateDataFromWeb(article);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Crawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
