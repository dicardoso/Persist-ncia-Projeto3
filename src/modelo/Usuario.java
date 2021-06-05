package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table (name="usuario20191370005")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	@Version
	private int versao;
	@OneToMany(mappedBy = "usuario")
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Usuario() {}
	public Usuario(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	
	public List<Visualizacao> getListaVisualizacoes(){
		return visualizacoes;
	}
	
	public void remover(Visualizacao vis) {
		vis.setUsuario(null);
		visualizacoes.remove(vis);
	}
	
	public String getVisualizacoes(){
		String texto = "";
		for(Visualizacao v: visualizacoes) {
			if (v != null)
				texto += v.getId() + (visualizacoes.indexOf(v) == visualizacoes.size()-1 ?"" :", ");
		}
		return texto;
	}

	@Override
	public String toString() {
		String texto =  "Usuario [email=" + email + "]";
		
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += "\n\t" + vis;
		}
		return texto;
	}

	
	
	
}
