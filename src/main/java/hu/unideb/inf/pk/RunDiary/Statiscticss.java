package hu.unideb.inf.pk.RunDiary;

import java.time.LocalDate;
import java.util.List;

import hu.unideb.inf.pk.RunDiary.database.RunEntity;

public class Statiscticss {

	private List<RunEntity> runEntities;

	public Statiscticss(List<RunEntity> runEntities) {
		super();
		this.runEntities = runEntities;
	}

	public String currentMonth() {
		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			if (runEntity.getDate().getMonth().equals(LocalDate.now().getMonth())) {
				counter += runEntity.getDistance();

			}
		}
		counter /= 1000.0;
		return counter.toString();
	}

	public String currentYear() {
		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			if (runEntity.getDate().getYear() == LocalDate.now().getYear()) {
				counter += runEntity.getDistance();

			}
		}
		counter /= 1000.0;
		return counter.toString();
	}

	public String summ() {

		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			counter += runEntity.getDistance();
		}

		counter /= 1000.0;
		return (counter).toString();
	}

}
