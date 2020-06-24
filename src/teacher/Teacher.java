package teacher;

import java.io.Serializable;

public class Teacher implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private String sex;
    private String age;
    private String title;

    public Teacher(Integer id, String code, String name, String sex, String age, String title) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.title = title;
    }

    public Teacher(String code, String name, String sex, String age, String title) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.title = title;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
