package Controller;

import brewDay.Brew;

public class Controllermain {
	protected Brew b;
	// The b instance variable of the Controller class is protected (so that it can
		// be easily used in all the subclasses of Controller).
		public Controllermain(Brew b) {
			this.b = b;
		}

}
