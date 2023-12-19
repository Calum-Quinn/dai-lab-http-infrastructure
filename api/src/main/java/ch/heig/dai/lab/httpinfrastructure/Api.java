package main.java.ch.heig.dai.lab.httpinfrastructure;

import io.javalin.Javalin;

public class Api {
    public static void main(String[] args) {
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);
    }
}