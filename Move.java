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

public class Move {

    public static void stop() {
      Motor.B.stop();
      Motor.A.stop();
    }

    public static void forward() {
      Motor.A.startSynchronization();
      Motor.B.startSynchronization();
      Motor.A.forward();
      Motor.B.forward();
      Motor.A.waitComplete();
      Motor.B.waitComplete();
    }

    public static void backward() {
      Motor.A.backward();
      Motor.B.backward();
    }

    //rotate ??
    public static void goandstop(int time) {
      Motor.A.forward();
      Motor.B.forward();
      Delay.msDelay(time);
      Motor.A.stop();
      Motor.B.stop();
    }
}
