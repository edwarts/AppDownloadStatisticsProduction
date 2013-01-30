package com.mailonline.AppDownloadStatistics.Interface;

public interface IFeeder {
	IRow Read();
	String GetSourceName();
	String GetCategoryName();

}
