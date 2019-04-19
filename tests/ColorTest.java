package tests;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import main.Color;

public class ColorTest {
	
	static Color cl = new Color();
	
	
	
	public static void main(String[] args) {
		boolean color = false;
        
        System.out.println("UltraSonic Demo");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();
        
        
        LCD.drawString("false", 0, 0);
        
        // run until we find white color 
        
        while (!color)
        {
            LCD.clear();
            LCD.drawString("false", 0, 0);
            Delay.msDelay(500);
            color = cl.isWhite();
        }
        
        // free up resources.
        
        Sound.beepSequence();    // we are done.
        LCD.clear();
        LCD.drawString("Done", 0, 0);
        Button.waitForAnyPress();
	}

}
