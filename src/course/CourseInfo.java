package course;

public class CourseInfo {
    int courseID;
    String name;
    int 	type;
    float	credit;
    int 	grade;
    int 	major;
    String	detail;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_type() {
        String c_type = "";
        switch (type){
            case 1:c_type="通识必修课"; break;
            case 2:c_type="通识选修课"; break;
            case 3:c_type="公共基础必修课"; break;
            case 4:c_type="专业必修课"; break;
            case 5:c_type="专业选修课"; break;
        }
        return c_type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMajor() {
        return major;
    }

    public String getC_major() {
        String c_major="";
        switch (major){
            case 1:c_major="软件工程";break;
            case 2:c_major="空间信息";break;
        }
        return c_major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
