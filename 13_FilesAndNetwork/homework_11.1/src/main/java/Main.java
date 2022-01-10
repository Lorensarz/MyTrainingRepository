import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите путь до папки: ");
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            long folderSize = FileUtils.calculateFolderSize(input);

            System.out.println(FileUtils.sizeFormat(folderSize));


        }


    }
}

