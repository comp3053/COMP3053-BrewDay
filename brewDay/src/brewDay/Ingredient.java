package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ingredient {
	private String nameOfIngredient;
	private float amountOfIngredient;
	private char unitOfIngredient;

	public Ingredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		this.nameOfIngredient = nameOfIngredient;
		this.amountOfIngredient = amountOfIngredient;
		this.unitOfIngredient = unitOfIngredient;
	}




	//may be used in the future	
	public float getAmountOfIngredient() {
		return amountOfIngredient;
	}
	public void setAmountOfIngredient(float amountOfIngredient) {
		this.amountOfIngredient = amountOfIngredient;
	}

	public String getNameOfIngredient() {
		return nameOfIngredient;
	}

	public void setNameOfIngredient(String nameOfIngredient) {
		this.nameOfIngredient = nameOfIngredient;
	}

	public char getUnitOfIngredient() {
		return unitOfIngredient;
	}

	public void setUnitOfIngredient(char unitOfIngredient) {
		this.unitOfIngredient = unitOfIngredient;
	}

	public boolean deleteIngredient(String name) {
		return true;
	}
}
