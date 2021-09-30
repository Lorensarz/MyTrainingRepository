import java.util.Scanner;


public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите команду: ");


        while (true) {
            String input = scanner.nextLine();
            String[] splitInput = (input.split("\\s+"));
            String command = splitInput[0];


            if (command.equals("ADD")) {
                String[] resultTodo = input.split(" ", 2);
                String todo = resultTodo[1];
                todoList.add(todo);
                System.out.println("Добавлено дело: " + todo);

            }

            if (command.equals("LIST")) {
                todoList.getTodos();
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println(i + " - " + todoList.getTodos().get(i));

                }

            }

            if (command.equals("DELETE")) {
                todoList.getTodos();
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println("Дело " + todoList.getTodos().get(i) + " удалено");
                    todoList.delete(i);

                }

            }

            if (command.equals("EDIT")) {
                String[] resultTodo = input.split(" ", 3);
                String todo = resultTodo[2];
                int index = Integer.parseInt(resultTodo[1]);
                todoList.getTodos();

                System.out.println("Дело " + todoList.getTodos().get(index) + " заменено на " + todo);
                todoList.edit(todo, index);

            }

        }
    }
}



