package com.wtsang.java.swing.application.model;

public enum CustomerState {
	NONE(0),BRONZE(1),SILVER(2),GOLD(3);
	
	private int state;
	private CustomerState(int i){
		this.state=i;
	}
	
	public static CustomerState findByNumber(int i){
		for(CustomerState state:CustomerState.values()){
			if(state.state==i){
				return state;
			}
		}
		return CustomerState.NONE;
			
	}
		
}
