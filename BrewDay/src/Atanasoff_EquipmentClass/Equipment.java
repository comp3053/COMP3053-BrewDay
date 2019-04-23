
public class Equipment {
	private brew b;
	private float capacity;
	
	Equipment(float capacity) {
		if(capacity >= 0) {
			this.capacity = capacity;
//			b = new brew(capacity, id);
		}
	}
	
	public boolean addCapacity(float input) {
		if(input >= 0) {
			this.capacity = this.capacity + input;
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
			System.out.println("Update capacity success!");
			return true;
		}
		else {
			System.out.println("Update capacity falied!");
			return false;
		}
	}
	
	public float getCapacity(){
		return capacity;
	}
}
