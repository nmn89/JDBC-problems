import java.sql.*;
import java.io.*;
public class insert {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/learner";
        String user="root";
        String password="Naman@code22";
        String line;
        String path = "C:/Users/naman sharma/Downloads/airtravel.csv";
        String[] arry;
        BufferedReader bf = new BufferedReader(new FileReader(path));
        bf.readLine();
        try{Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection con=DriverManager.getConnection(url, user, password); 
        Statement st=con.createStatement();  
        while((line=bf.readLine())!=null && !line.isEmpty()){
            arry = line.split(",");
            String mon = arry[0];
            String y58 = arry[1];
            String y59 = arry[2];
            String y60 = arry[3];
            String sql = "Insert into airtravel values(?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,mon);
            ps.setString(2,y58);
            ps.setString(3,y59);
            ps.setString(4,y60);
            int rs = ps.executeUpdate();
            System.out.println(rs + "records inserted");
        }
        bf.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
