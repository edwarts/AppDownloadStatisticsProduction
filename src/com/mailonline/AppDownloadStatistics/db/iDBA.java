package com.mailonline.AppDownloadStatistics.db;
import java.sql.*;

public interface iDBA {
	public iDBA craetInstance();
	public Connection creatConnection();
	public ResultSet getResutlSetBySQL(String sql);
	public Object getObjectByColumnNameSingle(String colunmName);
	public ResultSet getAll();

}
