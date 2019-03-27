package extend;

/**
 * @author haishen
 * @date 2019/3/27
 */
public class People {

    private String name;
    private Integer age;

    public People() {
        this.age = 0;
        this.name = "people";
    }

    public People(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
