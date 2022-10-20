package dev.luke.repositories;

import dev.luke.entities.Ticket;
import dev.luke.entities.User;
import dev.luke.util.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class TicketDaoPostgres implements TicketDao{
    @Override
    public User getUser(String email) {
        // try with resources. This will create our connection and end the connection when the try block is over
        // or if something fails, it will end after the catch
        try(Connection connection = ConnectionFactory.getConnection()){
            // Here is the unfun thing about JDBC, you have to write SQL statements in Java
            // I recommend putting in comments the SQL command you are trying to execute
            //INSERT INTO books VALUES (DEFAULT, 'Great Gatsby', 'F. Scott Fitts Jerald', 0);
            String sql = "select * from tickets where email = ?)";
            // The only thing in the sql String that isnt "just a string" are the question marks
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Parameters START at 1, they are not indexed at 0
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
//            ticket.setUser(rs.getString("user"));
            ticket.setAmount(rs.getDouble("amount"));
            ticket.setDescription(rs.getString("description"));
            ticket.setStatus(rs.getString("status"));

//            return ticket;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addNewUser(User user) {

    }

    @Override
    public void addNewTicket(Ticket ticket) {

    }

    @Override
    public void saveTicket(Ticket ticket) {

    }

    @Override
    public List<Ticket> getTicketsByStatus(String status, User user) {
        return null;
    }
}

//Test Now
