package com.mailonline.AppDownloadStatistics.db;
import java.sql.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class dataAccessOracle {

	private static Connection _connecton;
	private static Statement _stmt;
	private static dataAccessOracle _instance;
	private static String _userName;
	private static String _password;
	private static String _server;
	private static Log logger = LogFactory.getLog(dataAccessOracle.class);
	private dataAccessOracle(String userName,String password,String server) throws ClassNotFoundException
	{
		_userName=userName;
		_password=password;
		_server=server;
		// TODO Auto-generated method stub
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    //
	    // or
	    // DriverManager.registerDriver
	    //        (new oracle.jdbc.driver.OracleDriver());

	        String url = "jdbc:oracle:thin:@//"+server;
	    //               jdbc:oracle:thin:@//host:port/service
	    // or
	    // String url = "jdbc:oracle:thin:@server.local:1521:prodsid";
	    //               jdbc:oracle:thin:@host:port:SID
	    //
	    //  SID  - System ID of the Oracle server database instance.
		//         By default, Oracle Database 10g Express Edition
		//         creates one database instance called XE.
		//         ex : String url = "jdbc:oracle:thin:@myhost:1521:xe";

		try {
			_connecton = DriverManager.getConnection(url,_userName,_password);

			_connecton.setAutoCommit(true);
			_connecton.setTransactionIsolation(_connecton.TRANSACTION_SERIALIZABLE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		}
	}
	public static dataAccessOracle creatDBA(String userName,String password,String server)
	{
		if(null==_connecton)
		{
			try {
				setInstance(new dataAccessOracle(userName,password,server));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				logger.error(e.toString());
			}
			return getInstance();
		}
		else
		{
			return _instance;
			
		}
	}
	public static Connection getConnecton() {
		return _connecton;
	}
	public void setConnecton(Connection connecton) {
		_connecton = connecton;
	}
	public static dataAccessOracle getInstance() {
		return _instance;
	}
	public static void setInstance(dataAccessOracle instance) {
		_instance = instance;
	}
	public static boolean closeConnection()
	{
		try {
			_connecton.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
	}

}
