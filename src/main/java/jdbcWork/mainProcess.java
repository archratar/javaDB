package jdbcWork;

import java.sql.*;

public class mainProcess {
    public static void main(String[] args) {

//        ReadWrapper.print();

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/sport";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, "root", "17451745");

            Statement stmt = connection.createStatement();
            String sql = "select * fro client;";
            ResultSet rs = stmt.executeQuery(sql);

            ResultSet rr = connection.createStatement().executeQuery("select * from client");

            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                int iddisc = rs.getInt("iddiscount");

                System.out.println("Id - " + id + ", fname - " + fname + " , lname - " + lname + ", iddiscount - " + iddisc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
