package reflect;

/**
 * @author haishen
 * @date 2019/5/8
 */
public class Article {

    private Long id;

    private String title;

    private Long publicTime;

    public Article() {

    }

    public Article(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Long publicTime) {
        this.publicTime = publicTime;
    }
}
