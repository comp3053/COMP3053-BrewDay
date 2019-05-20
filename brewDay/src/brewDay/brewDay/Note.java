package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

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
	
	public boolean whetherInDB(int nid) throws SQLException {
		ResultSet getRecord = Database.Select("SELECT * FROM Note");
		int i = 0;
		while (getRecord.next()) { 
			int getID = getRecord.getInt("NoteID");
			if(getID == nid) {
				i = 1;
				break;
			}
			else {
				continue;
			}
	}
		if(i==1) {
		return true;}
		else {
			return false;
		}
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
	public static void UIedit(String input,int noteID) {
		
			
			Database.Update("UPDATE Note Set Content = '" + input +"' Where NoteID ="+ noteID);
			
	}
	
	public static String getText(int noteID) throws SQLException {
		String text;
		Vector<Vector<Object>> dataVector = new
				Vector<Vector<Object>>();
		ResultSet rs=Database.Select("SELECT * FROM Note WHERE NoteID ="+ noteID);
		while(rs.next()){
			Vector<Object> vec = new Vector<Object>();//single for big Vector
			
			vec.add(rs.getObject(2));
			
			dataVector.add(vec);
		
		}
		text = dataVector.toString();
		text = text.replace("[", "");
		text = text.replace("]", "");
		return text;
		
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
