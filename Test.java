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

public class Test {

  public static mouth() {
    Mouth.open();
    Mouth.close();
  }

	public static void move() {
		Boolean objectTouched = false;
		Boolean objectFound = false;

		openMouth();
		while(!objectTouched) {
			moveForward();
			objectTouched = isTouched();
			if(detect()) {
				detected=true;
				moveForward();
				Delay.msDelay(1000);
			}
		}
		closeMouth();
	}

  public static void main(String[] args) {
      Test.mouth();
  }
}
