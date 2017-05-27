package hu.unideb.inf.pk.RunDiary.database;

import java.time.Duration;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RunEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private LocalDate date;

	private int distance;

	private int time;

	private double averageSpeed;

	private double burnedCalories;

	public RunEntity() {

	}

	public RunEntity(LocalDate date, int distance, int time, double averageSpeed, double burnedCalories) {
		super();
		this.date = date;
		this.distance = distance;
		this.time = time;
		this.averageSpeed = averageSpeed;
		this.burnedCalories = burnedCalories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public double getBurnedCalories() {
		return burnedCalories;
	}

	public void setBurnedCalories(double burnedCalories) {
		this.burnedCalories = burnedCalories;
	}

	@Override
	public String toString() {
		return "RunEntity [id=" + id + ", date=" + date + ", distance=" + distance + ", time=" + time
				+ ", averageSpeed=" + averageSpeed + ", burnedCalories=" + burnedCalories + "]";
	}

}
