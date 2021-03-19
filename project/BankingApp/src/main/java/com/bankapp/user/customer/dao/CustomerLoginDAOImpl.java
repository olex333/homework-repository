package com.bankapp.user.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bankapp.dao.dbutil.PostgresConnection;
import com.bankapp.exception.BusinessException;
import com.bankapp.main.Main;
import com.bankapp.model.User;


public class CustomerLoginDAOImpl implements CustomerLoginDao {
	private static Logger Log = Logger.getLogger(CustomerLoginDAOImpl.class);


	@Override
	public User LogIn(String username, String password) throws BusinessException {
		User user = null;
	
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select username, passwords from bank_schema.user_customer where username=? ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);

			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new User();
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("passwords"));
			}
			} catch (ClassNotFoundException | SQLException e) {
				Log.info(e);
				Log.warn("Internal Error");
				throw new BusinessException("Internal Error");
			}
		Log.info(user);
			
			
		return user;
	}

}
