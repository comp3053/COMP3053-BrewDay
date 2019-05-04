package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeIngredient extends Ingredient {

	public RecipeIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		super(nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	//function 1 add ingredient to the specific recipe, but not add into storage	
//	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient, int recipeId) throws SQLException {
//		String sql = "INSERT INTO RecipeIngredient VALUES (NULL, '" + nameOfIngredient + "','" + amountOfIngredient +"','" + unitOfIngredient +"'," + recipeId + ")";
//		Database.Insert(sql);
//		System.out.println("Ingredient " + nameOfIngredient + " has been successfully added into recipe ");
//	}
	public void addIngredientToRecipe(int recipeID, String rName) throws SQLException {
		String name = this.getNameOfIngredient();
		float amount = this.getAmountOfRecipeIngredient();
		char unit = this.getUnitOfIngredient();
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
//			this.recipeIngredients.add(recipeIngredient);
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
