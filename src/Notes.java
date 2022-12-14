public abstract class Notes {
    private final String creatorName;
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

    public void displayAuthor() {
        System.out.println(creatorName);
    }
}
