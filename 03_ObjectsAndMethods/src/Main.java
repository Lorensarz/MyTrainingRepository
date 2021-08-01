public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Молоко", 200, 1, 0.5);
        basket.add("Хлеб", 40, 2, 0.2);
        basket.print("Содержимое корзины:");
        basket.print("");
        basket.clear();
        System.out.println(basket.getTotalWeight());


        Arithmetic arithmetic = new Arithmetic(25, 5);
        System.out.println("\nСумма чисел:" + arithmetic.amount());
        System.out.println("Произведение чисел:" + arithmetic.multiplication());
        System.out.println("Максимальное число:" + arithmetic.max());
        System.out.println("Минимальное число:" + arithmetic.min());


        Printer printer = new Printer();
        printer.append("Undefined", "Расписка", 1);
        printer.append("Undefined", "Доверенность", 3);
        printer.append("Undefined", "Спецификация", 14);
        printer.print();
        System.out.println(printer.getTotalPrints());


    }

}
