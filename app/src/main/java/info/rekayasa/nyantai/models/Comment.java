package info.rekayasa.nyantai.models;

/**
 * Created by rachmadi on 5/22/17.
 */

public class Comment {

    public String content;
    public String user_id;
    public String display_name;
    public Object comment_time;

    public Comment() {
    }

    public Comment(String content, String user_id, String display_name,
                   Object comment_time) {
        this.content = content;
        this.user_id = user_id;
        this.display_name = display_name;
        this.comment_time = comment_time;
    }
}
