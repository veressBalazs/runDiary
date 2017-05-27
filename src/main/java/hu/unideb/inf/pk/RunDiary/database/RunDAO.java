package hu.unideb.inf.pk.RunDiary.database;

import java.util.List;

public interface RunDAO {
	
	public RunEntity createEntry(RunEntity re);
	
	public List<RunEntity> readAllEntry();
	
	public RunEntity ReadEntry(int id);
	
	public RunEntity removeEntry(RunEntity re);

}
