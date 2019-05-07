package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Equipment {
	private Brew b;
	private float capacity;
	
	public Equipment() throws SQLException {
			//gr
			//Database.Update("Update Equipment Set Capacity = capacity");
			//gr
			this.capacity = this.getCapacity();
		}
	
	public boolean addCapacity(float input) {
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
	
	public boolean subtractCapacity(float input) {
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
	
	public boolean updateCapacity(float input) {
		if(input >= 0) {
			this.capacity = input;
			String sql = "Update Equipment Set Capacity = " + this.capacity;
			Database.Update(sql);
			System.out.println("Update capacity success!");
			return true;
		}
		else {
			System.out.println("Update capacity falied!");
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
