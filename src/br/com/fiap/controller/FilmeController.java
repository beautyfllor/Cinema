/*	André Testai Muchao, RM: 99637
	Caio Davi Gomes Munhoz, RM: 97970
	Florbela Freitas Oliveira, RM: 99475 
	Jaquelline Aparecida Candido Barbosa de Sousa, RM: 99553 
 **/

package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Filme;
import br.com.fiap.model.dao.Conexao;
import br.com.fiap.model.dao.FilmeDAO;

public class FilmeController {
	public String insereFilme (String codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FilmeDAO fd = new FilmeDAO(con);
		Filme fb = new Filme();
		fb.setCodigo(codigo);
		fb.setTitulo(titulo);
		fb.setGenero(genero);
		fb.setProdutora(produtora);
		resultado = fd.inserir(fb);
		Conexao.fecharConexao(con);
		return resultado;	
	}
	
	public String alteraFilme (String codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FilmeDAO fd = new FilmeDAO(con);
		Filme fb = new Filme();
		fb.setCodigo(codigo);
		fb.setTitulo(titulo);
		fb.setGenero(genero);
		fb.setProdutora(produtora);
		resultado = fd.alterar(fb);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String excluiFilme (String codigo) throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FilmeDAO fd = new FilmeDAO(con);
		Filme fb = new Filme();
		fb.setCodigo(codigo);
		resultado = fd.excluir(fb);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public ArrayList<Filme> listaTodosFilmes() throws ClassNotFoundException, SQLException  {
		ArrayList<Filme> resultado = new ArrayList<Filme>();
		Connection con = Conexao.abrirConexao();
		FilmeDAO filmeDAO = new FilmeDAO(con);
		resultado = filmeDAO.listarTodos();
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
		
	}
}