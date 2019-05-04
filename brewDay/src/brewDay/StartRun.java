//package brewDay;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class StartRun {
//	
//	public static void main(String[] args) throws SQLException {
//		// Demo: Select info from database
//		/*
//		 sql = " SELECT attribute1, attribute2 FROM table_name Where attribute1 = 'xxxxxx' "
//		 */
//		ResultSet rs = Database.Select("SELECT RecipeId, Name, Quantity, Unit FROM Recipe Where name = 'Lennox'");
//		while(rs.next())
//		{
//          int RecipeID  = rs.getInt("RecipeID");
//          String Name = rs.getString("Name");
//          float Quantity = rs.getFloat("Quantity");
//          String Unit = rs.getString("Unit");
//
//          System.out.print(RecipeID);
//          System.out.print(" " + Name);
//          System.out.print(" " + Quantity);
//          System.out.print(" " + Unit);
//          System.out.println();
//      }
//		// Demo: Delete a row from database
//		//Database.Delete("DELETE FROM Recipe WHERE RecipeID = 1");
//		
//		// Demo: Insert a row into database 
//		//Database.Insert("Insert Into Recipe Values ('4','ha121213','10','L')");
//		
//		// Demo: Update info from database
//		//Database.Update("Update Recipe Set Name = 'Lennox' Where RecipeID = 2 ");
//		
//		// Demo: Empty one table(only delete the data but not for attributes)
//		//Database.SetZero("Delete from Recipe");
//	}
//}


