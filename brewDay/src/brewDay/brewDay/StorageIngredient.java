package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageIngredient extends Ingredient {
	private Brew brew;

	public StorageIngredient(String nameOfIngredient, float amountOfIngredient,
		char unitOfIngredient) {
		super(nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	//function 1 add ingredient to the storage	
	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) throws SQLException {
		String name = "a";
		float amount = (float) 0.0;
		String unit = "a";
		int id = 0;
		String searchInDB = "SELECT Name, Amount, Unit, StorageIngredientID FROM StorageIngredient WHERE Name = '" + nameOfIngredient + "'";
		ResultSet rs = Database.Select(searchInDB);
		while(rs.next())
		{
			name = rs.getString("Name");
			amount = rs.getFloat("Amount");
			unit = rs.getString("Unit");
			id = rs.getInt("StorageIngredientID");
		}
		if(nameOfIngredient.equals(name) && unitOfIngredient == unit.charAt(0)) {
			amount += amountOfIngredient;
			String sqlAdd = "UPDATE StorageIngredient SET Amount = " + amount + " WHERE StorageIngredientID = " + id;
			Database.Update(sqlAdd);
			System.out.println("Amount of ingredient " + name + " has been added to the original amount.");
		}
		else {
			String sql = "Insert Into StorageIngredient Values (NULL,'" + nameOfIngredient + "','" + amountOfIngredient + "','" + unitOfIngredient + "')";
			Database.Insert(sql);
			System.out.println("Ingredient " + nameOfIngredient + " has been successfully added to the storage!");
		}
	}
	
	
	
	
	public boolean addAmount(String name, float amount) {
		setAmountOfIngredient(getAmountOfIngredient() + super.getAmountOfIngredient());
		return true;
	}
	public boolean subtractAmount(String name, float amount) {
		if(getAmountOfIngredient() >= amount) {
			setAmountOfIngredient(getAmountOfIngredient() - super.getAmountOfIngredient());
			return true;
		}
		else
			return false;
	}
	//gr
	public static void getAllStorageIngredient() throws SQLException {
		String sql = " SELECT * FROM StorageIngredient";
		ResultSet rs = Database.Select(sql);
		while(rs.next())
		{
			int ID = rs.getInt("StorageIngredientID");
			String Name = rs.getString("Name");
			int amount = rs.getInt("Amount");
			String unit = rs.getString("Unit");
			System.out.println(Name + " " + amount + " " + unit);
		}
		System.out.println();
	}
	
}
