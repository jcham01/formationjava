package com.loncoto.webfirstjdbc.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.webfirstjdbc.beans.*;

public class ClientDAO {
	public static final String FIND_ALL_SQL = "select * from `client`";
	public static final String FIND_BY_ID_SQL = "select * from `client` where `id`=?";
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIDStatement;
	
	
	private Connection base;
	
	public ClientDAO(Connection base) {
		this.base = base;
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findByIDStatement = base.prepareStatement(FIND_BY_ID_SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Client findByID(int id) {
		Client c = null;
		try {
			findByIDStatement.clearParameters();
			// je remplace le premier point d'interogation par l'id que j'ai en parametre
			findByIDStatement.setInt(1, id);
			
			ResultSet rs = findAllStatement.executeQuery();
			if (rs.next()) {
				c = new Client(rs.getInt("id"),
						rs.getString("nom"),
						rs.getString("email"),
						rs.getDouble("solde"));
			}
			rs.close();
		} catch (SQLException e) {	e.printStackTrace();}
		return c;
	}
	
	
	
	public List<Client> findAll() {
		ArrayList<Client> data = new ArrayList<Client>();
		ResultSet rs = null;
		try {
			// je nettoie les parametres précédents
			findAllStatement.clearParameters();
			// j'execute la requette
			rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Client(rs.getInt("id"),
									rs.getString("nom"),
									rs.getString("email"),
									rs.getDouble("solde")));
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			// nous avons finit, nous fermons le resultset
			if (rs != null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		// on renvoie la liste des clients
		return data;
	}
	
	

}
