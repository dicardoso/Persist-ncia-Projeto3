package aplicacao_console;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Listar {
	public Listar(){
		try {
			Fachada.inicializar();
			System.out.println("#### LISTAGEM ####");
			System.out.println("\nListagem de Vídeos:");
			for(Video v : Fachada.listarVideos() )		
				System.out.println(v);

			System.out.println("\nListagem de Usuários:");
			for(Usuario u : Fachada.listarUsuarios())	
				System.out.println(u);
			
			System.out.println("\nListagem de Visualizações:");
			for(Visualizacao v : Fachada.listarVisualizacoes())	
				System.out.println(v);
			
			System.out.println("\nListagem de Assuntos:");
			for(Assunto a : Fachada.listarAssuntos())	
				System.out.println(a);
			
			System.out.println("\nLocalizar Visualização: 3");
			Visualizacao v = Fachada.localizarVisualizacao(3);
			System.out.println(v);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

