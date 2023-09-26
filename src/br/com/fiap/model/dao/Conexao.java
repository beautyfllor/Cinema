/*	André Testai Muchao, RM: 99637
	Caio Davi Gomes Munhoz, RM: 97970
	Florbela Freitas Oliveira, RM: 99475 
	Jaquelline Aparecida Candido Barbosa de Sousa, RM: 99553 
 **/

package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection abrirConexao() throws ClassNotFoundException, SQLException{
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		con = DriverManager.getConnection(url, "user", "password");
		return con;
	}
	
	public static void fecharConexao(Connection con) throws SQLException{
		con.close();
	}
}
