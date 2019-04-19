package main;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Detection {
	
	
	public int isTouched() {
		Port p = LocalEV3.get().getPort(Ports.TOUCH_PORT);
		EV3TouchSensor t = new EV3TouchSensor(p);
		SampleProvider touchProvider = t.getTouchMode();
		float[] tab;
		tab = new float[touchProvider.sampleSize()];
		touchProvider.fetchSample(tab, 0);
		t.close();
		return (int) tab[0];
	}
  	
  	public int distance() {
		Port port = LocalEV3.get().getPort(Ports.SENSOR_PORT);
		EV3UltrasonicSensor t = new EV3UltrasonicSensor(port);
		SampleProvider distanceProvider = t.getDistanceMode();
		float[] tab;
		tab = new float[distanceProvider.sampleSize()];
		distanceProvider.fetchSample(tab, 0);
		t.close();
		return (int)tab[0];
		
	}
  	
  	/**
  	 * Retourne le numero de la couleur detectée entre 0 et 7 pour les couleurs suivantes:
	 *  NONE, BLACK, BLUE, GREEN, YELLOW, RED, WHITE, BROWN
	 *  
	 *  
	 **/
	public float color() {
		Port port = LocalEV3.get().getPort(Ports.COLOR_PORT);
		EV3ColorSensor sensor = new EV3ColorSensor(port);
		SampleProvider sp = sensor.getColorIDMode();//0-7
		float [] sample =new float [sp.sampleSize()];
		sp.fetchSample(sample, 0);
		System.out.println(sample[0]);
		Delay.msDelay(5000);
		sensor.close();
		return sample[0];
	}

}
