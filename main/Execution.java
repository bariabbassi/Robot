package main;

public class Execution {
	
	public static void main(String[] args) {
		
		DriveBehaviour driveBehaviour = new DriveBehaviour();
		MouthAction mouthAction = new MouthAction();
		
		
		driveBehaviour.start();
		
		while(true) {
			int distanceToObject = driveBehaviour.DetectObject();
			mouthAction.release();
			driveBehaviour.goForward(distanceToObject);
			mouthAction.seize();
			driveBehaviour.goToBase();
			mouthAction.release();
			mouthAction.seize();
		}
		
		
	}	

}
