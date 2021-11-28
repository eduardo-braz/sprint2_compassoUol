import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(
				"jdbc:mysql://localhost/avaliacao_sprint2?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("usuario");
		comboPooledDataSource.setPassword("senha1234");
		this.dataSource = comboPooledDataSource;
	}

	public Connection conexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
