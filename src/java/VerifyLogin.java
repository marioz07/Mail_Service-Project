import java.sql.*;
public class VerifyLogin{
public static boolean checkLogin(String email, String password){
    boolean status = false;
    Connection con = GetCon.getCon();
    try{
        PreparedStatement ps = con.prepareStatement("Select * from MAILCASTINGUSER where email = ? and password =?");
        ps.setString(1, email);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        status = rs.next();
    } catch(SQLException e){
        e.printStackTrace();
    }
    return status;
    }
}