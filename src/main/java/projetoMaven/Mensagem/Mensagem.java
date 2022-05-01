package projetoMaven.Mensagem;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

public class Mensagem {
	
	//user
	public static void usuarioSalvo() {
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}
	public static void usuarioSenhaErrada() {
		JOptionPane.showMessageDialog(null, "As senhas não são iguais!");
	}
	public static void usuarioCampoVazio() {
		JOptionPane.showMessageDialog(null, "Campo/s vazio/s!");
	}
	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usuário exluido com sucesso!");
	}
	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
	}
	
	//bank dice
	public static void bancoErro(IllegalArgumentException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	public static void bancoErro(PersistenceException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	public static void bancoErro() {
		JOptionPane.showMessageDialog(null, "Erro com o banco de dados");	
	}
	public static void bancoBuscarPorLetra(NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Não é permitido letras, apenas números. " + e.getMessage());
	}
	
	//Exception
	public static void exception(Exception e) {
		JOptionPane.showMessageDialog(null, "Erro. " + e.getMessage());
	}
	
	//e-mail
	public static void emailEnviadoUsuario() {
		JOptionPane.showMessageDialog(null, "Senha enviada com sucesso!");
	}
	public static void emailErro() {
		JOptionPane.showConfirmDialog(null, "Houve Algum erro");
	}
	
	//Canal
	public static void canalOpcaoInvalida() {
		JOptionPane.showConfirmDialog(null, "Opção errada.");
	}
}
