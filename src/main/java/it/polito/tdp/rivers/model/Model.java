package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.db.RiversDAO;

	
	public class Model {
		
		RiversDAO dao;
		River river;
		
		List<Flow> flows ;
		public Model() {
			
				dao = new RiversDAO();
				flows = new LinkedList<Flow>();
				
		 
		}
	
		public List<River> getAllRivers(){
			return dao.getAllRivers();
		}
		
		public List<Flow> getAllFlowByRiver(River river){
			 return dao.getAllFlowsByRiver(river);
		 }
		 
		 public  List<Flow> getAllFlow(){
			 return dao.getAllFlow();
		 }
		 
		 public  InfoRiver getAllInfo(River river) {
			 return dao.getAllInfo(river);
		 }
		 
		 public SimulationResult Simula(River r,int k) {
			
			 flows = getAllFlowByRiver(r);
			 double Q = k*(r.getFlowAvg()*60*60*24)*30 ;
			 double C = Q/2;
			 
			 PriorityQueue<Flow> queue = new PriorityQueue<Flow>();
			 
			 
			 return ;
		}
	}
	

