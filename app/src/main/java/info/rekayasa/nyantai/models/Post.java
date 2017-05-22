package info.rekayasa.nyantai.models;

/**
 * Created by rachmadi on 5/22/17.
 */

public class Post {

    public String content;
    public String user_id;
    public String display_name;
    public Object posted_time;
    public Object updated_time;
    public String photo;
    public String place_name;
    public String place_id;
    public long favorite_count;
    public long comment_count;

    public Post() {
    }

    public Post(String content, String user_id, String display_name,
                Object posted_time, Object updated_time, String photo,
                String place_name, String place_id, long favorite_count,
                long comment_count) {
        this.content = content;
        this.user_id = user_id;
        this.display_name = display_name;
        this.posted_time = posted_time;
        this.updated_time = updated_time;
        this.photo = photo;
        this.place_name = place_name;
        this.place_id = place_id;
        this.favorite_count = favorite_count;
        this.comment_count = comment_count;
    }
}
