package brewDay;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map.Entry;

public class Brew {
	private float batchSize;
	private String date;

	private Note note;//useless variables
	private Recipe recipe;
	private StorageIngredient ingredient;
	//gr
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
	
	public static boolean recommend(float batchsize) throws SQLException {
		//get the number of line
		List list = new ArrayList(); // list for recipes recommend
		List<String> l = new LinkedList<String>(); // l for missing ingredients
		
		
		int getline = 0;
		boolean flag = false;
		int[] arr = new int[5000];
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

			
			// **************to be continue
			if(getA < tempgetAmount)
			{
				float need = (float)getA - (float)tempgetAmount;
				l.add("Recipe <"+getName+"> Storage of "+getIngredientName +" are not enough"+", you should buy "+ (-need));
				//System.out.println("For recipe <"+getName+"> Storage of "+getIngredientName +" not enough"+", you should buy "+ (-need));
			}
			else
			{
				arr[getRID]++;
				
			}
			
			if(arr[getRID] == getline)
			{
				flag = true;
				ResultSet getRecommend = Database.Select("SELECT * FROM Recipe Where RecipeID="+ getRID);
				
				ResultSetMetaData rsmd = getRecommend.getMetaData();
				while(getRecommend.next())
				{
					Map m = new HashMap();
					int columnCount = rsmd.getColumnCount();
					for(int i=0;i<columnCount;i++) {
						String columnName = rsmd.getColumnName(i+1);
						m.put(columnName,getRecommend.getObject(i+1));
					}
					list.add(m);
				}
				
			}
			
		}
		//System.out.println(l);
		for (String str : l) {
	        System.out.println(str);
	    }
		System.out.println(list);
		return flag;
			
	}
	

	
	public static Vector<Vector<Object>> recommendForUI(float batchsize) throws SQLException {
		//this function used for RecommendSuccess
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<String> l = new LinkedList<String>();
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>();
		
		int getline = 0;
		int[] arr = new int[5000];
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
				l.add("Recipe <"+getName+"> Storage of "+getIngredientName +" are not enough"+", you should buy "+ (-need));
				//System.out.println("For recipe <"+getName+"> Storage of "+getIngredientName +" not enough"+", you should buy "+ (-need));
			}
			else
			{
				arr[getRID]++;
				
			}
			if(arr[getRID] == getline)
			{
				//System.out.println("The following recipes are recommend: ");
				ResultSet getRecommend = Database.Select("SELECT * FROM Recipe Where RecipeID="+ getRID);
				ResultSetMetaData rsmd = getRecommend.getMetaData();
				/*while(getRecommend.next())
				{
					Map<String, Object> m = new HashMap();
					int columnCount = rsmd.getColumnCount();
					for(int i=0;i<columnCount;i++) {
						String columnName = rsmd.getColumnName(i+1);
						m.put(columnName,getRecommend.getObject(i+1));
					}
					list.add(m);
				}*/

				
				while(getRecommend.next()){
					Vector<Object> vec = new Vector<Object>();//single for big Vector
					for(int i=2;i<=4;i++){
						vec.add(getRecommend.getObject(i));
					}
					dataVector.add(vec);
				}
			}
			
		}
		// list l is for missing ingredients
		for (String str : l) {
	        System.out.println(str);
	    }
		// list list is for recommend recipes
		//System.out.println(list);	
		return dataVector;	
	}
	
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
	
	public static Vector<Vector<Object>> BrewRecord1() throws SQLException {
		ResultSet getRecord = Database.Select("SELECT * FROM Brew");
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>();
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
			Vector<Object> vec = new Vector<Object>();//single for big Vector
			for(int i=1;i<=4;i++){
				vec.add(getRecord.getObject(i));
			}
			dataVector.add(vec);
	}
	return dataVector;
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