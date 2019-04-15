public class Robot {

	public static void main(String[] args) {
		/*
		Boolean objectTouched = false;
		Boolean objectFound = false;

		openMouth();
		while(!objectTouched) {
			moveForward();
			objectTouched = isTouched();
			if(detect()) {
				detected=true;
				moveForward();
				Delay.msDelay(1000);
			}
		}
		closeMouth();
		*/
		Move newMove = new Move();
		newMove.avancer(50);
	}
	
}
