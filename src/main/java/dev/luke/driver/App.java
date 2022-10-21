package dev.luke.driver;

import dev.luke.handler.HelloHandler;
import io.javalin.Javalin;


public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        HelloHandler helloHandler = new HelloHandler();

        app.get("/hello",helloHandler);

        app.start();
    }
}
