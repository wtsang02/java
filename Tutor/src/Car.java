	// car's lot 
	 //*  number, model, product year, the purchase value and
	 //*  the current value.
public class Car {
	//instance fields   
private int lotNumber;
private String model;
private int productYear;
private double purchaseValue;
private double currentValue;
	
public Car(){
	lotNumber=0;
	model="unknown";
	productYear=0;
	purchaseValue=0;
	currentValue=0;
	}

//Returns current value based on the year.
public double getCurrentValue(int currentYear) {
	currentValue=purchaseValue;
	int yearDiff=currentYear-productYear;
	while(yearDiff!=0){
		currentValue=currentValue-currentValue*0.1;
	yearDiff--;
	}
	return currentValue;
}
//Prints out the infomation about this car.
public void print(int currentYear){
	System.out.println(
		"Model: "+getModel()+"\n"
		+"Lot Number: "+getLotNumber()+"\n"
		+"Product Year: "+getProductYear()+"\n"
		+"purchase Value: "+getPurchaseValue()+"\n"
		+"current Value: "+getCurrentValue(currentYear)
		+"\n\n"
			);
	
}


//Getters and setters
public int getLotNumber() {
	return lotNumber;
}

public void setLotNumber(int lotNumber) {
	this.lotNumber = lotNumber;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getProductYear() {
	return productYear;
}

public void setProductYear(int productYear) {
	this.productYear = productYear;
}

public double getPurchaseValue() {
	return purchaseValue;
}

public void setPurchaseValue(double purchaseValue) {
	this.purchaseValue = purchaseValue;
}

public double getCurrentValue() {
	return currentValue;
}

public void setCurrentValue(double currentValue) {
	this.currentValue = currentValue;
}


	
	
}
