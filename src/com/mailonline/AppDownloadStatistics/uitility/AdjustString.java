package com.mailonline.AppDownloadStatistics.uitility;

public class AdjustString {

	 public static String adjustString(String orignal)
	  {
		  if(orignal.length()==-1||orignal.length()==0)
		  {
			  return orignal;
		  }
		  if(orignal.length()>=2)
		  {
			  return orignal;
		  }
		  if(orignal.length()==1)
		  {
			  return "0"+orignal;
		  }
		  return "";
	  }
}
