import java.util.Date;

public class brew {
	private StorageIngredient ingredient;
	private float batchSize;
	private Date date;
	private Date time;
	private int idOfBrew;
	
	public brew(float batchSize, int idOfBrew) {
		if(batchSize > 0) {
			this.batchSize = batchSize;
			this.idOfBrew = idOfBrew;
		}
	}
	
	public boolean implement(float batchSize) {
		if()
	}
}
