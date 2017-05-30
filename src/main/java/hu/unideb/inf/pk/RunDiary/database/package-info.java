package hu.unideb.inf.pk.RunDiary.database;

import javax.persistence.Persistence;

/**
 * Ez a csomag tartalamazza az adatbézishozzáférést elősegítő osztályokat. A
 * RunENtity definiálja az adatbázis szerkezetét, amely 1 táblábólés a következő
 * mezőkből áll:
 * 
 * @Id
 * @GeneratedValue(strategy = GenerationType.SEQUENCE)
 * @Column(name="ID") private int id;
 * @Column(name="DATE") private LocalDate date;
 * @Column(name="DISTANCE") private int distance;
 * @Column(name="TIME") private int time;
 * @Column(name="AVRAGESPEED") private double averageSpeed;
 * @Column(name="BURNEDCALORIES") private double burnedCalories;
 * 
 * 
 *  A RunDAO egy interfészen keresztül biztosítja
 *  a grafikus kezelőfelület valamint a
 *  számításokat végző és statisztikákat számító
 *  osztályoknak az egyzserű hozzáférést az adatbázishoz.
 *  
 *  A RunDAOImpl osztály implementálja a a RunDAO ban deklarált metóduskat.
 *  
 *  A RundaoFactory sagítségével lehet példányosítani a RunDAO -t 
 *  
 *  static{
		instance = new RunDAOFactory();
		f=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = f.createEntityManager();
		
	}
 */