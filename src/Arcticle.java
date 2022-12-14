public class Arcticle extends Notes{
    private String arcticleName;

    public Arcticle(String creatorName, String fileName, String body, String arcticleName) {
        super(creatorName, fileName, body);
        this.arcticleName = arcticleName;
    }

    public String getArcticleName() {
        return arcticleName;
    }

    public String setArcticleName() {
        this.arcticleName = arcticleName;
        return null;
    }


    @Override
    public void printNotes() {
        super.printNotes();
        System.out.println("Article name: " + arcticleName);
    }

    @Override
    public void displayAuthor() {
        super.displayAuthor();
    }
}
