package tests;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import main.Detection;

public class DetectionTest {
	
	
	protected static Detection dt = new Detection();
	
	public static void main(String[] args) {
		
		int range;
        
        System.out.println("UltraSonic Demo");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();
        
        range = dt.distance();

        LCD.drawInt(range, 0, 0);

        // run until we find an obstacle within 1/4 of a meter.
        
        while (range > 25)
        {
            LCD.clear();
            LCD.drawInt(range, 0, 0);
            Delay.msDelay(500);
            range = dt.distance();
        }
        
        // free up resources.
        
        Sound.beepSequence();    // we are done.
        LCD.clear();
        LCD.drawInt(range, 0, 0);
        Button.waitForAnyPress();
           
    }

}
