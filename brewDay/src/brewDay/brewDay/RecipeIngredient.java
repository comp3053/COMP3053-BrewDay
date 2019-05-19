package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeIngredient extends Ingredient {

	public RecipeIngredient(String nameOfIngredient, float amountOfIngredient, String unitOfIngredient) {
		super(nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	public void addIngredientToRecipe(int recipeID, String rName) throws SQLException {
		String name = this.getNameOfIngredient();
		float amount = this.getAmountOfRecipeIngredient();
		String unit = this.getUnitOfIngredient();
		int flag = 0;

		ResultSet rs = Database.Select("SELECT Name FROM RecipeIngredient Where RecipeID = " + recipeID);
		while(rs.next()) {
			String ingredientName = rs.getString("Name");
			if(name.equals(ingredientName)) {
				flag = 1;
				break;
			}
			else {
				continue;
			}
		}

		if(flag == 0) {
			String sqlInsert = "INSERT INTO RecipeIngredient Values (NULL,'" + name +"','" + amount + "','"+ unit +"','"+ recipeID + "')";
			Database.Insert(sqlInsert);
			System.out.println("Ingredient " + name + " has been successfully added to recipe " + rName);
		}
		else {
			System.out.println("Ingredient " + name +" has already been put into the recipe.");
		}
	}
	
	public float getAmountOfRecipeIngredient() {
		return super.getAmountOfIngredient();
	}

	public String getNameOfRecipeIngredient() {
		return super.getNameOfIngredient();
	}


}
