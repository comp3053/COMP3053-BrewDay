package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Equipment {
	private Brew b;
	private float capacity;
	
	public Equipment() throws SQLException {
			this.capacity = this.getCapacity();
		}
	
	public boolean updateCapacity(float input) {//user are only allowed to update the capacity
		if(input >= 0) {// if the input value is positive or 0
			this.capacity = input;
			String sql = "Update Equipment Set Capacity = " + this.capacity;
			Database.Update(sql);//update capacity in database
			System.out.println("Update capacity success!");
			return true;
		}
		else {//if input value is negative
			System.out.println("Update capacity falied!");
			return false;
		}
	}
	
	public boolean addCapacity(float input) {//not used by the system
		if(input >= 0) {
			this.capacity = this.capacity + input;
			String sql = "Update Equipment Set Capacity = " + this.capacity;
			Database.Update(sql);
			System.out.println("Add capacity success!");
			return true;
		}
		else {
			System.out.println("Add capacity falied!");
			return false;
		}
	}
	
	public boolean subtractCapacity(float input) {//not used by the system
		if(input >= 0 && input <= this.capacity) {
			this.capacity = this.capacity - input;
			String sql = "Update Equipment Set Capacity = " + this.capacity;
			Database.Update(sql);
			System.out.println("Subtract capacity success!");
			return true;
		}
		else {
			System.out.println("Subtract capacity falied!");
			return false;
		}
	}
	
	
	public float getCapacity() throws SQLException{
		ResultSet r = Database.Select("SELECT Capacity FROM Equipment");
		while(r.next())
		{
			this.capacity = r.getFloat("Capacity");
		}
		
		return this.capacity;
	}
	//gr
	public static float Capacity() throws SQLException{
		ResultSet rs = Database.Select("SELECT Capacity FROM Equipment");
		float Capacity = 0;
		while(rs.next())
		{
			Capacity = rs.getFloat("Capacity");
		}
		
		return Capacity;
	}
	//gr
}
