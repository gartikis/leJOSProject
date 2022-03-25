import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.motor.EV3MediumRegulatedMotor;

// Class that prints "Hello World"

public class HelloWorld implements Behavior {

	private State state;
	private EV3MediumRegulatedMotor penadj;
	private EV3LargeRegulatedMotor paper;
	private EV3LargeRegulatedMotor belt;
	
	public 	HelloWorld(State state, EV3ColorSensor sensor, EV3LargeRegulatedMotor paper, EV3LargeRegulatedMotor belt, EV3MediumRegulatedMotor penadj) {
		this.state = state;
		this.paper = paper;
		this.belt = belt;
		this.penadj = penadj;
	}
	
	public boolean takeControl() {
		
		belt.setSpeed(200);
		paper.setSpeed(100);
		return state.stage() == Stage.HELLOWORLD;
	
	}
	

	public void action() {
		 int p1cm = (int) (80.597);// up 1cm
		 int b1cm = (int) (-93.1034);//left 1cm
		 
		/* H */
		Penupp penpos = new Penupp(penadj);
		penpos.down();
		belt.rotate((int) -186.2);
		penpos.up();
		belt.rotate((int) 93.104);	
		penpos.down();
		paper.rotate((int) 80.597);
		belt.rotate((int) 93.104);
		belt.rotate((int) -186.2);
		paper.rotate(p1cm);
		penpos.up();
		
		/* E */
		
		penpos.down();
		paper.rotate(p1cm*2);
		paper.rotate(-p1cm*2);
		belt.rotate(-b1cm);
		paper.rotate(p1cm);
		paper.rotate(p1cm);
		belt.rotate(-b1cm);
		paper.rotate(p1cm*2);
		paper.rotate(-p1cm*2);
		penpos.up();
		
		/* L */
		
		paper.rotate(b1cm);
		penpos.down();
		belt.rotate(b1cm*2);
		paper.rotate(p1cm * 2);
		penpos.up();
		
		/* L*/
		paper.rotate(-p1cm);
		penpos.down();
		belt.rotate(-2 * b1cm);
		belt.rotate(2 * b1cm);
		paper.rotate(2*p1cm);
		
		/* O */
		paper.rotate(p1cm);
		penpos.down();
		paper.rotate(2*p1cm);
		belt.rotate(-2*b1cm);
		paper.rotate(2*p1cm);
		belt.rotate(2*b1cm);
		
		
		state.setStage(Stage.FEEDPAPER);
		}
	
	@Override
	public void suppress() {	
		
	}

}
