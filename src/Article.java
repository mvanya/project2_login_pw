public class Article extends Notes{
    private String articleName;

    public Article(String creatorName, String fileName, String body, String articleName) {
        super(creatorName, fileName, body);
        this.articleName = articleName;
    }

    public String getArticleName() {
        return articleName;
    }

    public String setArticleName() {
        this.articleName = articleName;
        return null;
    }


    @Override
    public void printNotes() {
        super.printNotes();
        System.out.println("Article name: " + articleName);
    }
}
