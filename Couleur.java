import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Couleur {
	public Couleur() {
		
	}
	
	
	
	/**Retourne le numero de la couleur detectée entre 0 et 7 pour les couleurs suivantes:
	 *  0 = red;1 = green;2 = blue;3 = yellow;4 = magenta;5 = orange;6 = white;7 = black
     *  8 = pink;9 = gray;10 = light gray;11 = dark gray;12 = cyan
     *  */
	public static float [] couleur() {
		EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S2);
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
	}	public boolean isBlue() {
		float[] f = couleur();
		if(f[0]*1000<200 && f[1]*1000<200 && f[2]*1000>200)
			return true;
		return false;
	}
	public boolean isYellow() {
		float[] f = couleur();
		if(f[0]*1000>200 && f[1]*1000>200 && f[2]*1000<200)
			return true;
		return false;
	}	
	public static boolean isWhite() {
		float[] f = couleur();
		if(f[0]*1000>200 && f[1]*1000>200 && f[2]*1000>180)
			return true;
		return false;
	}
	public boolean isBlack() {
		float[] f = couleur();
		if(f[0]*1000<100 && f[1]*1000<100 && f[2]*1000<100)
			return true;
		return false;
	}
	public static void main(String[] args) {

		//Verifier que le blanc et le gris ne se confondent pas dans isWhite()!
	}
	
}
