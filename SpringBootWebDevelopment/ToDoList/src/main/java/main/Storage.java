package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static final HashMap<Integer, Todo> todos = new HashMap<>();

    public static int addTodo(Todo todo) {
        int id = currentId++;
        todo.setId(id);
        todos.put(id, todo);
        return id;
    }

    public static Todo deleteTodo(int todoId) {
        if (todos.containsKey(todoId)) {
            return todos.remove(todoId);
        }
        return null;
    }

    public static Todo getTodo(int todoId) {
        if (todos.containsKey(todoId)) {
            return todos.get(todoId);
        }
        return null;
    }

    public static Todo refreshTodo(int todoId, String name, String descrition, Boolean done) {

        if (todos.containsKey(todoId)) {
            Todo updatedTodo = todos.get(todoId);
            updatedTodo.setName(name);
            updatedTodo.setDescription(descrition);
            updatedTodo.setDone(done);
            return updatedTodo;
        }
        return null;
    }

    public static Todo updateTodoDone(int todoId, boolean done) {

        if (todos.containsKey(todoId)) {
            Todo updatedTodo = todos.get(todoId);
            updatedTodo.setDone(done);
            return updatedTodo;
        }
        return null;
    }

    public static List<Todo> getAllTodos() {
        ArrayList<Todo> todoArrayList = new ArrayList<>();
        todoArrayList.addAll(todos.values());
        return todoArrayList;
    }

    public static void deleteAllTodos() {
        todos.clear();
    }
}
