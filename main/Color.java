package main;

import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.utility.Delay;

public class Color {
	
	Wheel wheel1 = WheeledChassis.modelWheel(Motor.A, 81.6).offset(-70);
	Wheel wheel2 = WheeledChassis.modelWheel(Motor.B, 81.6).offset(70);
	Chassis chassis = new WheeledChassis(new Wheel[]{wheel1, wheel2},WheeledChassis.TYPE_DIFFERENTIAL);
	
	public static float [] couleur() {
		Port port = LocalEV3.get().getPort(Ports.COLOR_PORT);
		EV3ColorSensor sensor = new EV3ColorSensor(port);
		SampleProvider sp = sensor.getRGBMode();//0-7
		float [] sample =new float [sp.sampleSize()];
		sp.fetchSample(sample, 0);
		sensor.close();
		return sample;
	}
	public boolean isRed() {
		float[] f = couleur();
		if(f[0]*1000>200 && f[1]*1000<200 && f[2]*1000<200)
			return true;
		return false;
	}
	public boolean isGreen() {
		float[] f = couleur();
		if(f[0]*1000<200 && f[1]*1000>200 && f[2]*1000<200)
			return true;
		return false;
	}	
	public boolean isBlue() {
		float[] f = couleur();
		if(f[0]*1000<200 && f[1]*1000<200 && f[2]*1000>200)
			return true;
		return false;
	}
	public  boolean isYellow() {
		float[] f = couleur();
		if(f[0]*1000>120 && f[1]*1000>120 && f[2]*1000<100)
			return true;
		return false;
	}	
	public  boolean isWhite() {
		float[] f = couleur();
		if(f[0]*1000>160 && f[1]*1000>160 && f[2]*1000>160) {
			Delay.msDelay(50);
			return true;
		}
		return false;
	}
	public boolean isBlack() {
		float[] f = couleur();
		if(f[0]*1000<100 && f[1]*1000<100 && f[2]*1000<100)
			return true;
		return false;
	}

	public  void followWhiteLine() {
		boolean b = isWhite();
		while(isWhite()) {
			//moveForward();
			chassis.setLinearSpeed(Movement.speed-50);
			chassis.travel(1000);
			if(!isWhite()) {
				chassis.stop();
				Sound.beep();
				chercheWhite();
			}
		}
		Sound.twoBeeps();
	}
	public  boolean chercheWhite() {
		int i=10;
		boolean b = isWhite();
		while(!b) {
			chassis.rotate(i);
			chassis.waitComplete();
			if(b!=isWhite()) {
				Sound.beepSequence();
				return true;
			}
			i=2*i;
			chassis.rotate(-i);
			chassis.waitComplete();
			if(b!=isWhite()) {
				Sound.beepSequence();
				return true;
			}
			i=i/2;
			chassis.rotate(i);
			chassis.waitComplete();
			i++;
		}
		return false;
	}

}
