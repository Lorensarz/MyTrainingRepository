public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Колбаса", 250, 1, 0.5);
        basket.add("Хлеб", 40, 2, 0.2);
        basket.print("Содержимое корзины:");
        basket.clear();
        basket.print("");
        basket.add("Сок", 40, 2, 0.5);



        Arithmetic arithmetic = new Arithmetic(25, 5);
        System.out.println("\nСумма чисел:" + arithmetic.amount());
        System.out.println("Произведение чисел:" + arithmetic.multiplication());
        System.out.println("Максимальное число:" + arithmetic.max());
        System.out.println("Минимальное число:" + arithmetic.min());


        Printer printer = new Printer();
        printer.append("Расписка",2);
        printer.append("Доверенность", 5);
        printer.append("Спецификация", 17);
        printer.print("\nОчередь печати:");
        System.out.println("Общее число страниц:" + printer.getTotalPages());
        printer.clear();
        System.out.println("Распечатанно страниц всего:" + printer.totalCount());
        printer.print("Очередь печати:");
        printer.append("Договор", 3);


    }

}
