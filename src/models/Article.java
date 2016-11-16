package models;

/**
 *
 * @author Cuong Nguyen Ngoc
 */
public class Article {
    private String content;
    private String cat;

    public Article() {}

    public Article(String content, String cat) {
        this.content = content;
        this.cat = cat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article(String cat) {
        this.cat = cat;
    }
    
    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
