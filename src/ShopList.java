public class ShopList extends Notes{
    private String shopName;

    public ShopList(String creatorName, String fileName, String body, String shopName) {
        super(creatorName, fileName, body);
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName() {
        this.shopName = shopName;
    }

    @Override
    public void printNotes() {
        super.printNotes();
        System.out.println("Shop name: " + shopName);
    }
}

