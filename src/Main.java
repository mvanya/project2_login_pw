import java.util.Scanner;

public class Main {

    private static final UserAuth admin = new UserAuth("Pupa","Pupa123", Role.ADMIN);
    private static final UserAuth moderator = new UserAuth("Lupa", "Lupa123", Role.MODERATOR);
    private static final UserAuth user = new UserAuth("Biba", "Biba123", Role.USER);
    protected static final UserAuth[] users = new UserAuth[] {admin, moderator, user};
    protected static final Scanner scr = new Scanner(System.in);
    protected static final Notes[] notes = new Notes[5];
    protected static UserAuth currentUser;

    public static void main(String[] args) {
        UserAuth.firstAuthorization();

        boolean flag = true;

        while (flag) {
            Menu.menuPrint();
            flag = Menu.menuChoice(Integer.parseInt(scr.nextLine()));
        }

    }
    // вынести в Notes
    protected static void printNotes() {
        for (Notes note : notes) {
            if (note != null) {
                note.printNotes();
            }
        }
    }

    // создать абстрктный метод creator в Note и для класса ShopList сделать реализацию
    protected static void creatorShopList() {
        String creatorName = currentUser.login;
        System.out.println("Enter file name: ");
        String fileName = scr.nextLine();
        System.out.println("Enter body list: ");
        String body = scr.nextLine();
        System.out.println("Enter shop name: ");
        // название переменной (магазин)
        String articleName = scr.nextLine();
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) {
                var element = new ShopList(creatorName, fileName, body, articleName);
                notes[i] = element;
                return;
            } else {
                System.out.println("Notes memory finished");
            }
        }
    }

    // Создать абстрактный метод creator в Note и для класса Article сделать реализацию
    protected static void creatorArticle() {
        String creatorName = currentUser.login;
        System.out.println("Enter file name: ");
        String fileName = scr.nextLine();
        System.out.println("Enter body list: ");
        String body = scr.nextLine();
        System.out.println("Enter article name: ");
        String shopName = scr.nextLine();
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) {
                var element = new Article(creatorName, fileName, body, shopName);
                notes[i] = element;
                return;
            } else {
                System.out.println("Notes memory finished");
            }
        }
    }
    protected static void displayAuthor() {
        for (Notes note : notes) {
            if (note != null) {
                Notes.displayAuthor();
            }
        }
    }

}