package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/todos/")
    public List<Todo> list() {
        return Storage.getAllTodos();
    }

    @PostMapping("/todos/")
    public int add(Todo todo) {
        return Storage.addTodo(todo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Todo todo = Storage.getTodo(id);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Todo todo = Storage.deleteTodo(id);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity put(@PathVariable int id, String name, String description, boolean done) {
        Todo todo = Storage.refreshTodo(id, name, description, done);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @PatchMapping("/todos/{id}")
    public ResponseEntity patchDone(@PathVariable int id, boolean done) {
        Todo todo = Storage.updateTodoDone(id, done);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(todo, HttpStatus.OK);

    }

    @DeleteMapping("/todos/")
    public void deleteList() {
        Storage.deleteAllTodos();
    }
}
