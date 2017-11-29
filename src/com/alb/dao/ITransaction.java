package com.alb.dao;

import java.util.List;
import com.alb.entities.Construction;

public interface ITransaction extends IConnonection{

	List<Construction> read();	
	
	boolean create(String name, int dni);
	
	boolean update(int id, String name);
	boolean update(int id, int dni);
	
	boolean delete(int id);
	
	
}
