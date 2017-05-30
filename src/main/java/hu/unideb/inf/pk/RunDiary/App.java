package hu.unideb.inf.pk.RunDiary;

import java.util.List;

import hu.unideb.inf.pk.RunDiary.database.RunDAO;
import hu.unideb.inf.pk.RunDiary.database.RunDAOFactory;
import hu.unideb.inf.pk.RunDiary.database.RunEntity;
import hu.unideb.inf.pk.RunDiary.ui.AppStarter;
import javafx.application.Application;

/**
 * Main Class.
 *
 */
public class App {
	/**
	 * Main metódus a RunApp hez.
	 * 
	 * @param args parancssori argumentumok
	 *
	 */
	public static void main(final String[] args) {

		RunDAOFactory daofactory;
		daofactory = RunDAOFactory.getInstance();
		RunDAO rDao = daofactory.createRunDAO();
		List<RunEntity> l = rDao.readAllEntry();

		for (RunEntity runEntity : l) {
			System.out.println(runEntity);
		}
		Application.launch(AppStarter.class, args);
	}
}
