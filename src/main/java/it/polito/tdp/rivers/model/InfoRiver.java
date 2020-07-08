package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class InfoRiver {
	
	double avg;
	LocalDate dataminDate;
	LocalDate datamaxDate;
	int numerotot;
	
	public InfoRiver(double avg, LocalDate dataminDate, LocalDate datamaxDate, int numerotot) {
		super();
		this.avg = avg;
		this.dataminDate = dataminDate;
		this.datamaxDate = datamaxDate;
		this.numerotot = numerotot;
	}

	
	
	public int getNumerotot() {
		return numerotot;
	}



	public void setNumerotot(int numerotot) {
		this.numerotot = numerotot;
	}



	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public LocalDate getDataminDate() {
		return dataminDate;
	}

	public void setDataminDate(LocalDate dataminDate) {
		this.dataminDate = dataminDate;
	}

	public LocalDate getDatamaxDate() {
		return datamaxDate;
	}

	public void setDatamaxDate(LocalDate datamaxDate) {
		this.datamaxDate = datamaxDate;
	}
	
	
	

}
