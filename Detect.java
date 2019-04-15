import java.awt.List;
import java.util.ArrayList;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class  Detect {

  public static int isTouched() {
		Port p = LocalEV3.get().getPort("S4");
		EV3TouchSensor t = new EV3TouchSensor(p);
		SampleProvider touchProvider = t.getTouchMode();
		float[] tab;
		tab = new float[touchProvider.sampleSize()];
		touchProvider.fetchSample(tab, 0);
		t.close();
		return (int) tab[0];
	}
  	
  	public static int distance() {
		// get a port instance
		Port port = LocalEV3.get().getPort("S2");

		// Get an instance of the Ultrasonic EV3 sensor
		SensorModes sensor = new EV3UltrasonicSensor(port);

		// get an instance of this sensor in measurement mode
		SampleProvider distance= sensor.getMode("Distance");

		// initialize an array of floats for fetching samples.
		// Ask the SampleProvider how long the array should be
		float[] sample = new float[distance.sampleSize()];

		// fetch a sample
		distance.fetchSample(sample, 0);
		
		return (int)sample[0];
	}
}
