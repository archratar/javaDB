package jdbcWork;

import java.lang.reflect.Type;
import java.sql.*;

public class ReadWrapper {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/sport";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "17451745";

    public static void print() {
        Connection connection = null;
        Statement stmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = connection.createStatement();
            String sql = "SELECT * from client";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String age = rs.getString("fname");
                String first = rs.getString("lname");
                int last = rs.getInt("iddiscount");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            connection.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public void readFromClient (ResultSet rs) throws Exception {

        int id ;
        String age;
        String first;
        int last;

        while (rs.next()) {
//            id = rs.getInt(id fname);
        }
    }

    public ResultSet read() throws Exception {

        Connection conn = null;
        Statement stmt = null;

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql = "SELECT * from client";
        ResultSet rs = stmt.executeQuery(sql);

        return rs;
    }
}
