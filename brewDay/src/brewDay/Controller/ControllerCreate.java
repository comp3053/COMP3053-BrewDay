package Controller;

import brewDay.Brew;

public class ControllerCreate extends Controllermain {
	public ControllerCreate(Brew b) {
		super(b);
	}

	public String create(String name, String amount, String unit) {
		int i;
		
		try {
			i = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			return "Wrong Format " + e.getMessage();
		}
		i = Integer.parseInt(amount);
		
		
		return "";

	}

}

