import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class Light implements Behavior {
	private EV3LargeRegulatedMotor paper;

	EV3ColorSensor cs;
	float[] light = new float[3];
	Light(EV3LargeRegulatedMotor paper, EV3ColorSensor cs) {
		this.paper = paper;
		this.cs = cs;
	}
	
	public void action() {
		Delay.msDelay(2000);
		paper.backward();
		Delay.msDelay(1000);
		paper.stop();
	}
	
	public void suppress() {}
		
	public boolean takeControl() {
		SampleProvider sp1 = cs.getRGBMode();	
		sp1.fetchSample(light, 0);
		
		if ((light[0] > 0.01f) && (light[1] > 0.01f) && (light[2] > 0.01)) {
			return true;
			
		} else {
			return false;
		}

		}
	}
