package hu.unideb.inf.pk.RunDiary;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hu.unideb.inf.pk.RunDiary.database.RunEntity;

public class StatisticsTest {
	
	@Test
	public void statisticsTest(){
		RunEntity a = new RunEntity(LocalDate.of(2017, 05, 27),4000,10,10,10); 
		RunEntity b = new RunEntity(LocalDate.of(2017, 04, 27),4000,10,10,10); 
		RunEntity c =new RunEntity(LocalDate.of(2016, 05, 27),4000,10,10,10); 
		List<RunEntity> list = new ArrayList<RunEntity>();
		list.add(a);
		list.add(b);
		list.add(c);
		Statiscticss stat = new Statiscticss(list);
		
		assertEquals("Az aktuális hónapban 4 km futás törtönt",4.0,Double.parseDouble(stat.currentMonth()),0.0);
		assertEquals("Az aktuális évben 8 km futás törtönt",8.0,Double.parseDouble(stat.currentYear()),0.0);
		assertEquals("Összesen 12 km futás történt",12.0,Double.parseDouble(stat.summ()),0.0);
		
		
	}

}
