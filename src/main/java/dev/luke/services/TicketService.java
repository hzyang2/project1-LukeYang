package dev.luke.services;

import dev.luke.entities.Ticket;
import dev.luke.entities.User;

import java.util.List;

public interface TicketService {
    User getUser(String email);

    void addNewUser(User user);

    void addNewTicket(Ticket ticket);

    void saveTicket(Ticket ticket);

    List<Ticket> getTicketsByStatus(String status, User user);
}
