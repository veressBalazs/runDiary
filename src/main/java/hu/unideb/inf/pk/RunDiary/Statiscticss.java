package hu.unideb.inf.pk.RunDiary;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.pk.RunDiary.database.RunEntity;

/**
 * Statisztikakészítő osztály az applikációhoz
 *
 */

public class Statiscticss {

	private List<RunEntity> runEntities;
	private static Logger	
	logger = LoggerFactory.getLogger(Statiscticss.class);


	/**
	 * Konstruktor.
	 * 
	 * @param runEntities
	 *            Egy RunEntityes listát kap meg amiből kiszámolja az adott
	 *            hónapban , évben és összesen megtett távot.
	 *
	 */
	public Statiscticss(List<RunEntity> runEntities) {
		super();
		this.runEntities = runEntities;
	}

	/**
	 * Az adott hónapban megtett távot számolja.
	 * 
	 * @return Sztringé alakított formában adja vissza az adott hónapban megtett
	 *         kilóméterekek számát
	 *
	 */
	public String currentMonth() {
		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			if (runEntity.getDate().getMonth().equals(LocalDate.now().getMonth())
					&& runEntity.getDate().getYear() == (LocalDate.now().getYear())) {
				counter += runEntity.getDistance();

			}
		}
		counter /= 1000.0;
		logger.info("Distance in this month is" + counter);
		return counter.toString();
	}
	/**
	 * Az adott évben megtett távot számolja.
	 * 
	 * @return Sztringé alakított formában adja vissza az adott évben megtett
	 *         kilóméterekek számát
	 *
	 */
	public String currentYear() {
		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			if (runEntity.getDate().getYear() == LocalDate.now().getYear()) {
				counter += runEntity.getDistance();

			}
		}
		counter /= 1000.0;
		logger.info("Distance in this year is" + counter);
		return counter.toString();
	}
	/**
	 * Az összes megtett távot számolja.
	 * 
	 * @return Sztringé alakított formában adja vissza az összes megtett
	 *         távot
	 *
	 */
	public String summ() {

		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			counter += runEntity.getDistance();
		}

		counter /= 1000.0;
		logger.info("All distance runned" + counter);
		return (counter).toString();
	}

}
