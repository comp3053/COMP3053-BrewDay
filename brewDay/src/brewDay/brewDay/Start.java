package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

	public static int readIntCommand() {
		Scanner getCommand = new Scanner(System.in);
		int result;
		try {
			result = getCommand.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You muse type an integer!");
			result = readIntCommand();
		}
		while (result < 0) {
			System.out.println("Positive integers only!");
			result = readIntCommand();
		}
		getCommand.nextLine();
		return result;
	}



	public static void viewSpecificRecipe() throws SQLException {
		System.out.print("Input the recipe name that you want to check:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		Recipe r = new Recipe(name);
		if(r.whetherInDB() == false) {
			System.out.println("Recipe " + name + " not found in database.");
		}
		else {
			System.out.println("The Ingredient of recipe " + name +" are as follow: ");
			r.viewIngredient();
		}

	}

	public static void addRecipe() {
		while(true) {
			System.out.println("Input the name of the recipe (No space in bewteen):");
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			Recipe rTemp = new Recipe(name);
			if(rTemp.whetherInDB() == true) {
				System.out.println("Recipe " + name + "has already been put into database.");
				break;
			}
			System.out.println("Input the quantity of the recipe: ");
			int quantity = readIntCommand();
			System.out.println("Input the unit of the recipe: ");
			String unit = input.next();
			Recipe r = new Recipe(name, quantity, unit);
			r.addRecipeToDB();
			System.out.println("Do you want to add ingredients for "+name+" ?");
			while(true)
			{
				System.out.println("Input [Y] to add ingredients, otherwise, input [N]");
				Scanner sc = new Scanner(System.in);
				String command = sc.nextLine();

				if(command.equals("Y") || command.equals("y")){

					String sqlGetId = "SELECT RecipeID FROM Recipe WHERE Name = '" + name + "' ";
					ResultSet rs = Database.Select(sqlGetId);
					int recipeId = -1;
					try {
						while(rs.next()) {
							recipeId = rs.getInt("RecipeID");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					System.out.println("Input the name of the ingredient: ");
					Scanner s1 = new Scanner(System.in);
					String iname = s1.nextLine();

					System.out.println("Input the amount of the ingredient: ");
					Scanner s2 = new Scanner(System.in);
					int iamount = readIntCommand();

					System.out.println("Input the unit of the ingredient: ");
					Scanner s3 = new Scanner(System.in);
					String iunit = s3.nextLine();
					RecipeIngredient ri = new RecipeIngredient(iname, iamount, iunit);
					try {
						ri.addIngredientToRecipe(recipeId, name);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				else if(command.equals("N") || command.equals("n")) {
					break;
				}
				else {
					System.out.println("You must input Y or N");
					continue;
				}
			}
			break;
		}
	}

		public static void addIngredient() {
			while(true) {
				System.out.println("0.exit");
				System.out.println("1.Add ingredient to storage");
				System.out.println("2.Add ingredient to a recipe");
				int command = readIntCommand();
				if(command == 0) {
					break;
				}
				else if(command == 1) {
					System.out.println("Input the name of the ingredient: ");
					Scanner input = new Scanner(System.in);
					String name = input.nextLine();
					System.out.println("Input the amount of the ingredient: ");
					int amount = readIntCommand();
					System.out.println("Input the unit of the ingredient: ");
					String unit = input.nextLine();
					StorageIngredient i = new StorageIngredient(name, amount, unit);
					try {
						i.addIngredient(name, amount, unit);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else if(command == 2) {
					System.out.println("Input the recipe name that you want to add ingredient: ");
					Scanner input = new Scanner(System.in);
					String rName = input.nextLine();
					Recipe r = new Recipe(rName);
					if(r.whetherInDB() == false) {
						System.out.println("No such recipe found in database.");
						break;
					}
					String sqlGetId = "SELECT RecipeID FROM Recipe WHERE Name = '" + rName + "' ";
					ResultSet rs = Database.Select(sqlGetId);
					int recipeId = -1;
					try {
						while(rs.next()) {
							recipeId = rs.getInt("RecipeID");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					System.out.println("Input the name of the ingredient: ");
					String name = input.nextLine();
					System.out.println("Input the amount of the ingredient: ");
					int amount = readIntCommand();
					System.out.println("Input the unit of the ingredient: ");
					String unit = input.nextLine();
					RecipeIngredient ri = new RecipeIngredient(name, amount, unit);
					try {
						ri.addIngredientToRecipe(recipeId, rName);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("You must input a valid integer!");
					continue;
				}
				break;
			}
		}


		public static void brew() throws SQLException {
			while(true) {
				System.out.println("Input the name of recipe that you want to brew:");
				Scanner getInput = new Scanner(System.in);
				String recipeName = getInput.nextLine();

				System.out.println("Input the batchsize that you want to brew:");
				Scanner getBatchSize = new Scanner(System.in);
				float getSize = getBatchSize.nextFloat();
				if(getSize == 0)
				{
					System.out.println("You must brew more than 0");
					continue;
				}
				float getCapacity = Equipment.Capacity();
				//System.out.println(getCapacity);
				if(getSize > getCapacity)
				{
					System.out.println("The current capacity is not enough, "+ getCapacity + " is less than "+getSize);
					break;
				}

				Recipe r = new Recipe(recipeName);
				String command;
				if(r.whetherInDB() == false) {
					System.out.println("No such recipe fount in database.");
					break;
				}
				else {
					System.out.println("Recipe " + recipeName +" is found in database.");
					System.out.println("Input [Y] to implement, otherwise, input [N]");
					command = getInput.nextLine();
				}


				if(command.equals("Y") || command.equals("y")){
					Brew b = new Brew(getSize, r);
					b.implement(r);
					break;
				}
				else if(command.equals("N") || command.equals("n")) {
					System.out.println("Implement process stop.");
					break;
				}
				else {
					System.out.println("You must input Y or N");
					continue;
				}
			}

		}

		private static void recommend() throws SQLException{
			boolean flag = false;
			while(true)
			{
				System.out.println("Input the number of bitchsize that you want to brew:");
				@SuppressWarnings("resource")
				Scanner getInput = new Scanner(System.in);
				float batchsize = getInput.nextFloat();
				//String recipeName = getInput.nextLine();
				float getCapacity = Equipment.Capacity();
				//System.out.println(getCapacity);
				if(batchsize > getCapacity)
				{
					System.out.println("The current capacity is not enough, "+ getCapacity + " is less than "+batchsize);
					break;
				}
				else 
				{

					flag = Brew.recommend(batchsize);
					if (flag == false)
					{
						break;
					}
					else {
						//System.out.println("The following recipes are recommend:");
						Scanner sc = new Scanner(System.in);
						System.out.println("Which recipe do you want to brew? Please input the recipe name:");
						String s = sc.nextLine();
						Recipe r = new Recipe(s);

						Brew b = new Brew(batchsize, r);
						b.implement(r);
						System.out.println("Brew Finished");
						break;
					}

				}
			}
		}





		public static void main(String[] args) throws SQLException {
			ShoppingList sl = new ShoppingList("Shopping list 1");

			while (true) {
				System.out.println("You are in start page, input the number to select the option:");
				System.out.println("1.View all recipes");
				System.out.println("2.View ingredients of a specific recipe");
				System.out.println("3.Add recipe");
				System.out.println("4.Add ingredient");
				System.out.println("5.Brew");
				System.out.println("6.Recommand a recipe");
				System.out.println("7.Maintain equipment");
				System.out.println("8.View all StorageIngredient");
				System.out.println("9.View all brew log");
				System.out.println("10.Maintain Note");
				int command = readIntCommand();
				switch (command) {
				case 1:
					System.out.println("---All the recipes in the database are as follow---");
					Recipe.getAllRecipes(); //gr
					break;
				case 2:
					viewSpecificRecipe();
					break;
				case 3:
					addRecipe();
					break;
				case 4:
					addIngredient();
					break;
				case 5:
					brew();
					break;
					//gr
				case 6:
					recommend();
					break;
					//gr
				case 7:
					Equipment e = new Equipment();
					System.out.println("1.add capacity");
					System.out.println("2.subtract capacity");
					System.out.println("3.update capacity");
					System.out.println("4.get capacity");
					int equipment= readIntCommand();
					if(equipment == 1)
					{
						System.out.println("Input the capacity number you want to add");
						Scanner sc = new Scanner(System.in);
						float f = sc.nextFloat();
						e.addCapacity(f);
						break;
					}
					else if(equipment == 2)
					{
						System.out.println("Input the capacity number you want to subtract");
						Scanner sc = new Scanner(System.in);
						float f = sc.nextFloat();
						e.subtractCapacity(f);
						break;
					}
					else if(equipment == 3)
					{
						System.out.println("Input the capacity number you want to change");
						Scanner sc = new Scanner(System.in);
						float f = sc.nextFloat();
						e.updateCapacity(f);
						break;
					}
					else if(equipment == 4)
					{
						System.out.println("The current capacity is: "+e.getCapacity());
					}
					else {
						System.out.println("please input 1,2,3,or 4, others are not valid!");
						continue;
					}
					//gr
				case 8:
					StorageIngredient.getAllStorageIngredient();
					break;
					//gr
				case 9:
					Brew.BrewRecord();
					break;
					//gr
				case 10:
					Note n = new Note();
					System.out.println("1.Add note 2.Delete note 3.Edit note");
					int op= readIntCommand();
					if(op == 1)
					{
						System.out.println("This is Brew record, please input the BrewID which you want to write note: ");
						Brew.BrewRecord();
						int brewID= readIntCommand();
						System.out.println("Please input the note content: ");
						Scanner sc = new Scanner(System.in);
						String note = sc.nextLine();
						if(n.addNote(note, brewID) == true)
							System.out.println("Add note successfully!");
						else {
							System.out.println("Add note fail!");
						}
						break;
					}
					else if(op == 2)
					{
						System.out.println("This is all note record");
						Note.showAllNote();
						System.out.println("Please input the NoteID which you want to delete: ");
						int getID= readIntCommand();
						n.delete(getID);
						break;

					}
					else if(op == 3)
					{
						System.out.println("This is all note record");
						Note.showAllNote();
						System.out.println("Please input the NoteID which you want to edit: ");
						int getID= readIntCommand();
						System.out.println("Please input the note content: ");
						Scanner sc = new Scanner(System.in);
						String note = sc.nextLine();
						if(n.edit(note, getID)==true)
						{
							System.out.println("Edit note successfully!");
						}
						else {
							System.out.println("Edit note fail!");
						}
						break;
					}


				}
			}

		}

	}
