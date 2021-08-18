public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        int i = 0;

        for (i = 1040; i < 1104; i++) {
            char a = (char) i;
            System.out.println(i + " - " + a);
        }

        char b = (char) 1025;
        System.out.println(i + " - " + b);

    }


}
