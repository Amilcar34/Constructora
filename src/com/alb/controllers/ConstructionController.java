package com.alb.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.alb.dao.IConnonection;
import com.alb.dao.ITransaction;
import com.alb.entities.Construction;

public final class ConstructionController implements ITransaction {

	@Override
	public List<Construction> read() {
		int id = 0;
		String name = null;
		int dni = 0;
		
		List<Construction> listOfConstruBuilders = new LinkedList<Construction>();
		
		
		try{
			IConnonection ic = new IConnonection() {};

			Connection c = ic.connection();

			if(c != null){
				Statement st =c.createStatement();
				String sql = "SELECT * FROM constructores";
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()){
					id = rs.getInt("id");
					name = rs.getString("name");
					dni = rs.getInt("dni");
					listOfConstruBuilders.add(new Construction(name, dni));
				}
				
				for (Construction construction : listOfConstruBuilders) {
					System.out.println(construction.getName() + " " + construction.getDni());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error al intentar mostrar Constructores");
		}
		return listOfConstruBuilders;
	}

	@Override
	public boolean create(String name, int dni) {
		boolean c = false;
		IConnonection con = new IConnonection() {};
		
		try {
			Connection co = con.connection();
			
			if(co != null){
				String sql = "INSERT INTO constructores(name, dni) VALUES(?,?)";
				PreparedStatement ps = co.prepareStatement(sql);;
				ps.setString(1, name);
				ps.setInt(2, dni);
				ps.execute();
				ps.close();
			}else{
				System.out.println("Appears to be NULL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return c;
	}

	@Override
	public boolean update(int id, String name) {
		boolean u = false;
		
		IConnonection ic = new IConnonection() {};
		
		try {
			Connection co = ic.connection();
			
			if(co != null){
				PreparedStatement ps = null;
				String sql = "UPDATE constructores SET name=? WHERE id=?";
				ps = co.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
				u = true;
			}else{
				System.out.println("bad charge update");
				u = false;
			}
			
			
		} catch (Exception e) {
			System.out.println("Bad connnection UPDATE NAME");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		return u;
	}

	@Override
	public boolean update(int id, int dni) {
		boolean u = false;
		
		IConnonection ic = new IConnonection() {}; 
		try{
			Connection conne = ic.connection();
			
			if(conne != null){
				PreparedStatement ps = null;
				String sql = "UPDATE constructores SET dni=? WHERE id=?";
				ps = conne.prepareStatement(sql);
				ps.setInt(1, dni);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
				
			}else{
				System.err.println("bad connection UPDATE DNI");
				u = false;
			}
		}catch (Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return u;

	}

	@Override
	public boolean delete(int id) {

		boolean d = false;
		IConnonection c = new IConnonection() {};
		
		try{
			Connection con = c.connection();
			
			if(con != null){
				PreparedStatement ps = null;
				String sql = "DELETE FROM constructores WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				ps.close();				
			}else{
				System.err.println("bad connection of DELETE");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return d;
	}
	
	

}
