import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Key;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.subsumption.Behavior;

// Behavior for emergency stop

public class EmergencyStop implements Behavior {
	
	private EV3LargeRegulatedMotor paper;
	private EV3LargeRegulatedMotor belt; 

	Brick brick = BrickFinder.getDefault();
	Key escape = brick.getKey("Escape");
	EmergencyStop(EV3LargeRegulatedMotor paper, EV3LargeRegulatedMotor belt) {
		this.paper = paper;
		this.belt = belt;
	}
	
	public void action() {
		paper.stop();
		belt.stop();
	}
	
	public void suppress() {}
	
	public boolean takeControl() {
		if(escape.isDown()) {
			return true;
		} else {
			return false;
		}
	}
}
