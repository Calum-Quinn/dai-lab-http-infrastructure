package ch.heig.dai.lab.httpinfrastructure;

import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TodoController
 * This code is based on the dai-codeexamples :
 * <a href="https://github.com/HEIGVD-Course-DAI/dai-codeexamples/blob/main/6-http/javalin/src/main/java/app/UserController.java">...</a>
 */
public class TodoController {
    private final ConcurrentHashMap<Integer, Todo> todos = new ConcurrentHashMap<>();
    private int lastId = 0;

    public TodoController() {
        // Add some Todos to the "database"
        todos.put(++lastId, new Todo("Buy a Lamborghini", true));
        todos.put(++lastId, new Todo("Do homework", false));
        todos.put(++lastId, new Todo("Go to the gym", false));
    }

    public void getRoot(Context ctx) {
        ctx.result("Todos API");
        System.out.println("GET /api");
    }

    public void getOne(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ctx.json(todos.get(id));
        System.out.println("GET /api/todos/" + id);
    }

    public void getAll(Context ctx) {
        ctx.json(todos);
        System.out.println("GET /api/todos");
    }

    public void create(Context ctx) {
        Todo todo = ctx.bodyAsClass(Todo.class);
        todos.put(++lastId, todo);
        ctx.status(201);
        System.out.println("POST /api/todos");
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        todos.remove(id);
        ctx.status(204);
        System.out.println("DELETE /api/todos/" + id);
    }

    public void update(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo todo = ctx.bodyAsClass(Todo.class);
        todos.put(id, todo);
        ctx.status(200);
        System.out.println("PUT /api/todos/" + id);
    }
}
