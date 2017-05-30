package hu.unideb.inf.pk.RunDiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Kalkulátor osztály az alkalmazáshoz.
 *
 */
public class Calculator {

	private double time;
	private double distance;
	
	/**
	 * paraméter nélküli konstruktor.
	 *
	 */
	public Calculator() {
		super();

	}

	/**
	 * konstruktor ami az időt és távot kapja meg.
	 * 
	 * @param time a futás ideje percben
	 * @param distance  a táv méterben
	 *
	 */
	public Calculator(double time, double distance) {
		super();
		this.time = time;
		this.distance = distance;
	}
	private static Logger	
	logger = LoggerFactory.getLogger(Calculator.class);

	/**
	 * Kiszámolja az átlagsebességet az idő és a táv alapján.
	 * 
	 * @return avrageSpeed átlagos sebesség
	 *
	 */
	public double calculateAvrageSpeed() {
		double s = this.distance / 1000.0;
		double t = this.time / 60.0;
		logger.info("avrage speed is" + s/t );
		return s / t;
	}

	/**
	 *Kiszámolja az elégetett kalóriákat.
	 * 
	 * @return burned calories
	 */
	public double calculateCalories() {

		if (this.calculateAvrageSpeed() < 8){
			logger.info("burned calories are" + this.time*10 + "as the avrage speed is"
					+ this.calculateAvrageSpeed() + "and the tim is " + this.time);
			return this.time * 10;
			
		}
		else if (this.calculateAvrageSpeed() < 18){

			logger.info("burned calories are" + this.time*15 + "as the avrage speed is"
					+ this.calculateAvrageSpeed() + "and the tim is " + this.time);
			return this.time * 15;
		}
		else{

			logger.info("burned calories are" + this.time*10 + "as the avrage speed is"
					+ this.calculateAvrageSpeed() + "and the tim is " + this.time);
			return this.time * 18;}
	}

	/**
	 * Publikus getter metódusa az időnek.
	 * 
	 * @return time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * publikus setter metódusa az időnek.
	 * 
	 * @param time a futás ideje
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * publikus getter metódusa a távnak.
	 * 
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * publikus setter metódusa a távnak.
	 * 
	 * @param distance a futás alatt megtett táv
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
