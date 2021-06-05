package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table (name="assunto20191370005")
public class Assunto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String palavra;
	@Version
	private int versao;
	@ManyToMany(cascade={CascadeType.ALL})
	private List<Video> videos = new ArrayList<>();
	
	public Assunto() {}
	public Assunto(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavra() {
		return palavra;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}
	
	@Override
	public String toString() {
		String texto = "Assunto: palavra= " + palavra + " Vídeos: { ";
		for(Video v : videos) {
			texto += v.getNome() + ", ";
		}
		texto += "}";
		return texto;
	}
	
	
	
}
