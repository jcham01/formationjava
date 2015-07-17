package com.loncoto.webArticle.utils;

import java.sql.*;
import java.util.*;

import com.loncoto.webArticle.beans.Article;

public class ArticleDAO {
	public static final String FIND_ALL_SQL = "select * from `article`";
	
	private Connection base;
	
	private PreparedStatement findAllSatement;
	
	public ArticleDAO(Connection base) {
		this.base = base;
		
		try {
			findAllSatement = base.prepareStatement(FIND_ALL_SQL);
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
	
	public List<Article> findAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		try {
			findAllSatement.clearParameters();
			ResultSet rs = findAllSatement.executeQuery();
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
