package com.mail.security.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import com.mail.security.beans.MailUserDetails;

@Repository
public class UserDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String role;
	private static Logger LOGGER = Logger.getLogger(UserDetailsDao.class);

	private final String USER_DETAILS = "select username, password, role_name from users where username=?";

	public UserDetails getUserDetails(String username) {

		GrantedAuthority authority = new GrantedAuthority() {
			private static final long serialVersionUID = -5140801952377636840L;

			@Override
			public String getAuthority() {
				return role;
			}
		};

		try {
			return jdbcTemplate.queryForObject(USER_DETAILS, new RowMapper<MailUserDetails>() {

				@Override
				public MailUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
					List<GrantedAuthority> authorities = null;
					authorities = new ArrayList<GrantedAuthority>();
					MailUserDetails details = new MailUserDetails();
					details.setUsername(rs.getString("username"));
					details.setPassword(rs.getString("password"));

					role = rs.getString("role_name");

					authorities.add(authority);
					details.setAuthorities(authorities);

					if (LOGGER.isDebugEnabled())
						LOGGER.debug("Returning to Authentication Manager");
					return details;
				}
			}, username);
		} catch (Exception e) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(e);
			throw new BadCredentialsException("Your usermane or password is incorrect");
		}
	}
}
