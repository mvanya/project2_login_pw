import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static final UserAuth admin = new UserAuth("Pupa","Pupa123", Role.ADMIN);
    private static final UserAuth moderator = new UserAuth("Lupa", "Lupa123", Role.MODERATOR);
    private static final UserAuth user = new UserAuth("Biba", "Biba123", Role.USER);
    private static final UserAuth[] users = new UserAuth[] {admin, moderator, user};
    private static UserAuth currentUser;
    private static final Scanner scr = new Scanner(System.in);
    private static final Notes[] notes = new Notes[5];

    private static int countNotes;

    
    public static void main(String[] args) {
        System.out.println(currentUser);
        firstAuthorization();
        System.out.println(currentUser);

        boolean flag = true;

        while (flag) {
            menuPrint();
            flag = menuChoice(Integer.parseInt(scr.nextLine()));
        }

    }
    private static void firstAuthorization() {
        boolean flag = true;

        while (flag) {

            authorization();

            if (currentUser != null) {
                flag = false;
            }

        }
    }
    private static void authorization() {
        System.out.println("Enter login and password");
        System.out.println("login: ");
        String login = scr.nextLine();
        System.out.println("Password: ");
        String pw = scr.nextLine();
        currentUser = UserAuth.auth(login, pw, users);
    }

    private static void printNotes() {
        for (Notes note : notes) {
            if (note != null) {
                note.printNotes();
            }
        }
    }

    private static void displayAuthor() {
        for (Notes note : notes) {
            if (note != null) {
                note.displayAuthor();
            }
        }
    }

    private static void createNotes() {
        System.out.println("Enter 1 to create Shopping list or 2 to create Article: ");
        String creator = scr.nextLine(); //  TODO: сделать свитч с выбором заметок creatorShopList(); creatorArcticle()
        switch (creator) {
            case "1" -> creatorShopList();
            case "2" -> creatorArcticle();
            default -> {
            }
        }
    }

    private static void creatorShopList() {
        String creatorName = currentUser.login;
        System.out.println("Enter file name: ");
        String fileName = scr.nextLine();
        System.out.println("Enter body list: ");
        String body = scr.nextLine();
        System.out.println("Enter shop name: ");
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

    private static void creatorArcticle() {
        String creatorName = currentUser.login;
        System.out.println("Enter file name: ");
        String fileName = scr.nextLine();
        System.out.println("Enter body list: ");
        String body = scr.nextLine();
        System.out.println("Enter article name: ");
        String shopName = scr.nextLine();
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) {
                var element = new Arcticle(creatorName, fileName, body, shopName);
                notes[i] = element;
                return;
            } else {
                System.out.println("Notes memory finished");
            }
        }
    }
    private static void deleteNotes() {
        System.out.println("Enter file name: ");
        var k = searchIndex(scr.nextLine());
        notes[k] = null;
    }

    private static Notes searchNote() {
        System.out.println("Enter name: ");
        String search = scr.nextLine();
        for (Notes note : notes) {
            if (note != null && note.getFileName().equals(search)) {
                return note;
            }
        }
        return null;
    }
    private static int searchIndex(String name) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] != null && notes[i].getFileName().equals(name)) {
                return i;
            }
        }
        throw new RuntimeException();
    }
    private static void changeName() {
        System.out.println("Entry file name");
        int noteIndex = searchIndex(scr.nextLine());
        System.out.println("New file name");
        String newName = scr.nextLine();
        notes[noteIndex].setFileName(newName);

    }

    public static void replacingWord() {
        System.out.println("Enter file name: ");
        int noteIndex = searchIndex(scr.nextLine());
        System.out.println("Enter old word: ");
        String oldWord = scr.nextLine();
        System.out.println("Enter new word: ");
        String newWord = scr.nextLine();
        String newBody = notes[noteIndex].getBody().replaceAll(oldWord, newWord);
        notes[noteIndex].setBody(newBody);
        // TODO получение элемента массива по индексу(смотри changeName, deleteNote)
        // TODO получить body заметки(необходимом дополнить класс NOTES)
        // TODO использовать метод replaceAll у стринг
    }

    public static void bodyReplacement() {
        System.out.println("Enter note name: ");
        int noteIndex = searchIndex(scr.nextLine());
        System.out.println("Enter new note body: ");
        String newBody = scr.nextLine();
        notes[noteIndex].setBody(newBody);
    }


    private static void menuPrint() {
        System.out.println("1. Login as a different user");
        System.out.println("2. Create a new note");
        System.out.println("3. Search by name");
        System.out.println("4. Exit");
    }
    private static void secondMenuPrint() {
        System.out.println("1. Print note to console");
        System.out.println("2. Change note name");
        System.out.println("3. Replacing a word in a note");
        System.out.println("4. Note body replacement");
        System.out.println("5. Display note author");
        System.out.println("6. Delete note");
        System.out.println("7. Back");
    }
    private static boolean menuChoice(int menu) {
        switch (menu) {
            case 1:
               authorization();
                return true;
            case 2:
                createNotes();
                return true;
            case 3:
               secondMenuPrint();
               secondMenuChoice(Integer.parseInt(scr.nextLine()));
                return true;
            case 4:
                System.out.println("bye (:");
                return false;
            default:
                return true;
        }

    }
    private static boolean secondMenuChoice(int menu) {
        try {
            switch (menu) {
                case 1:
                    printNotes();
                    return true;
                case 2:
                    currentUser.userAccess(Role.ADMIN, Role.MODERATOR);
                    changeName();
                    return true;
                case 3:
                    replacingWord();
                    return true;
                case 4:
                    bodyReplacement();
                    return true;
                case 5:
                    displayAuthor();
                    return true;
                case 6:
                    deleteNotes();
                    return true;
                case 7:
                    menuChoice(menu);
                    return false;
                default:
                    return true;
            }
        } catch (RoleException ex) {
            ex.printStackTrace();
            return true;
        }
    }
}