public class Main {

    public static void main(String[] args) {
        Basket mashaBasket = new Basket();
        mashaBasket.add("Молоко", 200, 1, 0.5);
        mashaBasket.add("Хлеб", 40, 2, 0.2);
        mashaBasket.print("Корзина Маши:");
        System.out.println(mashaBasket.getTotalWeight());
        System.out.println(mashaBasket.getTotalPrice());
        mashaBasket.clear();



        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Кефир", 80, 2, 0.9);
        vasyaBasket.add("Творог", 30, 2, 0.3);
        vasyaBasket.print("\nКорзина Васи:");
        System.out.println(vasyaBasket.getTotalWeight());
        System.out.println(vasyaBasket.getTotalPrice());
        vasyaBasket.clear();


        Basket petyaBasket = new Basket();
        petyaBasket.add("Рыба", 500, 1, 1.5);
        petyaBasket.add("Мясо", 350, 1, 1);
        petyaBasket.print("\nКорзина Пети:");
        System.out.println(petyaBasket.getTotalWeight());
        System.out.println(petyaBasket.getTotalPrice());
        petyaBasket.clear();

        System.out.println("\nКоличество корзин: " + Basket.countBasket);
        System.out.println(Basket.getTotalPriceBasket());
        System.out.println(Basket.getTotalWeightBasket());
        System.out.println(Basket.getAverageBasketPrice());
        System.out.println(Basket.getTotalCountProduct());
        System.out.println(Basket.getAverageProductPrice());


        System.out.println("================================================================");


        Arithmetic arithmetic = new Arithmetic(25, 5);
        System.out.println("\nСумма чисел:" + arithmetic.amount());
        System.out.println("Произведение чисел:" + arithmetic.multiplication());
        System.out.println("Максимальное число:" + arithmetic.max());
        System.out.println("Минимальное число:" + arithmetic.min());

        System.out.println("================================================================");


        Printer printer = new Printer();
        printer.append("Undefined", "Расписка", 1);
        printer.append("Undefined", "Доверенность", 3);
        printer.append("Undefined", "Спецификация", 14);
        printer.print();
        System.out.println(printer.getTotalPrints());


    }

}
