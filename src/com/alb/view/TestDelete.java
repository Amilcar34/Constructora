package com.alb.view;

import com.alb.controllers.ConstructionController;

public class TestDelete {

	public static void main(String[] args) {

		ConstructionController cc = new ConstructionController();
		cc.delete(4);
	}

}
