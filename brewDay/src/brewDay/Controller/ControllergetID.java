package Controller;

import java.sql.SQLException;

import brewDay.Brew;

public class ControllergetID extends Controllermain {

	public ControllergetID(Brew b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	public String getID() {// The getMoney method takes the name of a bank customer as argument.
			int result;
			try {
				result = b.getNewestBrewID(b);
			
			return "The ID of is " + result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// The getID method of the controller then transforms the integer result of
			// the
			// getID method of the BREW into a string and returns that ID as result
			// (to the view).
			return null;
		
	}

}

