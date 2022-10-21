package dev.luke.controllers;

import com.google.gson.Gson;
import dev.luke.driver.Main;
//import dev.luke.driver.MenuDriver;
import dev.luke.entities.Ticket;
import dev.luke.entities.User;
import io.javalin.http.Handler;
import org.postgresql.Driver;

import java.util.List;

public class TicketController {
    public Handler addNewUser = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        User addNewUser = Main.ticketService.addNewUser(user);
        String userJason = gson.toJson(addNewUser);
        ctx.status(201); //This is a status code that will tell us how things went
        ctx.result(userJason);
    };

    public Handler getAllUsers = (ctx) ->{
        String JSON = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(JSON, User.class);
        User updateUser = Main.ticketService.getAllUsers(user.getEmail());
        String json = gson.toJson(updateUser);
        ctx.result(json);
    };

    public Handler getTicketsByStatus = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//This will take what value was in the {id} and turn it into an int for us to use
        String status = "";
        User user = null;
        List<Ticket> ticket = Main.ticketService.getTicketsByStatus(status, user);
        Gson gson = new Gson();
        String json = gson.toJson(ticket);
        ctx.result(json);
    };

    public Handler addNewTicket = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        Ticket ticket = gson.fromJson(json, Ticket.class);
        Ticket addNewTicket = Main.ticketService.addNewTicket(ticket);
        String ticketJson = gson.toJson(addNewTicket);
        ctx.status(201); //This is a status code that will tell us how things went
        ctx.result(ticketJson);
    };
}
