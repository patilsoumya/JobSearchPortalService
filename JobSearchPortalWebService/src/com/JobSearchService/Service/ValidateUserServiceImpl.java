package com.JobSearchService.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.JobSearchService.Utilities.SQLConnection;
import com.jobSearch.VO.UserVO;

public class ValidateUserServiceImpl {

	public static UserVO validateUser(UserVO userVO) {
		Connection con;
		try {
			con = SQLConnection.getSQLConnection();

			Statement st = con.createStatement();
			String sql = "select * from USER";
			ResultSet rs = st.executeQuery(sql);
			String user = null;
			String pass = null;
			String emailId = userVO.getEmailId();
			String password = userVO.getPassword();
			userVO.setValid(false);
			while (rs.next()) {
				user = rs.getString(3);
				pass = rs.getString(4);
				if (user.equalsIgnoreCase(emailId) && pass.equalsIgnoreCase(password)) {
					userVO.setUserId(rs.getInt(1));
					userVO.setUserName(rs.getString(2));
					userVO.setEmailId(rs.getString(3));
					userVO.setPassword(rs.getString(4));
					userVO.setCity(rs.getString(5));
					userVO.setState(rs.getString(6));
					userVO.setCountry(rs.getString(7));
					userVO.setMobileNo(rs.getString(8));
					userVO.setLastModDate(rs.getString(9));
					userVO.setFailedLogins(rs.getInt(10));
					userVO.setGender(rs.getString(11));
					userVO.setValid(true);
					break;
				} else if (user.equalsIgnoreCase(emailId) && !pass.equalsIgnoreCase(password)) {
					String sqlUpdateQ = "UPDATE USER SET FAILED_LOGIN = " + (rs.getInt(10) + 1) + " WHERE EMAIL ='"
							+ emailId + "'";
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(sqlUpdateQ);
					int count = pst.executeUpdate();
					break;
				}
			}
			// Update data base with last valid login if success
			if (userVO.isValid()) {
				Date dNow = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
				String sqlUpdateQ = "UPDATE USER SET LAST_LOGIN_DT = '" + ft.format(dNow)
						+ "', FAILED_LOGIN = 0 WHERE USER_ID = '" + userVO.getUserId() + "'";
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(sqlUpdateQ);
				int count = pst.executeUpdate();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return userVO;
	}

	public static UserVO createUser(UserVO userVO) {
		Connection con;
		try {
			con = SQLConnection.getSQLConnection();

		String sqlUpdateQ = "INSERT INTO USER(user_name,email,password,city,state,country,mobile_no,"
				+ "LAST_LOGIN_DT,FAILED_LOGIN,GENDER) values('soums','soums.205@gmail.com',"
				+ "'soums','Dallas','Texas','USA','4697407289',"+null+",0, 'F');";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sqlUpdateQ);
		int count = pst.executeUpdate();
		
		}
		catch(Exception e){
			
		}
		return null;
	}

}
