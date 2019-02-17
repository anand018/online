package com.mail.dao;

import java.sql.Blob;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mail.bo.ShowBookBo;

@Repository
public class ShowBooksDaoImpl implements ShowBooksDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String GET_ALL_BOOKS_COVER = "SELECT `coverPage` FROM udyog.books";

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ShowBookBo> getBooksCover() {

		return (ArrayList<ShowBookBo>) jdbcTemplate.query(GET_ALL_BOOKS_COVER, new RowMapper() {

			ArrayList<ShowBookBo> covers = new ArrayList<>();
			ShowBookBo bookBo;

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Blob img;
				img = rs.getBlob("coverPage");
				byte[] cover = img.getBytes(1, (int) img.length());
				bookBo = new ShowBookBo();

				bookBo.setCover(cover);
				covers.add(bookBo);
				return bookBo;
			}
		});
	}
}
