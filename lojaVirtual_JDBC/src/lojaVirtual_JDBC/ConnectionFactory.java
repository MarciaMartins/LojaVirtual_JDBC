package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	public DataSource dataSource;
	
	public ConnectionFactory(){
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl("jdbc:mysql://localhost/loja_virtual");
		combo.setUser("root");
		combo.setPassword("1234");
		
		combo.setMaxPoolSize(15);
		
		this.dataSource = combo;
	}
	
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}
