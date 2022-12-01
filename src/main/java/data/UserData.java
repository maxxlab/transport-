package data;

import user.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class UserData {
    private final String url = "jdbc:postgresql://localhost:5432/TransportDB";
    private final String userDB = "postgres";
    private final String passwordDB = "Loco9969";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, userDB, passwordDB);
    }

    private List<User> userData = new ArrayList<>();

    public List<User> getUserData() {
        return userData;
    }

    public boolean logIn(String userName, String password) throws IOException {
        if (findUser(userName, password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean signUp(String userName, String password) throws IOException {

        findUser(userName, password);
        if (!userExists(userName)) {
            insertUser(new User(userName, password));
            return true;
        } else {
            return false;
        }

    }

    public long insertUser(User user) {
        String SQL = "INSERT INTO public.user(username,password) "
                + "VALUES(?,?)";

        long id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public boolean findUser(String username, String password) {
        String SQL = "SELECT username, password "
                + "FROM public.user "
                + "WHERE username = ? and password = ?";

        boolean userFind = false;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString("username"))
                        && password.equals(rs.getString("password"))) {
                    userFind = true;
                }
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userFind;
    }

    public boolean userExists(String username) {
        String SQL = "SELECT username "
                + "FROM public.user "
                + "WHERE username = ?";

        boolean userExist = false;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            userExist = userExists(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userExist;
    }

    private boolean userExists(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

}
