public class UserAuth {
    String login;
    String pw;
    Role role;

    public UserAuth(String login, String pw, Role role) {
        this.login = login;
        this.pw = pw;
        this.role = role;
    }

    public static UserAuth auth(String login, String pw, UserAuth[] users) {
        for (UserAuth user : users) {
            if (user.login.equals(login) && user.pw.equals(pw)) {
                System.out.println("Authorization completed");

                return user;
            }
        }
        System.out.println("User not found!");
        return null;
    }
    public void userAccess(Role... roles) throws RoleException {
        for (Role role : roles) {
            if (this.role.equals(role)) {
                return;
            }
        }
        throw new RoleException("No permission");
    }
}

