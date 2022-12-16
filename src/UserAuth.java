import java.util.Scanner;

public class UserAuth {

    // где модификаторы доступа?
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
    public static void firstAuthorization() {
        boolean flag = true;

        while (flag) {

            authorization();

            if (Main.currentUser != null) {
                flag = false;
            }

        }
    }
    public static void authorization() {
        System.out.println("Enter login and password");
        System.out.print("login: ");
        String login = Main.scr.nextLine();
        System.out.print("Password: ");
        String pw = Main.scr.nextLine();
        Main.currentUser = UserAuth.auth(login, pw, Main.users);
    }
}

