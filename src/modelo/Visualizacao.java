package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import dao.TriggerListener;

@Entity
@EntityListeners( TriggerListener.class )
@Table (name="visualizacao20191370005")
public class Visualizacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nota;
	@ManyToOne(cascade={CascadeType.ALL})
	private Usuario usuario;
	@ManyToOne(cascade={CascadeType.ALL})
	private Video video;
	@Version
	private int versao;
	private String idade;
	private LocalDateTime datahora =  LocalDateTime.now().minusHours(5).minusMinutes(15).minusSeconds(40);
	
	public Visualizacao() {}
	public Visualizacao(int nota, Usuario usuario, Video video) {
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}
	
	public void adicionar(Video video) {
		this.video = video;
	}
	
	public void adicionar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getNota() {
		return nota;
	}
	
	public Video getVideo() {
		return video;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIdade() {
		return idade;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}
	
	@Override
	public String toString() {
		String dataFormatada = datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
		return "Visualizacao [id= " + id +  ", data= " + dataFormatada +
				", nota= " + nota +
				"\n usuario= " + usuario.getEmail() + ", video= " + video.getNome() + "]\n";
	}
}
