import java.util.ArrayList;

public class TodoList {


    ArrayList<String> todoList = new ArrayList<>();


    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("");


    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index <= todoList.size()) {
            todoList.add(index, todo);

        }

    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения


    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела


    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел


        return new ArrayList<>();
    }

}