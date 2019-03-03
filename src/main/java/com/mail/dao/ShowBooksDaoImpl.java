package com.mail.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.mail.bo.BookBo;

@Repository
public class ShowBooksDaoImpl implements ShowBooksDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final String GET_ALL_BOOKS = "SELECT bo.coverPage, bo.title, bo.publisher, bo.edition FROM BookBo bo";
	private static final String GET_BOOKS = "SELECT author, coverPage, publisher, title, edition FROM books;";

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<BookBo> getBooksCover() {
		ArrayList<BookBo> bookBos;
		// DetachedCriteria criteria = DetachedCriteria.forClass(BookBo.class);
		// List<Object> list =
		// hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(GET_ALL_BOOKS).list().;
		// return bookBos;

		return (ArrayList<BookBo>) jdbcTemplate.query(GET_BOOKS, new RowMapper() {
			ArrayList<BookBo> covers = new ArrayList<>();

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookBo bookBo = new BookBo();

				Blob img = rs.getBlob("coverPage");
				byte[] cover = img.getBytes(1, (int) img.length());
				bookBo.setCoverPage(cover);
				bookBo.setTitle(rs.getString("title"));
				bookBo.setPublisher(rs.getString("publisher"));
				bookBo.setAuthor(rs.getString("author"));
				bookBo.setEdition(rs.getString("edition"));
				covers.add(bookBo);
				return bookBo;
			}
		});
	}
}
