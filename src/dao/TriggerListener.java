package dao;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

import modelo.Visualizacao;

public class TriggerListener{ 

	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
		//System.out.println(" @PrePersist... " + obj.getClass().getSimpleName());
	}

	@PostPersist
	public void exibirmsg2(Object obj) {
		//System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao p = (Visualizacao)obj;
			String idade = calcularIdade( p );
			//System.out.println("  idade anterior = "  +  p.getIdade() );
			p.setIdade(idade);
			//System.out.println("  idade calculada = " +  idade );
		}

	}

	@PostUpdate
	public void exibirmsg3(Object obj) {
		//System.out.println(" @PostUpdate... " + obj.getClass().getSimpleName() );
		if (obj instanceof Visualizacao)  {
			Visualizacao p = (Visualizacao)obj;
			//System.out.println("  idade anterior = "  +  p.getIdade() );			
			String idade = calcularIdade( p );
			p.setIdade(idade);
			//System.out.println("  idade calculada = " +  idade );
		}

	}
	
	@PostLoad
	public void exibirmsg4(Object obj) {
		//System.out.println(" @PostLoad... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao p = (Visualizacao)obj;
			//System.out.println("  idade anterior = "  +  p.getIdade() );
			String idade = calcularIdade( p );
			p.setIdade(idade);
			//System.out.println("  idade calculada = " +  idade );
		}
	}	

	@PostRemove
	public void exibirmsg5(Object obj) {
		//System.out.println(" @PostRemove.... " + obj.getClass().getSimpleName());
	}

	//============================================================
	public String calcularIdade(Visualizacao p) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime visu = p.getDatahora();

		Duration dur = Duration.between(visu, hoje);
		long millis = dur.toMillis();

		String idade = 
		String.format("%02d:%02d:%02d", 
		        TimeUnit.MILLISECONDS.toHours(millis),
		        TimeUnit.MILLISECONDS.toMinutes(millis) - 
		        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
		        TimeUnit.MILLISECONDS.toSeconds(millis) - 
		        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

		return idade;
	
	}

}