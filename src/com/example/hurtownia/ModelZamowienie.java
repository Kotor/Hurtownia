package com.example.hurtownia;

import java.util.ArrayList;

public class ModelZamowienie {	
	public int id;
	public int numer;
	public int zamawiajacy;
	public String klient;
	public ArrayList<ModelTowar> listaTowarow = new ArrayList<ModelTowar>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumer() {
		return numer;
	}
	public void setNumer(int numer) {
		this.numer = numer;
	}
	public int getZamawiajacy() {
		return zamawiajacy;
	}
	public void setZamawiajacy(int zamawiajacy) {
		this.zamawiajacy = zamawiajacy;
	}
	public String getKlient() {
		return klient;
	}
	public void setKlient(String klient) {
		this.klient = klient;
	}
	public ArrayList<ModelTowar> getListaTowarow() {
		return listaTowarow;
	}
	public void setListaTowarow(ArrayList<ModelTowar> listaTowarow) {
		this.listaTowarow = listaTowarow;
	}
}
