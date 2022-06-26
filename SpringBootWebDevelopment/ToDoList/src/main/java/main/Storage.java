package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    private static final AtomicInteger currentId = new AtomicInteger(1);
    private static final ConcurrentHashMap<Integer, Todo> todos = new ConcurrentHashMap<Integer, Todo>();

    public static int addTodo(Todo todo) {
        int id = currentId.getAndIncrement();
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

    public static Todo refreshTodo(int todoId, String name, String description, Boolean done) {
        if (todos.containsKey(todoId)) {
            Todo updatedTodo = todos.get(todoId);
            updatedTodo.setName(name);
            updatedTodo.setDescription(description);
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
