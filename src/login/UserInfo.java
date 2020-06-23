package login;

public class UserInfo {
    private int userID;
    private String userName;
    private String userPwd;
    private int Auth;//权限

    public int getAuth() {
        return Auth;
    }
    public void setAuth(int auth) {
        Auth = auth;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
