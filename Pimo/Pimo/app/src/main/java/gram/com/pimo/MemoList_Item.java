package gram.com.pimo;

/**
 * Created by dsm2017 on 2017-11-07.
 */

public class MemoList_Item {

    private String titleStr;
    private String descStr;

    public void setTitle(String title) {
        titleStr = title;
    }
    public void setDesc(String desc) {
        descStr = desc;
    }


    public String getTitle() {
        return this.titleStr;
    }
    public String getDesc() {
        return this.descStr;
    }
}
