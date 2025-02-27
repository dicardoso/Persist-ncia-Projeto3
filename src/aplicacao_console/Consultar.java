package aplicacao_console;

import fachada.Fachada;

public class Consultar {

	public Consultar(){
		try {
			Fachada.inicializar();
			
			System.out.println("\nV�deos por assunto: Pol�tica");
			System.out.println(Fachada.consultarVideosPorAssunto("politica"));
			
			System.out.println("\nV�deos por usu�rio: Z�");
			System.out.println(Fachada.consultarVideosPorUsuario("ze@gmail.com"));
			
			System.out.println("\nUsu�rios por v�deo: Java");
			System.out.println(Fachada.consultarUsuariosPorVideo("video.com/javaFilme"));
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}
		System.out.println("\nFim do programa!");
	}

	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

