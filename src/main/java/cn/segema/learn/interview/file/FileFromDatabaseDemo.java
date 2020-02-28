package cn.segema.learn.interview.file;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FileFromDatabaseDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/ssr3?characterEncoding=utf-8";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement statement = null;
		ResultSet resultSet = null;
		InputStream inputStream = null;
		try {
			statement = connection.createStatement();
			String sql = "select p.photo from photo p where id = 1";
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			inputStream = resultSet.getBinaryStream("photo");
			FileUtil.readBlob(inputStream, "G:\\temp\\photo2.png");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (statement != null)
						if (statement != null)
							try {
								statement.close();
							} catch (SQLException e) {
								e.printStackTrace();
							} finally {
								if (connection != null)
									try {
										connection.close();
									} catch (SQLException e) {
										e.printStackTrace();
									}
							}
				}
			}
		}
	}
}