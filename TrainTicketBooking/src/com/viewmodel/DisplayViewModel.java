package com.viewmodel;

import com.model.Repository;
import com.view.MainView;

public class DisplayViewModel {
	MainView mv;
	
	public DisplayViewModel(MainView mv) {
		this.mv=mv;
	}
	
	public void displayChart() {
		char[][] chart=Repository.getInstance().chart;
		
		for(char[] ca:chart) {
			for(char c:ca) {
				mv.print(c+" ");
			}
			mv.printMessage("");
		}
	}

}
