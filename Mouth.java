import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Mouth {

    public static void open() {
      Motor.C.forward();
      Motor.D.forward();
      Delay.msDelay(5000);
    }

    public  static void close() {
      Motor.C.backward();
      Motor.D.backward();
      Delay.msDelay(5000);
    }
}
