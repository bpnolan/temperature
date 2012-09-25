// BRIAN NOLAN
//260309346
//ECSE 321
//ASSIGNMENT 1

package package5;

public class Temperature implements Comparable<Temperature> {
	
	
/** Enumerator for different temperature units */
public enum Units { FAHRENHEIT, CELCIUS, KELVIN }

public double Value;
public double CelciusValue;
Units units;
Units tempunits;
String tempstring;

public Temperature (double value, Temperature.Units units) {
	
	Value = value;
	this.units = units;
	
	}

public double getValue() {
	
	return Value;
}

public Units getUnits() {
	
	return units;
}


public void changeUnits(Units units) {
	
	switch (this.units) {					//Change to default value (Celcius)
	case FAHRENHEIT:
		CelciusValue = (Value - 32)*5/9;
		break;
	case CELCIUS:
		CelciusValue = Value;
		break;
	case KELVIN:
		CelciusValue = Value - 273.15;
		break;
	
	}
	
	switch(units) {							// then change to requested units
	case FAHRENHEIT:
		Value = CelciusValue*9/5+32;
		break;
	case CELCIUS:
		Value = CelciusValue;
		break;
	case KELVIN:
		Value = CelciusValue +273.15;
		break;
	
	}
	
	this.units = units;
	
}

public String toString() {
	
	
	
	switch (this.units) {					//prints string depending on units
	case FAHRENHEIT:
		tempstring= Value + " °F";
		break;
	case CELCIUS:
		tempstring = Value + " °C";
		break;
	case KELVIN:
		tempstring= Value + " K";
		break;
	}
	
	return tempstring;
	
}

public int compareTo (Temperature temperature) {
	
	tempunits = this.getUnits();						//save current units
	this.changeUnits(temperature.getUnits());			//switch to units of parameter
	
	if(Value-temperature.getValue()< -0.000001) {		//and compare
		
		this.changeUnits(tempunits);					//return to original units before returning
		return -1;
		
	}
	else if(this.equals(temperature)) {
		
		this.changeUnits(tempunits);
		return 0;
		
	}
	else {
		this.changeUnits(tempunits);
		return 1;
		
	}
	
	
	
	
}

public boolean equals (Object o) {
	
	if(o==null) {
		return false;		
	}
	
	Temperature t = (Temperature) o;
	tempunits = this.getUnits();					
	
	this.changeUnits(t.getUnits());				//save current units
	
	if(Math.abs(Value-t.getValue())< 0.000001) {		//if difference is within certain tolerance
		this.changeUnits(tempunits);					//return to original units
		return true;									//and return true
		
	}
	else {
		this.changeUnits(tempunits);					//else return to original units
		return false;									//and return false
		
	}

}

public int hashCode() {
	
	tempunits = this.units;					//save current units
	this.changeUnits(Units.CELCIUS);		//change to default units (Celcius)
	int hash = 7;
	hash = 13*hash+ (int)Value;				//implement hash function
	this.changeUnits(tempunits);			//return to original units
	return hash;
	
	}
}

/**
* Create a new {@code Temperature} with given attributes
* @param value numerical value of {@code Temperature}
* @param units {@code Units} of {@code Temperature}
* 
*/


