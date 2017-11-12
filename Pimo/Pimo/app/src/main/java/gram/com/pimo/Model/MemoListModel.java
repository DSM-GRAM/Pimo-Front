package gram.com.pimo.Model;

/**
 * Created by root1 on 2017. 11. 10..
 */

public class MemoListModel {
    private String title, loc, content;

    public MemoListModel(String title, String loc, String content) {
        this.title = title;
        this.content = content;
        this.loc = loc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoc() {return loc;}

    public void setLoc(String title) {this.loc = loc;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
