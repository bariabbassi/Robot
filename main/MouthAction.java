package main;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class MouthAction {
	
	protected boolean isOpen = false; // au depart c'est fermé 
	
	 public void seize() {
	     if( this.isOpen == true) {
	    	 Motor.C.backward();
		     Motor.D.backward();
		     Delay.msDelay(5000);
		     this.isOpen = false;
	     }
	 }

	 public void release() {
	     if (this.isOpen == false) {
	    	 Motor.C.forward();
		     Motor.D.forward();
		     Delay.msDelay(5000);
		     this.isOpen = true;
	     }
	 }

}
