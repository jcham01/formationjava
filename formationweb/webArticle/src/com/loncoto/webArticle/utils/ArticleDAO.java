package com.loncoto.webArticle.utils;

import java.sql.*;
import java.util.*;

import com.loncoto.webArticle.beans.Article;

public class ArticleDAO {
	
	public static final int ORDERED_BY_DEFAULT = 0;
	public static final int ORDERED_BY_PRIX = 1;
	public static final int ORDERED_BY_POIDS = 2;
	
	public static final String FIND_ALL_SQL = "select * from `article`";
	public static final String FIND_ALL_ORDERED_SQL = "select * from `article` ORDER BY ?";
	
	
	private Connection base;
	
	private PreparedStatement findAllSatement;
	private PreparedStatement findAllOrderedSatement;
	
	
	public ArticleDAO(Connection base) {
		this.base = base;
		
		try {
			findAllSatement = base.prepareStatement(FIND_ALL_SQL);
			findAllOrderedSatement = base.prepareStatement(FIND_ALL_ORDERED_SQL);
					
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
					findAllOrderedSatement.clearParameters();
					findAllOrderedSatement.setString(1, "poids");
					stat = findAllOrderedSatement;
					break;
				case ORDERED_BY_PRIX:
					findAllOrderedSatement.clearParameters();
					findAllOrderedSatement.setString(1, "prix");
					stat = findAllOrderedSatement;
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
