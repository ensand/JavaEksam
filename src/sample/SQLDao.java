package sample;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLDao {

    private Connection connect() {
        String username = "";
        String password = "";

        String url = "jdbc:sqlite:C:/Users/ensand/IdeaProjects/JavaEksam/src/sample\\data";
        Connection conn = null;

        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public Map<String, Tuba> selectAll() {
        String sql = "SELECT tuba.id, tuba.pikkus, tuba.laius, tuba.uks FROM tuba";

        Map<String, Tuba> ruumideList = new HashMap<String, Tuba>();

        try(Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                Tuba ruum = new Tuba();
                ruum.nimi = rs.getString("id");
                ruum.pikkus = rs.getFloat("pikkus");
                ruum.laius = rs.getFloat("laius");
                ruum.uks = rs.getFloat("uks");
                ruumideList.put(ruum.nimi, ruum);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ruumideList;
    }

}
