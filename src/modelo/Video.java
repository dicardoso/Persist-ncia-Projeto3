package modelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="video20191370005")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Version
	private int versao;
	private String link;
	private String nome;
	private double classificacao = 0;
	
	@Column(columnDefinition = "TIMESTAMP")	//columnDefinition="TIMESTAMP"
	private LocalDateTime datahora;
	
	@ManyToMany(mappedBy="videos",cascade={CascadeType.ALL}) 
	private List<Assunto> assuntos = new ArrayList<>();
	
	@OneToMany(mappedBy="video", cascade={CascadeType.PERSIST,CascadeType.MERGE}) 	
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Video (){}
	public Video(String link, String nome, Assunto assunto) {
		this.link = link;
		this.nome = nome;
		this.assuntos.add(assunto);
		this.datahora = LocalDateTime.now();
		this.classificacao = 0;
	}
		
	public String getNome() {
		return nome;
	}
	
	public String getLink() {
		return link;
	}
	
	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}
	
	public double getClassificacao() {
		double total = 0;
		for (Visualizacao v: this.visualizacoes) {
			if(v != null)
				total += v.getNota();
		}
		if (total > 0)
			return total/visualizacoes.size();
		return 0;
	}
	
	public List<Assunto> getAssuntos() {
		return assuntos;
	}
	
	public String getPalavras() {
		String texto = "";
		for(Assunto a: assuntos) {
			texto += a.getPalavra() + (assuntos.indexOf(a) == assuntos.size()-1 ?"" :", ");
		}
		return texto;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	
	public void remover(Visualizacao vis) {
		vis.setVideo(null);
		visualizacoes.remove(vis);
	}	

	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + classificacao ;
		
		texto+=", assuntos= ";
		for(Assunto a : assuntos) {
			texto += a.getPalavra() + " ";
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}
}
