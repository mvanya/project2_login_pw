public class ShopList extends Notes{
    private String shopName;

    public ShopList(String creatorName, String fileName, String body, String shopName) {
        super(creatorName, fileName, body);
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public String setShopName() {
        this.shopName = shopName;
        return null;
    }

    @Override
    public void printNotes() {
        super.printNotes();
        System.out.println("Shop name: " + shopName);
    }

    @Override
    public void displayAuthor() {
        super.displayAuthor();
    }
}

