package com.mailonline.AppDownloadStatistics.Row;

public class SingleRecordRow {
	String Datetime;
	String ItemCategory;
	String Source;
	double TotalDownload;
	double DailyDownload;
	double Region;
	public SingleRecordRow()
	{
		
	}
	public String getDatetime() {
		return Datetime;
	}
	public void setDatetime(String datetime) {
		Datetime = datetime;
	}
	public String getItemCategory() {
		return ItemCategory;
	}
	public void setItemCategory(String itemCategory) {
		ItemCategory = itemCategory;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public double getTotalDownload() {
		return TotalDownload;
	}
	public void setTotalDownload(double totalDownload) {
		TotalDownload = totalDownload;
	}
	public double getDailyDownload() {
		return DailyDownload;
	}
	public void setDailyDownload(double dailyDownload) {
		DailyDownload = dailyDownload;
	}
	public double getRegion() {
		return Region;
	}
	public void setRegion(double region) {
		Region = region;
	}
	

}
