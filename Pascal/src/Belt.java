import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.subsumption.Behavior;

// Behavior for belt

public class Belt implements Behavior {
	
	private EV3LargeRegulatedMotor belt; 
	
	Belt(EV3LargeRegulatedMotor belt) {
		this.belt = belt; 
	}
	
	public void action() throws NullPointerException {
		belt.forward();
	}
	
	public void suppress() {}
		
	public boolean takeControl() {
		return true; 
	}	
}
