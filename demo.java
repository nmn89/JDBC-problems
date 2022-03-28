import java.sql.Statement;
import java.sql.*;
public class demo {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/learner";
        String user="root";
        String password="Naman@code22";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            Connection con=DriverManager.getConnection(url, user, password); 

            Statement st=con.createStatement(); 

            st.executeUpdate("Insert into employee value(105,'Harsh Sharma','Chennai')");

            ResultSet rs=st.executeQuery("Select * from employee");

            while(rs.next()){ 
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            con.close(); 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}