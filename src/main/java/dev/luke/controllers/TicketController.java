package dev.luke.controllers;

//import com.google.gson.Gson;
//import dev.luke.driver.Main;
//import dev.luke.driver.MenuDriver;
//import dev.luke.entities.Ticket;
//import io.javalin.http.Handler;
//import org.postgresql.Driver;

//public class TicketController {
//    public Handler createTicket = (ctx) ->{
//        String json = ctx.body();
//        Gson gson = new Gson();
//        Ticket ticket = gson.fromJson(json, Ticket.class);
//        Ticket registeredTicket = Main.ticketService.addNewTicket(ticket);
//        String ticketJson = gson.toJson(registeredTicket);
//        ctx.status(201); //This is a status code that will tell us how things went
//        ctx.result(ticketJson);
//    };

//    public Handler getTicketByStatus = (ctx) ->{
//        int id = Integer.parseInt(ctx.pathParam("id"));//This will take what value was in the {id} and turn it into an int for us to use
//        Ticket ticket = Driver.bookService.getBookById(id);
//        Gson gson = new Gson();
//        String json = gson.toJson(ticket);
//        ctx.result(json);
//    };

//    public Handler updateBookHandler = (ctx) ->{
//        String bookJSON = ctx.body();
//        Gson gson = new Gson();
//        Book book = gson.fromJson(bookJSON, Book.class);
//        Book updateBook = Driver.bookService.updateBook(book);
//        String json = gson.toJson(updateBook);
//        ctx.result(json);
//    };
//
//
//    public Handler deleteBookHandler = (ctx) ->{
//        int id = Integer.parseInt(ctx.pathParam("id"));
//        boolean result = Driver.bookService.deleteBookById(id);
//        if(result){
//            ctx.status(204);
//        }
//        else{
//            ctx.status(400);
//            ctx.result("Could not process your delete request");
//        }
//    };

//}
