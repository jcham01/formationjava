package principal;

import java.sql.*;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection base =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/base1",
												"root",
												"");
			System.out.println("connecté!");
			Statement request = base.createStatement();
			
			Scanner reader = new Scanner(System.in);
			System.out.println("prix minimum ?");
			double prix = Double.parseDouble(reader.nextLine());
			
			
			ResultSet rs = request.executeQuery(
					"select * from `article` where `prix`>"+ prix);
			while (rs.next())
			{
				System.out.println(rs.getString("nom"));
			}
			rs.close();
			
			PreparedStatement request2 = base.prepareStatement(
					"select * from `article` where `poids` > ?");
	
			System.out.println("poids minimum ?");
			double poids = Double.parseDouble(reader.nextLine());
	
			// attention, les parametre commencent a 1, et non à 0
			request2.setDouble(1, poids);
			
			rs = request2.executeQuery();
			while (rs.next())
			{
				System.out.println(rs.getString("nom"));
			}
			rs.close();
			/*
			PreparedStatement insertStatement = base.prepareStatement(
					"insert into `article` (`nom`,`prix`, `poids`) values(?,?,?)");
			
			System.out.println("nom article a creer?");
			String nom = reader.nextLine();
			System.out.println("prix article a creer?");
			prix = Double.parseDouble(reader.nextLine());
			System.out.println("poids article a creer?");
			poids = Double.parseDouble(reader.nextLine());
			
			insertStatement.setString(1, nom);
			insertStatement.setDouble(2, prix);
			insertStatement.setDouble(3, poids);
			
			int nbrows = insertStatement.executeUpdate();
			System.out.println(nbrows + " lignes insérées");
			*/
			request = base.createStatement();
			
			rs = request.executeQuery(
					"select `id`, `nom` as `denomination`, `prix`, `poids`,"
					+ " `poids` * 10 as `prixlivraison` from `article`");
			
			ResultSetMetaData rsMeta = rs.getMetaData();
			for (int i=1; i <= rsMeta.getColumnCount(); i++) {
				System.out.println(rsMeta.getColumnLabel(i) 
						+ " -> " + rsMeta.getColumnTypeName(i)
						+ " : " + rsMeta.getColumnClassName(i));
			}
			rs.close();
			base.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
