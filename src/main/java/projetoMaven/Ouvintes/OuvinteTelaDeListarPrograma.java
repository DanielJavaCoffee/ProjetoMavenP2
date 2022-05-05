package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projetoMaven.Telas.TelaDeListarPrograma;

public class OuvinteTelaDeListarPrograma implements ActionListener {
	
	public TelaDeListarPrograma telaDeListarPrograma;
	
	public TelaDeListarPrograma getTelaDeListarPrograma() {
		return telaDeListarPrograma;
	}
	
	public OuvinteTelaDeListarPrograma(TelaDeListarPrograma tela) {
		this.telaDeListarPrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	public void actionPerformedExcluir(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformedAtualizar(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
