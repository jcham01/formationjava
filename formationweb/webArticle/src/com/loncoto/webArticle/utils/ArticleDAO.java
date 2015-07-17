package com.loncoto.webArticle.utils;

import java.sql.*;
import java.util.*;

import com.loncoto.webArticle.beans.Article;



public class ArticleDAO {
	
	public static final int ORDERED_BY_DEFAULT = 0;
	public static final int ORDERED_BY_PRIX = 1;
	public static final int ORDERED_BY_POIDS = 2;
	
	public static final String FIND_ALL_SQL = "select * from `article`";
	public static final String FIND_ALL_ORDERED_PRIX_SQL = "select * from `article` ORDER BY `prix`";
	public static final String FIND_ALL_ORDERED_POIDS_SQL = "select * from `article` ORDER BY `poids`";
	public static final String FIND_BY_ID_SQL = "select * from `article` where `id`=?";
	public static final String UPDATE_ONE_SQL = "update `article` set `libelle`=?, `prix`=?, `poids`=? where `id`=?";
	public static final String INSERT_ONE_SQL = "insert into `article` (`libelle`, `prix`, `poids`) values (?,?,?)";


	
	
	private Connection base;
	
	private PreparedStatement findAllSatement;
	private PreparedStatement findAllOrderedPrixSatement;
	private PreparedStatement findAllOrderedPoidsSatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;

	
	public ArticleDAO(Connection base) {
		this.base = base;
		
		try {
			findAllSatement = base.prepareStatement(FIND_ALL_SQL);
			findAllOrderedPrixSatement = base.prepareStatement(FIND_ALL_ORDERED_PRIX_SQL);
			findAllOrderedPoidsSatement = base.prepareStatement(FIND_ALL_ORDERED_POIDS_SQL);
			findByIDStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// on renvoie un objet Article qui correspond a une ligne du resultSet
	private Article fetchRow(ResultSet rs) {
		try {
			return new Article(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"), rs.getDouble("poids"));
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public int save(Article a) {
		if (a.getId() > 0) {
			// c'est un update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, a.getLibelle());
				updateOneStatement.setDouble(2, a.getPrix());
				updateOneStatement.setDouble(3, a.getPoids());
				updateOneStatement.setInt(4, a.getId());
				return updateOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			// c'est une insert
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, a.getLibelle());
				insertOneStatement.setDouble(2, a.getPrix());
				insertOneStatement.setDouble(3, a.getPoids());
				return insertOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Article findByID(int id) {
		Article a = null;
		try {
			findByIDStatement.clearParameters();
			// je remplace le premier point d'interogation par l'id que j'ai en parametre
			findByIDStatement.setInt(1, id);
			
			ResultSet rs = findByIDStatement.executeQuery();
			if (rs.next()) {a = fetchRow(rs);}
			
			rs.close();
		} catch (SQLException e) {	e.printStackTrace();}
		return a;
	}
	
	
	
	
	public List<Article> findAll() {return findAll(ORDERED_BY_DEFAULT); }
	public List<Article> findAll(int orderType) {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		
		try {
			// stat contiendra la requette choisi pour execution
			// soit la requette basique, soit une requette avec orderby
			// et on choisi aussi la colonne pour orderby le cas échéant
			PreparedStatement stat = findAllSatement;
			switch (orderType) {
				case ORDERED_BY_DEFAULT:
					findAllSatement.clearParameters();
					stat = findAllSatement;
					break;
				case ORDERED_BY_POIDS:
					findAllOrderedPoidsSatement.clearParameters();
					stat = findAllOrderedPoidsSatement;
					break;
				case ORDERED_BY_PRIX:
					findAllOrderedPrixSatement.clearParameters();
					stat = findAllOrderedPrixSatement;
					break;
			}
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				articles.add(fetchRow(rs));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
}
