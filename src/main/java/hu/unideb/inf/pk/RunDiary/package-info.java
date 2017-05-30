package hu.unideb.inf.pk.RunDiary;



/** A csomagban a számoló osztályok találhatóak és a main metódus osztálya
  
  *A Calculator osztályban az átlagos sebességet és az elégetett kalóriákat számoló metódusok vannak 
  *A számításokat a megadott idő és sebesség függvényében végzik.
  *
  *public Calculator(double time, double distance) {
		super();
		this.time = time;
		this.distance = distance;
	}
  *
  *public double calculateAvrageSpeed() {
		double s = this.distance / 1000.0;
		double t = this.time / 60.0;

		return s / t;
	}
  *
  *
  *A Statisticss osztály a lefutott km-ekről készít nyilvántartást az adott hónapra évre és 
  *az aolkalmazás használata óta eltelt időre levetítve.
  *
  *
  *public String currentMonth() {
		Double counter = 0.0;
		for (RunEntity runEntity : runEntities) {
			if (runEntity.getDate().getMonth().equals(LocalDate.now().getMonth()) && runEntity.getDate().getYear() == (LocalDate.now().getYear())) {
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
  */