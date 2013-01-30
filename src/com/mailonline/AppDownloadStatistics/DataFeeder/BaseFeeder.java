package com.mailonline.AppDownloadStatistics.DataFeeder;

import com.mailonline.AppDownloadStatistics.Interface.IFeeder;
import com.mailonline.AppDownloadStatistics.Interface.IRow;

public class BaseFeeder implements IFeeder {
	protected String sourceNmae;
	protected String categoryName;
	@Override
	public IRow Read() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String GetSourceName() {
		// TODO Auto-generated method stub
		return sourceNmae;
		
	}
	@Override
	public String GetCategoryName() {
		// TODO Auto-generated method stub
		return categoryName;
	}
	

}
