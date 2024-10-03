package UserManagment;

public class User {
    protected int UserId;
    protected String UserName;
    protected String UserPassword;
    protected String PhoneNumber;

    public String getUserPassword() {
        return UserPassword;
    }

    //Do we need to hash the password?
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
