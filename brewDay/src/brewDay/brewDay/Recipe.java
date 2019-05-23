package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Recipe {
	private String nameOfRecipe;
	private float quantityOfRecipe;
	private String unit;
	private int recipeId;

	private ArrayList<RecipeIngredient> recipeIngredients;


	public Recipe(String nameOfRecipe, float quantityOfRecipe, String unit) {//generator 1, used for adding new recipe
		this.nameOfRecipe = nameOfRecipe;
		this.quantityOfRecipe = quantityOfRecipe;
		this.unit = unit;
		this.recipeIngredients = new ArrayList<RecipeIngredient>();
	}

	public Recipe(String nameOfRecipe) {//generator 2, used for other method using recipe, for example, add ingredient to recipe
		this.nameOfRecipe = nameOfRecipe;
		this.recipeIngredients = new ArrayList<RecipeIngredient>();//for storing RecipeIngredient
		String sqlGetId = "SELECT RecipeID FROM Recipe WHERE Name = '" + nameOfRecipe + "' ";
		ResultSet rs = Database.Select(sqlGetId);//get recipe ID from database if this recipe exists in database
		int recipeId = -1;//default value, recipe ID will never be -1 if it exists in database, it can be applied to whetherInDB() function
		try {
			while(rs.next()) {//if found such recipe in database
				recipeId = rs.getInt("RecipeID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlDetail = "SELECT Quantity, Unit FROM Recipe WHERE RecipeID = " + recipeId;
		rs = Database.Select(sqlDetail);//using the recipeID we found, we are able to get detail message of this recipe
		try {
			while(rs.next()) {
				this.quantityOfRecipe = rs.getInt("Quantity");
				this.unit = rs.getString("Unit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	//function 1
	public void addRecipeIngredients(RecipeIngredient recipeIngredient) throws SQLException {//add recipeIngredient to database
		String name = recipeIngredient.getNameOfIngredient();
		float amount = recipeIngredient.getAmountOfRecipeIngredient();
		String unit = recipeIngredient.getUnitOfIngredient();
		int recipeID = getRecipeId();//get the ID of current recipe
		int flag = 0;//for marking

		ResultSet rs = Database.Select("SELECT Name FROM RecipeIngredient Where RecipeID = " + recipeID);
		while(rs.next()) {
			String ingredientName = rs.getString("Name");
			if(name.equals(ingredientName)) {//if this recipeIngredient has already been into database
				flag = 1;//make change
				break;
			}
			else {//if two names are different, match on next RI
				continue;
			}
		}

		if(flag == 0) {//if the mark doesn't change
			String sqlInsert = "INSERT INTO RecipeIngredient Values (NULL,'" + name +"','" + amount + "','"+ unit +"','"+ recipeID + "')";
			Database.Insert(sqlInsert);//insert this RI to database, related to the recipe
			this.recipeIngredients.add(recipeIngredient);
			System.out.println("Ingredient " + recipeIngredient.getNameOfIngredient() + " has been successfully added to recipe " + this.nameOfRecipe);
		}
		else {
			System.out.println("Ingredient " + name +" has already been put into the recipe.");
		}
	}
	// function 2	
	public void deleteRecipe(String name) {//delete recipe function
				String sqlDelete = "DELETE FROM Recipe WHERE Name = '" + name +"'";
				Database.Delete(sqlDelete);
	}
	
	//function 3 
	public int getRecipeId() throws SQLException {//get recipeID of current recipe
		int recipeID = -1;
		int quantity = -1;//default value, for judging
		String sqlGetId = "SELECT RecipeID, Quantity FROM Recipe WHERE Name = '" + this.nameOfRecipe + "'";
		ResultSet rs = Database.Select(sqlGetId);
		while(rs.next()) {
			recipeID = rs.getInt("RecipeID");
			quantity = rs.getInt("Quantity");
		}
		if(quantity == -1) {//if the quantity of recpe is -1, that means the recipe doesn't exist in database
			return -1;
		}
		else {
			return recipeID;
		}
	}
	//function 4
	public void addRecipeToDB() {
		Database.Insert("Insert Into Recipe Values (NULL,'" + nameOfRecipe + "','"+ quantityOfRecipe + "','" + unit + "')");
		System.out.println(nameOfRecipe +" has been added into database.");
	}
	
	 // may need some change to the variable	
	public void deleteRecipeIngredient(String name) {
		String sqlGetId = "SELECT FROM Recipe WHERE Name = '" + nameOfRecipe + "'";
		ResultSet rs = Database.Select(sqlGetId);
		try {
			int recipeId = rs.getInt("RecipeID");
			String sqlDelete = "DELETE FROM RecipeIngredient WHERE Name = '" + name + "' and Recipe ID = '" + recipeId + "'" ;
			Database.Delete(sqlDelete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewIngredient() throws SQLException {
		int id = getRecipeId();
		String sql = "SELECT Name, Amount, Unit FROM RecipeIngredient WHERE RecipeID = " + id;
		ResultSet rs = Database.Select(sql);
		while(rs.next())
		{
			String Name = rs.getString("Name");
			float Amount = rs.getFloat("Amount");
			String Unit = rs.getString("Unit");
			RecipeIngredient ri = new RecipeIngredient(Name, Amount, Unit);
			this.recipeIngredients.add(ri);
			System.out.println(ri.getNameOfIngredient()+ " " + ri.getAmountOfIngredient()+ " " + ri.getUnitOfIngredient());
		}
		System.out.println();
		
	}
	public static ResultSet IngredientSet(String name) throws SQLException {
		String sql_0 = "SELECT * FROM Recipe WHERE Name = '" + name+"'";
		ResultSet rs = Database.Select(sql_0);
		String text;
		Vector<Vector<Object>> dataVector = new
				Vector<Vector<Object>>();
		while(rs.next()){
			Vector<Object> vec = new Vector<Object>();//single for big Vector
			
			vec.add(rs.getObject(1));
			
			dataVector.add(vec);
		
		}
		text = dataVector.toString();
		text = text.replace("[", "");
		text = text.replace("]", "");
		int id =Integer.parseInt(text);
		
		String sql = "SELECT Name, Amount, Unit FROM RecipeIngredient WHERE RecipeID = " + id;
		ResultSet rs_1 = Database.Select(sql);
		return rs_1;
	}
	//function 7
	public boolean whetherInDB() {
		if(this.getQuantityOfRecipe() == 0.0)
			return false;
		else
			return true;
	}

	//useless functions, but may be used in the future	

	public void updateQuantity(float quantity, String name) throws SQLException {
		if(quantity > 0) {
			this.setQuantityOfRecipe(quantity);
			String sqlUpdate = "UPDATE Recipe SET Quantity = '" + quantity + "'  WHERE Name = ' "+name+"'";
			Database.Update(sqlUpdate);
		}
		else {
			System.out.println("You must input a positive number.");
		}
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) throws SQLException {
		String sqlSet = "UPDATE Recipe SET Unit = '" + unit +"' Where RecipeID = " + getRecipeId()+ "";
		Database.Update(sqlSet);
		this.unit = unit;
	}

	public float getQuantityOfRecipe() {
		return quantityOfRecipe;
	}

	public void setQuantityOfRecipe(float quantityOfRecipe) throws SQLException {
		int recipeID = getRecipeId();
		String sqlUpdate = "UPDATE Recipe SET Quantity = " + quantityOfRecipe + " WHERE RecipeID = " + recipeID ;
		Database.Update(sqlUpdate);
		this.quantityOfRecipe = quantityOfRecipe;
	}

	public String getNameOfRecipe() {
		return nameOfRecipe;
	}

	public void setNameOfRecipe(String nameOfRecipe) throws SQLException { //error, don't know why
		int recipeID = getRecipeId();
		String sqlUpdate = "UPDATE Recipe SET Name = '" + nameOfRecipe + "' WHERE RecipeID = " + recipeID ;
		Database.Update(sqlUpdate);
		this.nameOfRecipe = nameOfRecipe;
	}
	//gr
	public static void getAllRecipes() throws SQLException {
		String sql = " SELECT * FROM Recipe";
		ResultSet rs = Database.Select(sql);
		while(rs.next())
		{
			String Name = rs.getString("Name");
			int amount = rs.getInt("Quantity");
			String unit = rs.getString("Unit");
			System.out.println(Name + " " + amount + " " + unit);
		}
		System.out.println();
	}
	
	public static ResultSet allRecipe() throws SQLException{
		String sql = " SELECT * FROM Recipe";
		ResultSet rs = Database.Select(sql);
		return rs;
		
	}
	//gr
}
