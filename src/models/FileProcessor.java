package models;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Cuong Nguyen Ngoc
 */
public class FileProcessor {
    private String AbsolutePath = new File("").getAbsolutePath();
    private String sourcePath = AbsolutePath + "/websources/rss.txt";
    private String dataPath = AbsolutePath + "/data/data";
    
    public List<Rss> getRssLinks() {
        BufferedReader br = null;
        List<Rss> rSSs = new ArrayList<>();
        try {
            
            String link;
            br = new BufferedReader(new FileReader(sourcePath));
            
            while ((link = br.readLine()) != null) {
               System.out.println(link);
               Rss rss = new Rss();
               rss.setCatAndWebsite(link);
               rss.setLink(link);
               
               rSSs.add(rss);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rSSs;
    }
    
    public void generateDataFromWeb(Article article) throws IOException {
        File folder = new File(dataPath);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder.getAbsolutePath() + "/" + article.getId() + "." + article.getCat());
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(article.getContent());
        bw.close();
    }
}
