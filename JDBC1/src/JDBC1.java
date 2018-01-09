import java.sql.*;
public class JDBC1 {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://127.0.0.1:3306/testDB";
        String uname="root";
        String pass="didierdrogba";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection(url, uname, pass);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM MAINTABLE;");
        while(resultSet.next()){
            int id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            System.out.println(id+"\t"+name+"\n");
        }

        statement.close();
        connection.close();
    }
}