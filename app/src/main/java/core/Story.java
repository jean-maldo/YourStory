package core;

import java.util.Date;

/**
 * Created by jmaldonado on 18/11/2017.
 */

public class Story {
    private String title;
    private String relationship;

    public Story(String title, String relationship) {
        this.title = title;
        this.relationship = relationship;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getTitle() {
        return title;
    }

    public String getRelationship() {
        return relationship;
    }


}
