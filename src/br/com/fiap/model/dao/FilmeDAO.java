/*	André Testai Muchao, RM: 99637
	Caio Davi Gomes Munhoz, RM: 97970
	Florbela Freitas Oliveira, RM: 99475 
	Jaquelline Aparecida Candido Barbosa de Sousa, RM: 99553 
 **/

package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Filme;

public class FilmeDAO {
	private Connection con;

	public FilmeDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Filme filme) {
		String sql = "insert into tb_ddd_filmes(codigo, titulo, genero, produtora) values(?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Filme filme) {
		String sql = "update tb_ddd_filmes set titulo = ?, genero = ?, produtora =?";
		sql += "where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getGenero());
			ps.setString(3, filme.getProdutora());
			ps.setString(4, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Filme filme) {
		String sql = "delete from tb_ddd_filmes where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Filme> listarTodos(){
		String sql = "select * from tb_ddd_filmes";
		ArrayList<Filme> listaFilme = new ArrayList<Filme>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Filme fl = new Filme();
					fl.setCodigo(rs.getString(1));
					fl.setTitulo(rs.getString(2));
					fl.setGenero(rs.getString(3));
					fl.setProdutora(rs.getString(4));
					listaFilme.add(fl);
				}
				return listaFilme;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
}