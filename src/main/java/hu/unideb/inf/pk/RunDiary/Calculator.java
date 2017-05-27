package hu.unideb.inf.pk.RunDiary;

public class Calculator {

	private double time;
	private double distance;

	public Calculator() {
		super();
		
	}

	public Calculator(double time, double distance) {
		super();
		this.time = time;
		this.distance = distance;
	}
	
	
	public double calculateAvrageSpeed(){
		double s= this.distance/1000.0;
		double t = this.time/60.0;
		
		return s/t;
	}
	
	public double calculateCalories(){
		
		if (this.calculateAvrageSpeed() < 8) return this.time*10;
		else if(this.calculateAvrageSpeed() < 18) return this.time*15;
		else return this.time*18;
	}
	
	
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
