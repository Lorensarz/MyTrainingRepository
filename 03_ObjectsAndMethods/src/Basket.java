public class Basket {

    public static int weight = 0;
    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {

        return count;
    }

    public static void increaseCount(int count) {

        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, double weight) {
        add(name, price, 1, weight); // у нас один товар в метод передается, переиспользуем
    }

    public void add(String name, int price, int count, double weight) {
        items += "\n" + name + " - " + count + " шт. - " + price + " р. " + weight + " кг.";
        this.totalPrice += price * count;
        this.totalWeight += weight * count;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }


    public int getTotalPrice() {

        return totalPrice;
    }

    public String getTotalWeight() {
        String total;
        total = "Общий вес корзины: " + totalWeight;
        return total;
    }


    public boolean contains(String name) {

        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
