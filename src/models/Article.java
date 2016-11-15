package models;

/**
 *
 * @author Cuong Nguyen Ngoc
 */
public class Article {
    private int id;
    private String content;
    private String cat;

    public Article() {}

    public Article(int id, String content, String cat) {
        this.id = id;
        this.content = content;
        this.cat = cat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article(int id, String cat) {
        this.id = id;
        this.cat = cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
