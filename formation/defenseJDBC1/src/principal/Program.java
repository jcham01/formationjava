package principal;

import java.sql.*;

public class Program {

	public static void main(String[] args) {
		try {
			// chargement/initialisation du driver MYSQL
			Class.forName("com.mysql.jdbc.Driver");
			// Connection est l'interface décrivant un objet permettant de se connecter
			// a une base de donnée
			// le DriverManager renvoie un objet implémentant cette interface
			// qui est capable de gérer l'url qu'on lui a fournie
		    Connection base =
		    		DriverManager.getConnection("jdbc:mysql://localhost:3306/base1",
												"root",
												"");
		    System.out.println("connecté!");
		    
		    //  je creer mon objet permettant de requetter la base
		    Statement request = base.createStatement();
		    
		    // execution d'une requette select
		    // elle nous renvoie un resultset qui nous permet
		    // de parcourir les lignes renvoyée
		    ResultSet rs = request.executeQuery("select * from `article`");
		    
		    // parcourir les lignes
		    while (rs.next()){
		    	// récupérer les colonnes qui nous intéressent
		    	// sur la ligne courante
		    	System.out.println(rs.getString("nom") +
		    			" -> " + rs.getDouble("prix"));
		    }
		    
		    // attention a bien libérer les ressources
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
