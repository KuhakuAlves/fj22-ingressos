package br.com.caelum.ingresso.model.form;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horario;
	
	@NotNull
	private Integer salaId;

	@NotNull
	private Integer filmeId;
	

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Sessao sessao = new Sessao( ); 
		sessao.setHorario(this.horario);
		sessao.setFilme(filmeDao.findOne(this.filmeId));
		sessao.setSala(salaDao.findOne(this.salaId));
		return sessao;
	}

}
