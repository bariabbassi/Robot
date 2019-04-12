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

public class Turn {

    public static void turn(int angle) {
      Motor.A.startSynchronization();
      //
      Motor.A.rotate(angle, true);
      Motor.B.rotate(-angle, true);
      Motor.A.waitComplete();
      //
    }
    public static void turnRight() {
      turn(200);
    }

    public static void turnLeft() {
      turn(-200);
    }

    public static void turn360Right() {
      turn(405);
    }

    public static void turn360Left() {
      turn(-405);
    }

    public static void smallTurnRight() {
      turn(50);
    }

    public static void smallTurnLeft() {
      turn(-50);
    }
}
