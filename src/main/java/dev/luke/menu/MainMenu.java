package dev.luke.menu;

import dev.luke.repositories.TicketDao;
import dev.luke.entities.Ticket;
import dev.luke.entities.User;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public MainMenu(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }
    private TicketDao ticketDao;
    private Scanner scan = new Scanner(System.in);
    public User registerUser() {
        String password, email;
        System.out.println("Please enter your email: ");
        email = this.scan.next();
        System.out.println("Please enter your password: ");
        password = this.scan.next();
        String role = "Employee";
        System.out.println("If you are a manager, please enter your authorized id otherwise enter nothing.");
        String managerPassword = this.scan.next();
        if (managerPassword.equals("mgr")) //TODO: for security, use a secret...
            role = "Manager";
        User user = new User(email, password, role);
        //TODO: throw exception if duplicate email?
        this.ticketDao.addNewUser(user);
        user.isAuthenticated = true;
        return user;
    }

    public User loginUser() {
        String password, email;
        System.out.println("Please enter email: ");
        email = this.scan.next();
        System.out.println("Please enter password: ");
        password = this.scan.next();
        User user = this.ticketDao.getAllUsers(email);
        if (user == null || user.getPassword().equals(password) == false) {
            System.out.println("invalid credentials");
            user.isAuthenticated = false;
        }
        user.isAuthenticated = true;
        return user;
    }

    public void viewTickets(int selection, Menu menu, User user) {
        String statusFilter = menu.getMenuCode(selection - 1); //ArrayList is index-0.
        System.out.println("View " + statusFilter + " tickets.");
        List<Ticket> tickets = this.ticketDao.getTicketsByStatus(statusFilter, user);
        for (Ticket tkt : tickets) {
            if (statusFilter == "all" || statusFilter == tkt.getStatus())
                System.out.println(tkt.showUser());
        }
    }

    public void addTicket(User user) {
        System.out.print("Please enter amount: ");
        double amount = this.scan.nextDouble();
        System.out.print("Please enter description: ");
        String description = this.scan.next();
        Ticket ticket = new Ticket(user, amount, description);
        this.ticketDao.addNewTicket(ticket);
    }
}
