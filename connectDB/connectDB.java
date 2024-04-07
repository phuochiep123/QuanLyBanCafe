package demosql;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class connectDB {
    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public connectDB() {
        Properties p = new Properties();
        try {
            FileInputStream fin = new FileInputStream(new File("libs/conf.properties"));
            p.load(fin);
            String host = p.getProperty("ServerID");
            String port = p.getProperty("Port");
            String dbname = p.getProperty("Database");
            String user = p.getProperty("Username");
            String pw = p.getProperty("Password");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbname;
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Đã kết nối!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Lỗi 100:: Không tìm thấy lớp");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Lỗi 102:: Cấu hình bị trống");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi 103:: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new connectDB();
    }
}
