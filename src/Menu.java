public class Menu {
    protected static void menuPrint() {
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
    protected static boolean menuChoice(int menu) {
        switch (menu) {
            case 1:
                UserAuth.authorization();
                return true;
            case 2:
                Notes.createNotes();
                return true;
            case 3:
                secondMenuPrint();
                secondMenuChoice(Integer.parseInt(Main.scr.nextLine()));
                return true;
            case 4:
                System.out.println("bye (:");
                return false;
            default:
                return true;
        }
    }
    private static void secondMenuChoice(int menu) {
        try {
            switch (menu) {
                case 1 -> {
                    Main.printNotes();
                }
                case 2 -> {
                    Main.currentUser.userAccess(Role.ADMIN, Role.MODERATOR);
                    Notes.changeName();
                }
                case 3 -> {
                    Notes.replacingWord();
                }
                case 4 -> {
                    Notes.bodyReplacement();
                }
                case 5 -> {
                    Main.displayAuthor();
                }
                case 6 -> {
                    Notes.deleteNotes();
                }
                case 7 -> {
                    Menu.menuChoice(menu);
                }
                default -> {
                }
            }
        } catch (RoleException ex) {
            ex.printStackTrace();
        }
    }

}
