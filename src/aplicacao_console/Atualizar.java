package aplicacao_console;

import fachada.Fachada;

public class Atualizar {

	public Atualizar(){
		try {
			Fachada.inicializar();
			Fachada.adicionarAssunto("video.com/it","terror");
			Fachada.finalizar();
		}catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

