package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.InfoRiver;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
	public List<Flow> getAllFlowsByRiver(River river) {
		
		final String sql = "SELECT *\n" + 
				"FROM flow AS f\n" + 
				"WHERE f.river = ?";

		List<Flow> flowsbyRiver = new LinkedList<Flow>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Flow f = new Flow(res.getDate(1).toLocalDate(),res.getFloat(2),river);
				river.getFlows().add(f);
				flowsbyRiver.add(f);
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return flowsbyRiver;
	}
	public  List<Flow> getAllFlow() {
			
			final String sql = "SELECT *\n" + 
					"FROM flow AS f, river\n" + 
					"WHERE f.river = river.id\n" + 
					"";

			List<Flow> flows = new LinkedList<Flow>();

			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet res = st.executeQuery();

				while (res.next()) {
					River r =new River(res.getInt("id"), res.getString("name"));
					flows.add(new Flow(res.getDate(1).toLocalDate(),res.getDouble(2),r));
				}

				conn.close();
				
			} catch (SQLException e) {
				//e.printStackTrace();
				throw new RuntimeException("SQL Error");
			}

			return flows;
		}
	
	public  InfoRiver getAllInfo(River river) {
		
		final String sql = "SELECT AVG(f.flow), MIN(f.day), MAX(f.day), COUNT(f.flow)\n" + 
				"FROM flow AS f\n" + 
				"WHERE f.river = ?";

		InfoRiver infoRiver ;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
			ResultSet res = st.executeQuery();
			
			res.next();
			
			infoRiver = new InfoRiver(res.getDouble(1), res.getDate(2).toLocalDate(), res.getDate(3).toLocalDate(),res.getInt(4));

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return infoRiver;
	}
	
	
}
