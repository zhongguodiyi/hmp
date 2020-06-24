package room;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer id;
    private String code;
    private String location;

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Room(Integer id, String code, String location) {
        this.id = id;
        this.code = code;
        this.location = location;
    }

    public Room(String code, String location) {
        this.code = code;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
