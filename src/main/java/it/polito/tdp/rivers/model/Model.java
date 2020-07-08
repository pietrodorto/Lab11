package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.rivers.db.RiversDAO;

	
	public class Model {
		
		TreeMap<Integer, River> riversMap;
		RiversDAO dao;
		River river;
		
		public Model() {
			
				dao = new RiversDAO();
				riversMap = new TreeMap<Integer, River>();
		 
		}
	
		public List<River> getAllRivers(){
			return dao.getAllRivers();
		}
		
		public Map<LocalDate, Flow> getAllFlowByRiver(River river){
			 return dao.getAllFlowByRiver(river);
		 }
		 
		 public  List<Flow> getAllFlow(){
			 return dao.getAllFlow();
		 }
		 
		 public  InfoRiver getAllInfo(River river) {
			 return dao.getAllInfo(river);
		 }
	}
