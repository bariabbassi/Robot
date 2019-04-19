package main;

import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;

public class Movement {
	
	Wheel wheel1 = WheeledChassis.modelWheel(Motor.A, 81.6).offset(-70);
	Wheel wheel2 = WheeledChassis.modelWheel(Motor.B, 81.6).offset(70);
	Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2},WheeledChassis.TYPE_DIFFERENTIAL);
	
	protected int angle = 0; // Tour complet = 440 
	
	protected final static int speed = 150;
	
	public void updateAngle(int angle) {
		this.angle = angle;
		if( this.angle == 440) {
			this.angle = 0;
		}
	}
	
	public static void moveForward() {
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.forward();
		Motor.B.forward();
	}
	public void turnLeft() {
		chassis.rotate(115);
		chassis.waitComplete();
	}
	public void turnLeftSmall() {
		chassis.rotate(60);
		chassis.waitComplete();
	}
	public void turnRight() {
		chassis.rotate(-115);
		chassis.waitComplete();
	}
	public void turn180() {
		chassis.rotate(220);
		chassis.waitComplete();
	}
}
