/*	André Testai Muchao, RM: 99637
	Caio Davi Gomes Munhoz, RM: 97970
	Florbela Freitas Oliveira, RM: 99475 
	Jaquelline Aparecida Candido Barbosa de Sousa, RM: 99553 
 **/

package br.com.fiap.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.controller.FilmeController;
import br.com.fiap.model.bean.Filme;

public class FilmeView {

	public static void main(String[] args) {
		FilmeController filme = new FilmeController();
		String codigo, titulo, genero, produtora, escolha = "sim";
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n1. Inserir filme \n2. Alterar filme \n3. Excluir filme"));
				switch (opcao) {
				case 1:
					codigo = JOptionPane.showInputDialog("Digite o código do filme");
					titulo = JOptionPane.showInputDialog("Digite o título do filme");
					genero = JOptionPane.showInputDialog("Digite o gênero do filme");
					produtora = JOptionPane.showInputDialog("Digite a produtora do filme");
					JOptionPane.showMessageDialog(null, filme.insereFilme(codigo, titulo, genero, produtora));
					break;
				case 2:
					codigo = JOptionPane.showInputDialog("Digite o código do filme");
					titulo = JOptionPane.showInputDialog("Digite o título do filme");
					genero = JOptionPane.showInputDialog("Digite o gênero do filme");
					produtora = JOptionPane.showInputDialog("Digite a produtora do filme");
					JOptionPane.showMessageDialog(null, filme.alteraFilme(codigo, titulo, genero, produtora));
					break;
				case 3:
					codigo = JOptionPane.showInputDialog("Digite o código do filme");
					JOptionPane.showMessageDialog(null, filme.excluiFilme(codigo));
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida.");
				}
				ArrayList<Filme> filmes = filme.listaTodosFilmes();
				String str = "Filmes cadastrados: \n";
				for (Filme f : filmes) {
					str += "Título: " + f.getTitulo() + " | Gênero: " + f.getGenero() + " | Produtora: " + f.getProdutora() + "\n";
				}
				JOptionPane.showMessageDialog(null, str);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar? <Sim / Não>");
		}
		JOptionPane.showMessageDialog(null, "Programa finalizado.");
	}

}
