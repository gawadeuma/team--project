package utilities;

import java.sql.Connection;

public interface DbConnection {
    public Connection getConnection(Connection connection);
}
