import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {


        final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
        final String USER = "root";
        final String PASS = "admin";
        Connection connection = null;
        public void createTable(){
            try {


            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String queryCreate ="""
                    CREATE TABLE IF NOT EXISTS students
                    ( student_id INTEGER(10) NOT NULL AUTO_INCREMENT,
                    last_name VARCHAR(30),
                    first_name VARCHAR(30),
                    CONSTRAINT students_pk PRIMARY KEY(student_id)
                    );""";
            statement.executeUpdate(queryCreate);
            statement.close();
                System.out.println("eseguito con successo");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public void insertTable(String last_name, String first_name){
        try {


            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String queryInsert = "INSERT INTO students (last_name, first_name) VALUES ('" +last_name+ "', '" + first_name + "');";
            statement.executeUpdate(queryInsert);
            statement.close();
            System.out.println("eseguito con successo");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
