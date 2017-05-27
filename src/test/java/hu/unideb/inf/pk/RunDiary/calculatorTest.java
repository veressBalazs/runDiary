package hu.unideb.inf.pk.RunDiary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc;
	
@Test
public void speedCalculatorTest(){
	
	calc = new Calculator(60, 1000);
	assertEquals("60 perc alatt 1000 m az 1 km/h-s sebesseg" ,1,calc.calculateAvrageSpeed(),0);
	
	calc.setTime(10);
	assertEquals("10 perc alatt 1000 m az 6 km/h-s sebesseg" ,6,calc.calculateAvrageSpeed(),0);

}

@Test
public void caloriesCalculatorTest(){
	calc = new Calculator();
	calc.setTime(30);
	calc.setDistance(1000);
	
	assertEquals("1 km futás 30 perc alatt 300 kaória elégetését eredményezi" ,300,calc.calculateCalories(),2.0);
	
	calc.setDistance(6000);
	assertEquals("6 km futás 30 perc alatt 450 kaória elégetését eredményezi" ,450,calc.calculateCalories(),2.0);

	
	calc.setDistance(9500);
	assertEquals("9,5 km futás 30 perc alatt 540 kaória elégetését eredményezi" ,540,calc.calculateCalories(),2.0);

	
}

}
