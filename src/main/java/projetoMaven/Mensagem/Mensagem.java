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
		JOptionPane.showMessageDialog(null, "Campo/s vazio/s!");
	}
	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usu�rio exluido com sucesso!");
	}
	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");
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
		JOptionPane.showMessageDialog(null, "N�o � permitido letras, apenas n�meros. " + e.getMessage());
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
		JOptionPane.showConfirmDialog(null, "Op��o errada.");
	}
	public static void canalSalvo() {
		JOptionPane.showMessageDialog(null, "Canal Salvo Com Sucesso!");
	}
	public static void canalExcluido() {
		JOptionPane.showMessageDialog(null, "Canal Exclu�do Com Sucesso!");
	}
	public static void canalNaoEncontardo() {
		JOptionPane.showMessageDialog(null, "Canal N�o Encontrado!");
	}
	
	// numberFormatException
	public static void numberFormatException(NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Erro." + e.getMessage());
	}
	// NullPointerException
	public static void nullPointerException(NullPointerException e) {
		JOptionPane.showMessageDialog(null, "Erro Ao se Conectar Com o Banco De Dados." + e.getMessage());
	}
}
