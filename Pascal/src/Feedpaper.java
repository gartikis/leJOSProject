import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.motor.EV3MediumRegulatedMotor;

// Class that feeds the paper through once the printing is done

public class Feedpaper implements Behavior {
	
	private State state;
	private EV3LargeRegulatedMotor belt;
	private EV3TouchSensor leftTouch;
	private EV3LargeRegulatedMotor paper;
	private EV3MediumRegulatedMotor penadj;
	
	public Feedpaper(State state, EV3LargeRegulatedMotor belt, EV3LargeRegulatedMotor paper, EV3TouchSensor leftTouch, EV3MediumRegulatedMotor penadj){
		this.state = state;
		this.belt = belt;
		this.paper = paper;
		this.leftTouch = leftTouch;
		this.penadj = penadj;
		belt.setSpeed(200);
		
	}
	
	public boolean takeControl() {
		return state.stage() == Stage.FEEDPAPER;
	}

	public void action() {
		Penupp penpos = new Penupp(penadj);
		penpos.up();
		paper.rotate(-2700, true);
	
		state.setStage(Stage.CONTINUE);
		}
						     

	@Override
	public void suppress() {
		
	}
}
