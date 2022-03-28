import java.sql.*;
import java.io.*;
public class grade {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/learner";
        String user="root";
        String password="Naman@code22";
        String line;
        String path = "C:/Users/naman sharma/Downloads/grades.csv";
        String[] arry;
        BufferedReader bf = new BufferedReader(new FileReader(path));
        bf.readLine();
        try{Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection con=DriverManager.getConnection(url, user, password); 
        Statement st=con.createStatement();  
        while((line=bf.readLine())!=null && !line.isEmpty()){
            arry = line.split(",");
            String name = arry[1].trim();
            String ssn = arry[2].trim();
            int t1 = Integer.parseInt(arry[3]);
            int t2 = Integer.parseInt(arry[4]);
            int t3 = Integer.parseInt(arry[5]);
            int t4 = Integer.parseInt(arry[6]);
            int fin = Integer.parseInt(arry[7]);
            String sql = "Insert into grades values(?,?,?,?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,ssn);
            ps.setInt(3,t1);
            ps.setInt(4,t2);
            ps.setInt(5,t3);
            ps.setInt(6,t4);
            ps.setInt(7,fin);
            int rs = ps.executeUpdate();
            System.out.println(rs + "records inserted");
        }
        bf.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}