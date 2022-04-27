package projetoMaven.Mensagem;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

public class Mensagem {
	
	//user
	public static void usuarioSalvo() {
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}
	public static void usuarioSenhaErrada() {
		JOptionPane.showMessageDialog(null, "As senhas n�o s�o iguais!");
	}
	public static void usuarioCampoVazio() {
		JOptionPane.showMessageDialog(null, "Campo vazio/s!");
	}
	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usu�rio exluido com sucesso!");
	}
	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");
	}
	
	//bank
	public static void bancoErro(IllegalArgumentException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	public static void bancoErro(PersistenceException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	public static void bancoErro() {
		JOptionPane.showMessageDialog(null, "Erro com o banco de dados");	
	}
	
	//e-mail
	public static void emailEnviadoUsuario() {
		JOptionPane.showMessageDialog(null, "Senha enviada com sucesso!");
	}
}
