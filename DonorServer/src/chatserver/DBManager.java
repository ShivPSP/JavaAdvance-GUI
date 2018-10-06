package chatserver;

import java.sql.*;

public class DBManager {

    private static final String DBDriver = "com.mysql.jdbc.Driver";
    private static final String DBUrl = "jdbc:mysql://localhost:3306/chat";
    private static final String DBUser = "root";
    private static final String DBPassword = "root";

    static {
        try {
            Class.forName(DBDriver);
        } catch (Exception e) {
        }
    }

    public static int registerUser(String userId, String passwd, String name, String email, String mno,String bloodGroup,String location) {
        int x = 0;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Insert into users  Values(?,?,?,?,?,?,?)");

            st.setString(1, userId);
            st.setString(2, passwd);
            st.setString(3, name);
            st.setString(4, email);
            st.setString(5, mno);
            st.setString(6, bloodGroup);
            st.setString(7, location);
            x = st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception ex) {
        }

        return x;
    }
    public static boolean isUserIdAvailable(String userId) {
        boolean flag=true;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from users where UserId=?");

            st.setString(1, userId);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                flag=false;
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return flag;
    }
    public static boolean authenticateUser(String userId, String passwd) {
        boolean flag=false;
        try {
            Connection con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from users where UserId=? and Passwd=?");

            st.setString(1, userId);
            st.setString(2, passwd);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                flag=true;
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return flag;
    }
}
