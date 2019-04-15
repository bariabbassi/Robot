import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
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
    
    public static void avancer(int distance) {
		Wheel wheel1 = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-72);
		Wheel wheel2 = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
		Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2},WheeledChassis.TYPE_DIFFERENTIAL); 
		MovePilot pilot = new MovePilot(chassis);
		pilot.travel(distance);
		//pilot.setLinearSpeed(30);  // cm per second
		//pilot.travel(50);         // cm
	}
	
}
