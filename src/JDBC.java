import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        ResultSet data = SelectSQL("select * from engineeringstudents;",
                ConnectorSQL("root", "1234", "jdbc:mysql://localhost:3306/University"));

        String txt = "";
        while (data.next()) {
            for (int i = 1; i <= 6; i++) {
                txt += data.getString(i) + " ";
            }
            txt += "\n";
        }
        System.out.println(txt);
    }

    public static Connection ConnectorSQL(String uname, String password, String url) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, uname, password);
            System.out.println("Conected");
            return conn;
        } catch (Exception e) {
            System.out.println("Connect Error!!!");
            System.out.print(e);
        }
        return null;
    }

    public static ResultSet SelectSQL(String q, Connection conn) {
        try {
            Connection con = conn;
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(q);
            return result;
        } catch (Exception e) {

        }
        return null;
    }
}

class Student {
    private int _ID;
    private String _name;

    Student() {
    };

    Student(int id, String name) {
        this._ID = id;
        this._name = name;
    }
}
