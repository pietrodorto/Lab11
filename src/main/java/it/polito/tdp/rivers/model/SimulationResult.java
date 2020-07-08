package it.polito.tdp.rivers.model;

public class SimulationResult {
	
	int numDisservizio;
	double occMedia;
	River river;
	
	
	public SimulationResult(int numDisservizio, double occMedia, River river) {
		super();
		this.numDisservizio = numDisservizio;
		this.occMedia = occMedia;
		this.river = river;
	}


	public int getNumDisservizio() {
		return numDisservizio;
	}


	public void setNumDisservizio(int numDisservizio) {
		this.numDisservizio = numDisservizio;
	}


	public double getOccMedia() {
		return occMedia;
	}


	public void setOccMedia(double occMedia) {
		this.occMedia = occMedia;
	}


	public River getRiver() {
		return river;
	}


	public void setRiver(River river) {
		this.river = river;
	}
	
	
	
	
	
	
	

}
