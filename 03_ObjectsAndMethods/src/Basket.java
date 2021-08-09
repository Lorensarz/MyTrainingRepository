public class Basket {
    /*
    1. Добавьте две статические переменные для хранения общей стоимости и общего количества всех товаров
    во всех корзинах.
    2.Реализуйте статические методы, которые будут увеличивать значения этих переменных при добавлении
    в корзину новых товаров.
    3. Реализуйте статический метод расчёта средней цены товара во всех корзинах. Он должен рассчитывать
    и возвращать отношение общей стоимости всех корзин к общему количеству всех товаров.
    4. Реализуйте статический метод расчёта средней стоимости корзины (отношение общей стоимости всех корзин
    к количеству корзин).
*/
    private static int weight = 0;
    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalPriceBasket;
    private static double totalWeightBasket;
    public static int countBasket = 0;
    private static int averageBasketPrice = 0;


    private static void addTotalPriceBasket(int totalPrice) {

        totalPriceBasket += totalPrice;
    }

    private static void addTotalWeightBasket(double totalWeight) {

        totalWeightBasket += totalWeight;
    }






    public Basket() {
        countBasket = countBasket + 1;
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items) {
        this();
        this.items = this.items + items;

    }

    public static int getCountBasket() {

        return countBasket;
    }


    public static int getCount() {

        return count;
    }


    public void add(String name, int price, double weight) {
        add(name, price, 1, weight);
    }

    public void add(String name, int price, int count, double weight) {
        items += "\n" + name + " - " + count + " шт. - " + price + " р. " + weight + " кг.";
        this.totalPrice += price * count;
        this.totalWeight += weight * count;
        addTotalPriceBasket(price * count);
        addTotalWeightBasket(weight * count);
    }

    public double averageBasketPrice() {
        return  (double) totalPriceBasket / (double) countBasket;
    }

    public static String getAverageBasketPrice() {
        String total;
        total = "\nСредняя цена всех корзин: " + averageBasketPrice;
        return total;
    }


    public static String getTotalWeightBasket() {
        String total;
        total = "\nОбщий вес всех корзин: " + totalWeightBasket;
        return total;
    }

    public static String getTotalPriceBasket() {
        String total;
        total = "\nОбщая стоимость всех корзин: " + totalPriceBasket;
        return total;
    }

    public String getTotalPrice() {
        String total;
        total = "Общая стоимость корзины: " + totalPrice;
        return total;
    }

    public String getTotalWeight() {
        String total;
        total = "Общий вес корзины: " + totalWeight;
        return total;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
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
