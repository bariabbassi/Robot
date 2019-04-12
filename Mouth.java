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

class public Mouth {

    public static void open() {
      Motor.C.forward();
      Motor.D.forward();
      Delay.msDelay(5000);
    }

    public static void close() {
      Motor.C.backward();
      Motor.D.backward();
      Delay.msDelay(5000);
    }
}
