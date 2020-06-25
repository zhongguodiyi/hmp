package teach;

public class teachInfo {
    int id;
    String tName;
    int subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public teachInfo() {
    }

    public teachInfo(int id, String tName, int subject) {
        this.id = id;
        this.tName = tName;
        this.subject = subject;
    }


    public String gettName() {
        return tName;
    }

    public void settName(String teachName) {
        this.tName = teachName;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }
}
