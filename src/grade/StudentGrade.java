package grade;

public class StudentGrade {
    private Integer id;
    private String name;
    private Integer sex;
    private Integer subject;
    private float score;

    public StudentGrade() {
    }

    public StudentGrade(Integer id, String name, Integer sex, Integer subject, float score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.subject = subject;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSubject() {   return subject; }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
