package ro.raluca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class CreareCont {
	
	@Id
	private int idCreareCont;

	private String utilizator;
	private String parola;
	
	@OneToMany(cascade=CascadeType.ALL)	 
	@JoinColumn(name="idCreareCont")	     
	private List<Cont> cont = new ArrayList<Cont>();
	
	@SuppressWarnings("unused")
	public CreareCont() {		
	}
	
	public CreareCont(String utilizator, String parola) {
		this.utilizator=utilizator;
		this.parola=parola;
	}
	
	public List<Cont> getCont() {	
		return cont;
	}	
	public void setCont(List<Cont> cont) {		
		this.cont= cont;
	}
	public int getIdCreareCont() {
		return idCreareCont;
	}
	public void setIdCreareCont(int idCreareCont) {
		this.idCreareCont = idCreareCont;
	}
	public String getUtilizator() {
		return utilizator;
		}
	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
}
