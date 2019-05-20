package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
	//gr
	private String content;
	private String createdDate;
	private int idOfNote;
	private int idOfBrew;
	
	public Note() {
		this.content = null;	
		this.createdDate = null;
	}
	public boolean addNote(String content, int BrewID) {
		if(content == null)
			return false;
		else {
			this.idOfBrew = BrewID;
			this.content = content;
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
			this.createdDate = date.format(new Date());
			String sql = "INSERT INTO Note Values (NULL,'" + this.content +"','" + this.createdDate + "','"+ this.idOfBrew +"')";
			Database.Insert(sql);
			return true;
		}
		
	}
	//gr
	public boolean edit(String input,int noteID) {
		if (input == null) {
			return false;
		}
		else {
			this.idOfNote = noteID;
			this.content = input;
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
			this.createdDate = date.format(new Date());
			Database.Update("UPDATE Note Set Content = '" + this.content +"' Where NoteID ="+ this.idOfNote);
			return true;
		}
	}
	//gr
	public boolean delete(int id) {
			String sql = "Delete FROM Note Where NoteID =" +id;
			Database.Delete(sql);
			System.out.println("Delete note success!");
			return true;

	}
	public static void UIdelete(int id) {
		String sql = "Delete FROM Note Where NoteID =" +id;
		Database.Delete(sql);
		System.out.println("Delete note success!");


}
	//gr
	public static void showAllNote() throws SQLException {
		ResultSet getNote = Database.Select("SELECT * FROM Note");
		while (getNote.next()) { 
			int getID = getNote.getInt("NoteID");
			String getContent = getNote.getString("Content");
			String getDate = getNote.getString("createDate");
			int getBrewID = getNote.getInt("BrewID");
			System.out.print(getID);
			System.out.print(" "+getContent);
			System.out.print(" "+getDate);
			System.out.print(" "+getBrewID);
			System.out.println();
	}
}
	public static ResultSet AllNote() throws SQLException {
		ResultSet getNote = Database.Select("SELECT * FROM Note");
		return getNote;
}
}
