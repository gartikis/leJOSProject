import lejos.hardware.motor.EV3MediumRegulatedMotor;

// Class for the medium servo motor that lifts the pen up and down

public class Penupp {
		
		private EV3MediumRegulatedMotor penmotor;
		public Penupp(EV3MediumRegulatedMotor penmotor) {
			this.penmotor = penmotor;
			
		}
		
		public void up() {
			penmotor.rotate(-90);
			
		}
		
		public void down() {
			penmotor.rotate(90);
		}

}
