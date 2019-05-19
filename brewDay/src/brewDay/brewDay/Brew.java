package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Brew {
	private float batchSize;
	private String date;

	private Note note;//useless variables
	private Recipe recipe;
	private StorageIngredient ingredient;
	public float temp = 0;

	public Brew(float batchSize, Recipe recipe) {
		if(batchSize > 0) {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
			this.date = date.format(new Date());
			this.batchSize = batchSize;
			this.recipe = recipe; 
		}
	}
	public void implement(Recipe recipe) throws SQLException { //implement the recipe that use select
		int flag = 0; //a mark
		int Rid; //recipe ID, for searching use
		Rid = recipe.getRecipeId();
		ResultSet getRI = Database.Select("SELECT Name, Amount FROM RecipeIngredient Where RecipeID = " + Rid);
		while (getRI.next()) { //get amount from the class RecipeIngredient
			String nameOfRI = getRI.getString("Name");
			float amountOfRI = getRI.getFloat("Amount");
			temp = (float)batchSize / recipe.getQuantityOfRecipe(); 
			amountOfRI = (float)temp * (float)amountOfRI;
			ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM StorageIngredient WHERE Name = '" + nameOfRI + "'");
			while(getAmountOfIngredient.next()) {//get amount from the class Ingredient
				String nameOfIngredient = getAmountOfIngredient.getString("Name");
				int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
				if(nameOfIngredient.equals(nameOfRI)) { //for the same ingredient in RI and ingredient
					if (amountOfIngredient >= amountOfRI) { //if the amount is enough for this operation, do other matching 
						continue;
					} else {// if no enough ingredient, the process stopped and give error message
						flag = 1;
						break;
					}
				}
			}
		}
		if (flag == 0) {//implement process
			
			ResultSet getRI1 = Database.Select("SELECT Name, Amount FROM RecipeIngredient Where RecipeID = " + Rid);
			while (getRI1.next()) {//get amount from the class RecipeIngredient
				String nameOfRI1 = getRI1.getString("Name");
				float amountOfRI1 = getRI1.getFloat("Amount");
				amountOfRI1 = (float)temp * (float)amountOfRI1;
				ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM StorageIngredient WHERE Name = '" + nameOfRI1 + "'");
				while(getAmountOfIngredient.next()) {//get amount from the class Ingredient
					float amountOfIngredient = getAmountOfIngredient.getFloat("Amount");
					float result = (float)amountOfIngredient - (float)amountOfRI1; //subtract and update the amount in class Ingredient
					String k1 = "UPDATE StorageIngredient SET Amount = " + result + " WHERE Name = '" + nameOfRI1 + "'";
					Database.Update(k1); //2 while loops update every ingredient needed for this brew
					System.out.println("Update amount of " + nameOfRI1);
				}
			}
			System.out.println("Brew finished.");
			String sqlBrew = "Insert Into Brew Values (NULL, " + batchSize+ " , '" + date + "' , " + Rid +")"; //insert brew data into database
			Database.Insert(sqlBrew);
		}else {
			System.out.println("No enough ingredient.");
		}
	}
	
	//gr
	public static boolean recommend(float batchsize) throws SQLException {
		//get the number of line
		int getline = 0;
		boolean flag = false;
		//to be continue
		int[] arr = new int[100];
		ResultSet getRecipe = Database.Select("SELECT Recipe.RecipeID, Recipe.Name, Quantity, RecipeIngredient.Name, RecipeIngredient.Amount, StorageIngredient.Amount FROM Recipe INNER JOIN RecipeIngredient INNER JOIN StorageIngredient ON Recipe.RecipeID = RecipeIngredient.RecipeID and RecipeIngredient.Name = StorageIngredient.Name");
		while (getRecipe.next()) { 
			int getRID = getRecipe.getInt("RecipeID");
			String getName = getRecipe.getString("Name");
			float getQuantity = getRecipe.getFloat("Quantity");
			float temp = (float)batchsize/(float)getQuantity;	// multiply
			String getIngredientName = getRecipe.getString("RecipeIngredient.Name");
			float getAmount = getRecipe.getFloat("RecipeIngredient.Amount");
			float getA = getRecipe.getFloat("StorageIngredient.Amount");
			float tempgetAmount = (float)temp * (float)getAmount;
			//get the number of line
			ResultSet getLine = Database.Select("SELECT COUNT(*) as count FROM RecipeIngredient Where RecipeID="+ getRID);
			while(getLine.next())
			{
				getline = getLine.getInt("count");
			}
			if(getA < tempgetAmount)
			{
				float need = (float)getA - (float)tempgetAmount;
				System.out.println("For recipe <"+getName+"> Storage of "+getIngredientName +" not enough"+", you should buy "+ (-need));
			}
			else
			{
				arr[getRID]++;
				
			}
			if(arr[getRID] == getline)
			{
				flag = true;
				ResultSet getRecommend = Database.Select("SELECT * FROM Recipe Where RecipeID="+ getRID);
				while(getRecommend.next())
				{
					int recommendID = getRecommend.getInt("RecipeID");
					String recommendName = getRecommend.getString("Name");
					System.out.print(recommendID);
					System.out.print(" "+recommendName);
					System.out.println();
					
				}
			}
			
		}
		return flag;
			
	}
	//gr
	public static void BrewRecord() throws SQLException {
		ResultSet getRecord = Database.Select("SELECT * FROM Brew");
		while (getRecord.next()) { 
			int getID = getRecord.getInt("BrewID");
			float getSize = getRecord.getFloat("BatchSize");
			String getDate = getRecord.getString("Date");
			int getRecipeID = getRecord.getInt("RecipeID");
			System.out.print(getID);
			System.out.print(" "+getSize);
			System.out.print(" "+getDate);
			System.out.print(" "+getRecipeID);
			System.out.println();
	}
	
	}
	public int getNewestBrewID(Brew b) throws SQLException {
		int getID = -1;
		ResultSet getBrewID = Database.Select("SELECT BrewID FROM Brew ORDER BY BrewID DESC LIMIT 1");
		while (getBrewID.next()) { 
			getID = getBrewID.getInt("BrewID");
			break;
	}
		return getID;
	}
}