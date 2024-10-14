package UserManagment;

/**
 * this class should be abstract because we don't want any class to instantiate it
 * also we want to force the inheritance
 */
public abstract class User {
    protected int UserId;
    protected String UserName;
    protected String UserPassword;
    protected String PhoneNumber;

    //private default constructor
    private User(){
        throw new UnsupportedOperationException();
    }
    public User(int userId, String user, String password, String phoneNumber) {
        this.UserId = userId;
        this.UserName= user;
        this.UserPassword = password;
        this.PhoneNumber= phoneNumber;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
