package sample;

import java.sql.*;

public class DbConn {

    public boolean login(String email,String password,String employee) throws Exception{

        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/easymedi","root","password");
        String query="select nic from "+employee+" where email=? and password=?";
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();

        return rs.next();
    }

    public boolean registration(String employee,String nic,String name,String dob,String address,String mobile,String email,String regNo,
                                String regState,String exp,String sp,String pass) throws SQLException {

        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/easymedi","root","password");
        String query="insert into "+employee+" (nic,name,dob,address,mobile,email,regNo,regState,experience,specialization,password)" +
                " values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setString(1,nic);
        ps.setString(2,name);
        ps.setString(3,dob);
        ps.setString(4,address);
        ps.setString(5,mobile);
        ps.setString(6,email);
        ps.setString(7,regNo);
        ps.setString(8,regState);
        ps.setString(9,exp);
        ps.setString(10,sp);
        ps.setString(11,pass);

        if(ps.executeUpdate()==1){
            return true;
        }
        else {
            return false;
        }

    }

    public boolean userExistregNo(String regNo,String employee) throws SQLException {
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/easymedi","root","password");
        String query="select nic from "+employee+" where regNo=?";
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setString(1,regNo);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            return false;
        }
        else {
            return true;
        }

    }
}

