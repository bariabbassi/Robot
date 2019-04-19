package main;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;


public class DriveBehaviour {
	
	Detection detection = new Detection();
	MouthAction mouthAction = new MouthAction();
	Movement movement = new Movement();
	Color color = new Color();
	
	
	Wheel wheel1 = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-72);
	Wheel wheel2 = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
	Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2},WheeledChassis.TYPE_DIFFERENTIAL);
	
	public void start() {
		mouthAction.release();
		goForward(500);
		mouthAction.seize();
		movement.turnLeft();
		movement.updateAngle(115);
		goToBase();
		mouthAction.release();
	}
	
	public void rotation(int degrees) {
		
		Port port = LocalEV3.get().getPort(Ports.GYRO_PORT);
		EV3GyroSensor gyro = new EV3GyroSensor(port);
		// start rotation around current location.
        Motor.A.setSpeed(-50);
        Motor.B.setSpeed(50);
        // wait for x degrees of rotation
        SampleProvider angleProvider = gyro.getAngleMode();
        float[] tab;
		tab = new float[angleProvider.sampleSize()];
		int angle = 0;
        while ( angle < degrees )
        {
        	angleProvider.fetchSample(tab, 0);
        	angle = (int)tab[0];
            Delay.msDelay(50);
        }
        // free up resources.
        gyro.close();
        Motor.A.close();
        Motor.B.close();
	}
	
	public  void goForward(int distance) {
		MovePilot pilot = new MovePilot(chassis);
		pilot.travel(distance);
	}
	public void goToBase() {
		chassis.rotate(movement.angle-220);
		boolean isWhite = color.isWhite();
		while(!isWhite) {
			Motor.A.forward();
			Motor.B.forward();
			isWhite = color.isWhite();
		}
		Motor.A.stop();
		Motor.B.stop();
		 // free up resources.
        Motor.A.close();
        Motor.B.close();
	}

	// make n rotation to detect the closest object 
	public int DetectObject() {
		int[] distances = new int[5];
		for(int i = 0 ; i <  5 ; i++ ) {
			distances[i] = detection.distance();
			chassis.rotate(60);
			chassis.waitComplete();
		}
		int min = distances[0];
		for( int i = 0 ; i < 4 ; i++) {
			if( distances[i] < min ) {
				min = distances[i];
			}
		}
		return min;
	}

}
