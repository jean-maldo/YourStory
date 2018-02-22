package core;

/**
 * Created by jmaldonado on 18/11/2017.
 */

public class Chapter {
    private String title;
    private String subTitle;

    public Chapter(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelationship(String relationship) {
        this.subTitle = relationship;
    }

    public String getTitle() {
        return title;
    }

    public String getRelationship() {
        return subTitle;
    }


}
