package hu.unideb.inf.pk.RunDiary.database;

import java.util.List;

/**
 * Interfész az adatbézishozzáférési függvényeket deklarálja.
 */
public interface RunDAO {
	/**
	 * Új elem létrehozása az adatbázisba.
	 * 
	 * @param re amit elfog menteni
	 * @return RunEntity amit létrehoz 
	 */
	public RunEntity createEntry(RunEntity re);

	/**
	 * AZ összes elem lekérdezése az adatbázisból.
	 * 
	 * @return RunEntity lista amit kiolvas
	 */
	public List<RunEntity> readAllEntry();
	/**
	 * Egy elem kiolvasása az adatbázisból.
	 * @param id elemet olvas ki az adatbázisból id alapján
	 * @return RunEntity kiolvas
	 */
	public RunEntity ReadEntry(int id);
	
	/**
	 * Elem törlése az adatbázisból.
	 * @param re lefog törölni
	 * @return RunEntity amit le fog törölni
	 */
	public RunEntity removeEntry(RunEntity re);

}
