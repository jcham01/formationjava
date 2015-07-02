package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IncidentDAO {
	public static final String SELECT_ALL_SQL = "select * from `Incident`";
	
	private PreparedStatement selectAllStatement;
	
	private Connection base;
	
	public IncidentDAO () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			base =	DriverManager.getConnection("jdbc:mysql://localhost:3306/base2",
												"root",
												"");
			System.out.println("connecté!");
			selectAllStatement = base.prepareStatement(SELECT_ALL_SQL);
			
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
	
	public ArrayList<Incident> findAll() {
		
		ArrayList<Incident> incidents = new ArrayList<Incident>();
		
		try {
			ResultSet rs = selectAllStatement.executeQuery();
			while (rs.next()) {
				incidents.add(new Incident(rs.getInt("id"),
						rs.getString("description"),
						new java.util.Date(rs.getDate("date").getTime()), // conversion sql.Date -> util.Date
						rs.getInt("urgence"),
						rs.getString("categorie")));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		
		return incidents;
	}

}
