import net.sf.saxon.expr.Component;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите команду: ");

        while (true) {
            String todo = scanner.nextLine();
            String[] splitTodo = (todo.split("\\s+"));
            String command = splitTodo[0];

            if (command.equals("ADD")) {
                String[] result = todo.split(" ", 2);
                String resultTodo = result[1];
                todoList.add(todo);
                System.out.println("Добавлено дело: " + resultTodo);

            }

            if (command.equals("LIST")) {
                todoList.getTodos();

            }
        }
    }
}

