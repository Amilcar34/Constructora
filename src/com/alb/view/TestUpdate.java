package com.alb.view;

import com.alb.controllers.ConstructionController;

public class TestUpdate {
	
	public static void main(String[] args) {
		
		ConstructionController cc = new ConstructionController();
		cc.update(1, "joni");
		
		cc.update(2, 98541);
	}

}
