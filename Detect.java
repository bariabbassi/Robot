import java.awt.List;
import java.util.ArrayList;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

class public Detect {

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

}
