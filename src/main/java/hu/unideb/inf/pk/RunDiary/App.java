package hu.unideb.inf.pk.RunDiary;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import hu.unideb.inf.pk.RunDiary.database.RunDAO;
import hu.unideb.inf.pk.RunDiary.database.RunDAOFactory;
import hu.unideb.inf.pk.RunDiary.database.RunEntity;
import hu.unideb.inf.pk.RunDiary.ui.AppStarter;
import javafx.application.Application;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	RunDAOFactory daofactory;
    	daofactory = RunDAOFactory.getInstance();
    	RunDAO rDao = daofactory.createRunDAO();
    	
    	//RunEntity r1 = new RunEntity(LocalDate.now(), 2500	, 20, 17d, 45); 
    
    	//rDao.createEntry(r1);
    	
    	List<RunEntity> l = rDao.readAllEntry();
    	
    	for (RunEntity runEntity : l) {
			System.out.println(runEntity);
		}
    	
    	
    	
    	Application.launch(AppStarter.class,args);
    	
    	
    }
}
