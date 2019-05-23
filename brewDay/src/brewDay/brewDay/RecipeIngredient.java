package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeIngredient extends Ingredient {//inherit from Ingredient

	public RecipeIngredient(String nameOfIngredient, float amountOfIngredient, String unitOfIngredient) {
		super(nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	public void addIngredientToRecipe(int recipeID, String rName) throws SQLException {//add RI to database, related with recipe
		String name = this.getNameOfIngredient();
		float amount = this.getAmountOfRecipeIngredient();
		String unit = this.getUnitOfIngredient();
		int rID = -1;
		int flag = 0;//a mark

		ResultSet rs = Database.Select("SELECT Name, RecipeIngredientID FROM RecipeIngredient Where RecipeID = " + recipeID);
		while(rs.next()) {//search in database to find whether this RI exists in database and related with the same recipe
			String ingredientName = rs.getString("Name");
			rID = rs.getInt("RecipeIngredientID");
			if(name.equals(ingredientName)) {//if matching 
				flag = 1;//change the mark and stop matching
				break;
			}
			else {//if not match, keep on doing matching
				continue;
			}
		}

		if(flag == 0) {//if RI doesn't exist in database
			String sqlInsert = "INSERT INTO RecipeIngredient Values (NULL,'" + name +"','" + amount + "','"+ unit +"','"+ recipeID + "')";
			Database.Insert(sqlInsert);//insert into database
			System.out.println("Ingredient " + name + " has been successfully added to recipe " + rName);
		}
		else {//if this RI exists in database
			String sqlUpdate = "UPDATE RecipeIngredient SET Amount = " + amount + " WHERE RecipeIngredientID = " + rID;
			Database.Update(sqlUpdate);//update its amount
			System.out.println("Amount of ingredient " + name +" has been updated.");
		}
	}
	
	public float getAmountOfRecipeIngredient() {
		return super.getAmountOfIngredient();
	}

	public String getNameOfRecipeIngredient() {
		return super.getNameOfIngredient();
	}


}
