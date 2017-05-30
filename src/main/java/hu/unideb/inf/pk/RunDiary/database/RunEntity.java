package hu.unideb.inf.pk.RunDiary.database;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entitás osztály.
 *
 */
@Entity
@Table(name = "RUNENTITY")
public class RunEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	@Column(name="DATE")
	private LocalDate date;
	@Column(name="DISTANCE")
	private int distance;
	@Column(name="TIME")
	private int time;
	@Column(name="AVRAGESPEED")
	private double averageSpeed;
	@Column(name="BURNEDCALORIES")
	private double burnedCalories;
	
	
	/**
	 * Paraméter nélküli konstruktor
	 *
	 */
	public RunEntity() {

	}
	/**
	 * Konstruktor.
	 * @param date a futás dátuma
	 * @param distance a futás során megtett táv
	 * @param time a futás időtartama
	 * @param averageSpeed az átlagos sebesség a futás salatt
	 * @param burnedCalories az elégetett kalóriák a futás során
	 *
	 */
	public RunEntity(LocalDate date, int distance, int time, double averageSpeed, double burnedCalories) {
		super();
		this.date = date;
		this.distance = distance;
		this.time = time;
		this.averageSpeed = averageSpeed;
		this.burnedCalories = burnedCalories;
	}
	
	/**
	 * Az id mező pulikus getter metódusa.
	 *@return id 
	 */
	public int getId() {
		return id;
	}
	/**
	 * Az id mező pulikus setter metódusa.
	 *@param id a futás azonosítója (autómatikusan generált)
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Az date mező pulikus getter metódusa.
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * Az date mező pulikus setter metódusa.
	 *@param date a futás dátuma
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * Az distance mező pulikus getter metódusa.
	 *@return distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * Az distance mező pulikus setter metódusa.
	 *@param distance a lefutott táv
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * Az time mező pulikus getter metódusa.
	 *@return time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * Az time mező pulikus setter metódusa.
	 *@param time a futás időtartama
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * Az avrageSpeed mező pulikus getter metódusa.
	 *@return avrageSpeed
	 */
	public double getAverageSpeed() {
		return averageSpeed;
	}
	/**
	 * Az averageSpeed mező pulikus setter metódusa.
	 *@param averageSpeed az átlagos sebesség a futás alatt
	 */
	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	/**
	 * Az BurnedCalories mező pulikus getter metódusa.
	 *@return BurnedCalories
	 */
	public double getBurnedCalories() {
		return burnedCalories;
	}
	/**
	 * Az burnedCalories mező pulikus setter metódusa.
	 *@param burnedCalories elégetett kalóriák a futás alatt
	 */
	public void setBurnedCalories(double burnedCalories) {
		this.burnedCalories = burnedCalories;
	}
	/**
	 * toString metódus a RunEntity-hez.
	 *@return sztring a run entity minden mezőjét kiírja
	 */
	@Override
	public String toString() {
		return "RunEntity [id=" + id + ", date=" + date + ", distance=" + distance + ", time=" + time
				+ ", averageSpeed=" + averageSpeed + ", burnedCalories=" + burnedCalories + "]";
	}

}
