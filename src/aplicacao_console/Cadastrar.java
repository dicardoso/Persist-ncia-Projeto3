package aplicacao_console;

import fachada.Fachada;

public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Fachada.cadastrarVideo("video.com/javaFilme","Java - O Filme","filmes");
			Fachada.cadastrarVideo("video.com/javax","Javax","musicas");
			Fachada.cadastrarVideo("video.com/jornalJava1","Jornal Java 1","noticias");
			Fachada.cadastrarVideo("video.com/masterJava","Master Java","culinaria");
			Fachada.cadastrarVideo("video.com/javapython","Java vs Python","politica");
			Fachada.cadastrarVideo("video.com/javascript","Javascript não é Java","politica");
			Fachada.cadastrarVideo("video.com/it","It - O Filme","filmes");
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("Visualização");
			Fachada.registrarVisualizacao("video.com/javaFilme", "diogo@gmail.com", 4);
			Fachada.registrarVisualizacao("video.com/javaFilme", "ze@gmail.com", 5);
			Fachada.registrarVisualizacao("video.com/javax", "maria@gmail.com", 2);
			Fachada.registrarVisualizacao("video.com/masterJava", "ze@gmail.com", 5);
				
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}

	public void cadastrar(){

	}	

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


