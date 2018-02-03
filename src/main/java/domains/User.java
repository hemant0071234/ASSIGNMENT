package domains;

public class User {
    private final String username;
    private final String password;

    private User(String userType) {
        this.username = System.getenv(userType + ".id");
        this.password = System.getenv(userType + ".password");
    }

    public static User validUser() {
        User user = new User("valid.user");
        return user;
    }

    public String getUsername() { return username; }

    public String getPassword() {
        return password;
    }

}
