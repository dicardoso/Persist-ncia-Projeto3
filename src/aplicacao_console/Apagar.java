package aplicacao_console;

import fachada.Fachada;


public class Apagar {

	public Apagar(){
		try {
			Fachada.inicializar();
			try {
				Fachada.apagarVisualizacao(1);
				System.out.println("deletou visualização 1");
			}
			catch (Exception e) {System.out.println(e.getMessage());}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Apagar();
	}
}

