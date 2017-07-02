package com.revature.bookshop.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.bookshop.model.User;
import com.revature.bookshop.util.ConnectionUtil;


public class UserDAO {
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

	/* New User Can Register */
	
	public void insertUser(User user) throws Exception {
        // 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
 
        // 2. Query
        String sql = "insert into book (id , name, username , password ,mobile_no , email_ID , active, role_ID) values (?,?,?,?,?,?,?,?)";
 
        // 3. Set the input and Query execute
        int rows = jdbcTemplate.update(sql, user.getId(), user.getName(), user.getUserName(), user.getPassword(), user.getMobileNumber(), user.getEmailID(), user.getActive(), user.getRoleId());
       LOGGER.info("No of rows inserted: " + rows);	
    }
	
	/* User must be able to Login */
	public void loginUser(User user) throws Exception {
		// 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		
        // 2. Query
        String sql = "update user set active = 'A' where (userName= ?) and (password = ?)";
		
        // 3. Set the input and Query execute
        int rows = jdbcTemplate.update(sql, user.getUserName(), user.getPassword());
        System.out.println("No of rows inserted: " + rows);
        if(rows == 1)
		System.out.println("Login Sucess");
	}
	
	/* User must be able to Reset Password */
	public void updatePassword(User user, String newPassword) throws Exception {
		// 1. Get the connection
		JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		
        // 2. Query
		String sql = "update user set password = ? where ((username = ?) and (active = 'A')) and password=?";
		
		// 3. Set the input and Query execute
		int rows = jdbcTemplate.update(sql, newPassword, user.getUserName(), user.getPassword());
		System.out.println("No of rows inserted: " + rows);
		if (rows == 1) 	
			System.out.println("Password Reset Sucess");
		else if (rows == 0) 
			System.out.println("Please Login to reset");
		else 
			System.out.println("Error Reset");
	}
}
