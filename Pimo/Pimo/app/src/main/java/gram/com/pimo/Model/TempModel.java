package gram.com.pimo.Model;

/**
 * Created by root1 on 2017. 11. 10..
 */

public class TempModel {
    private String title, contact, time, image_id, content;

    public TempModel(String title, String contact, String time, String image_id, String content) {
        this.title = title;
        this.contact = contact;
        this.time = time;
        this.image_id = image_id;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
