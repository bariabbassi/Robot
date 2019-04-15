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

		Mouth.open();
		while(!objectTouched) {
			Move.forward();
			objectTouched = Detect.isTouched();
			if(Detect.distance()<40) {
				detected=true;
				Move.forward();
				Delay.msDelay(1000);
			}
		}
		Mouth.close();
	}

  public static void main(String[] args) {
      Test.mouth();
  }
}
