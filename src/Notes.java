public abstract class Notes {
    private static String creatorName;
    private String fileName;
    private String body;

    public Notes(String creatorName, String fileName, String body) {
        this.creatorName = creatorName;
        this.fileName = fileName;
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getFileName() {
        return fileName;
    }

    public void printNotes() {
        System.out.print("Creator: " + creatorName + " File name: " + fileName + " Note body: " + body + " ");
    }

    public static void displayAuthor() {
        System.out.println(creatorName);
    }


    protected static void replacingWord() {
        System.out.println("Enter file name: ");
        int noteIndex = Notes.searchIndex(Main.scr.nextLine());
        System.out.println("Enter old word: ");
        String oldWord = Main.scr.nextLine();
        System.out.println("Enter new word: ");
        String newWord = Main.scr.nextLine();
        String newBody = Main.notes[noteIndex].getBody().replaceAll(oldWord, newWord);
        Main.notes[noteIndex].setBody(newBody);
    }

    protected static void bodyReplacement() {
        System.out.println("Enter note name: ");
        int noteIndex = Notes.searchIndex(Main.scr.nextLine());
        System.out.println("Enter new note body: ");
        String newBody = Main.scr.nextLine();
        Main.notes[noteIndex].setBody(newBody);
    }

    protected static void changeName() {
        System.out.println("Entry file name");
        int noteIndex = Notes.searchIndex(Main.scr.nextLine());
        System.out.println("New file name");
        String newName = Main.scr.nextLine();
        Main.notes[noteIndex].setFileName(newName);
    }

    protected static void createNotes() {
        System.out.println("Enter 1 to create Shopping list or 2 to create Article: ");
        String creator = Main.scr.nextLine();
        switch (creator) {
            case "1" -> Main.creatorShopList();
            case "2" -> Main.creatorArticle();
        }
    }

    protected static int searchIndex(String name) {
        for (int i = 0; i < Main.notes.length; i++) {
            if (Main.notes[i] != null && Main.notes[i].getFileName().equals(name)) {
                return i;
            }
        }
        throw new RuntimeException("Index not fond");
    }
    protected static void deleteNotes() {
        System.out.println("Enter file name: ");
        var k = Notes.searchIndex(Main.scr.nextLine());
        Main.notes[k] = null;
    }
}

