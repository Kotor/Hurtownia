package com.example.hurtownia;

public class ModelTowar {
	public int id;
	public int idTowar;
	public int ilosc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTowar() {
		return idTowar;
	}
	public void setIdTowar(int idTowar) {
		this.idTowar = idTowar;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	public int getPalety() {
		return palety;
	}
	public void setPalety(int palety) {
		this.palety = palety;
	}
	public String getNazwaTowar() {
		return nazwaTowar;
	}
	public void setNazwaTowar(String nazwaTowar) {
		this.nazwaTowar = nazwaTowar;
	}
	public int palety;
	public String nazwaTowar;
}
