package extend;

/**
 * @author haishen
 * @date 2019/3/27
 */
public class Student extends People {

    private Integer nianji;

    public Student() {
        this.nianji = 5;
    }

    public Student(Integer nianji) {
        this.nianji = nianji;
    }

    public Integer getNianjie() {
        return nianji;
    }

    public void setNianji(Integer nianji) {
        this.nianji = nianji;
    }
}
