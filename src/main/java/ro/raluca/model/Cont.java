package ro.raluca.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Cont {

	@Id
	private int idCont;
	private String note;
	private Date data;
	
	//@OneToMany(cascade=CascadeType.ALL)	 // Tipul legaturii dintre tabele
	@JoinColumn(name="id_CreareCont")
	private int idCreareCont;
	
	public Cont() {		
	}
	
	public Cont(String note, Date data, int id) {	
		this.note=note;
		this.data=data;
		this.idCreareCont=id;
	}
	
	public int getIdCont() {
		return idCont;
	}
	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdCreareCont() {
		return idCreareCont;
	}
	public void setIdCreareCont(int idCreareCont) {
		this.idCreareCont = idCreareCont;
	}

}
