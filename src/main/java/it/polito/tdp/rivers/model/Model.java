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
		

		PriorityQueue<Flow> queue ;
		public Model() {
			
				dao = new RiversDAO();
				
				
		 
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
			
			 SimulationResult sResult;
			 
			 queue = new PriorityQueue<Flow>();
			 queue.addAll(river.getFlows());
			 
			 double Q = k*(r.getFlowAvg()*60*60*24)*30 ;
			 double C = Q/2;
			 double fOutMin = 0.8 * r.getFlowAvg()*60*60*24;
			 
			 PriorityQueue<Flow> queue = new PriorityQueue<Flow>();
			 
			 List<Double> capacity = new LinkedList<Double>();
			 int numday = 0;
			 
			 while(!this.queue.isEmpty()) {
				 
				 Flow flow = queue.poll();
				 
				 if(flow.getFlow()>fOutMin){
					 
					 C += flow.getFlow()-fOutMin;
					 
				 }
				 
				 
				 
				 
				 
			 }
			 
			 return sResult;
		}
	}
	

