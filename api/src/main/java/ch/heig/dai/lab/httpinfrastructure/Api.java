package ch.heig.dai.lab.httpinfrastructure;

import io.javalin.Javalin;

/**
 * Todos api
 * This code is based on the dai-codeexamples :
 * <a href="https://github.com/HEIGVD-Course-DAI/dai-codeexamples/blob/main/6-http/javalin/src/main/java/app/Main.java">...</a>
 */
public class Api {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        TodoController todoController = new TodoController();
        app.get("/api/todos", todoController::getAll);
        app.get("/api/todos/{id}", todoController::getOne);
        app.post("/api/todos", todoController::create);
        app.put("/api/todos/{id}", todoController::update);
        app.delete("/api/todos/{id}", todoController::delete);
    }
}