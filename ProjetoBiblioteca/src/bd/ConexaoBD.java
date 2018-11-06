package bd;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD conexaoBD;

    private BasicDataSource dataSource;
    private String user = "adm";
    private String pass = "adm";
    private String driver = "oracle.jdbc.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";

    private ConexaoBD() {
        dataSource = new BasicDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
    }

    public static ConexaoBD getInstance() {
        if(conexaoBD == null) {
            conexaoBD = new ConexaoBD();
        }
        return conexaoBD;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
