public class TwoDimensionalArray {
    public static char symbol = 'X';
    public static char space = ' ';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] cross = new char[size][size];
        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < cross[i].length; j++) {
                cross[i][j] = (j == i || j == cross.length - 1 - i) ? symbol : space;
                System.out.print(cross[i][j]);
            }
            System.out.println();
        }

        return cross;
    }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

}
