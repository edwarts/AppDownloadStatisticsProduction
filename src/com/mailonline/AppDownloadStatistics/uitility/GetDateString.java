package com.mailonline.AppDownloadStatistics.uitility;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetDateString {
	public static String GetDateString()
	{
		//For last day
	int y,m,d,h,mi,s;
		
		Calendar cal=GregorianCalendar.getInstance();
		
		y=cal.get(Calendar.YEAR);   
		m=cal.get(Calendar.MONTH)+1;   
		d=cal.get(Calendar.DATE);   
		h=cal.get(Calendar.HOUR_OF_DAY);   
		mi=cal.get(Calendar.MINUTE);   
		s=cal.get(Calendar.SECOND);
		//System.out.println("Before roll back:"+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");
		
		//minus day first
		if((d-1)==0)
		{

			System.out.println("D"+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");
			if(0==m-1)
			{
				y=y-1;
				m=12;
				d=31;
				System.out.println("a"+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");

			}
			else
			{
				m=m-1;
				if((m==1||m==3||m==5||m==7||m==8||m==10||m==12))
				{
					d=31;
					System.out.println("b"+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");
					
				}
				else
				{
					if(m!=2)
					{
						d=30;
					}
					else 
					{
						boolean b=((GregorianCalendar)cal).isLeapYear(y);
						if(b)
						{
							d=29;
						}
						else
						{
							d=28;
						}
					}
					
				}
			}
		}
		else
		{
			d=d-1;
		}
		
		//System.out.println("After roll back"+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");


		return y+"-"+m+"-"+d;
		
		
	}
	public static String GetDateString(int status)
	{
		int y,m,d,h,mi,s;
		
		Calendar cal=GregorianCalendar.getInstance();
		y=cal.get(Calendar.YEAR);   
		m=cal.get(Calendar.MONTH)+1;   
		d=cal.get(Calendar.DATE);   
		h=cal.get(Calendar.HOUR_OF_DAY);   
		mi=cal.get(Calendar.MINUTE);   
		s=cal.get(Calendar.SECOND);
		
		
		
		System.out.println(""+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");

		switch(m)
		{
		case 1:return d+"-"+"JAN"+"-"+y;
		case 2:return d+"-"+"FEB"+"-"+y;
		case 3:return d+"-"+"MAR"+"-"+y;
		case 4:return d+"-"+"APR"+"-"+y;
		case 5:return d+"-"+"MAY"+"-"+y;
		case 6:return d+"-"+"JUNE"+"-"+y;
		case 7:return d+"-"+"JULY"+"-"+y;
		case 8:return d+"-"+"AUG"+"-"+y;
		case 9:return d+"-"+"SEP"+"-"+y;
		case 10:return d+"-"+"OCT"+"-"+y;
		case 11:return d+"-"+"NOV"+"-"+y;
		case 12:return d+"-"+"DEC"+"-"+y;
		
		
		}

		return "";
		
	}
	@SuppressWarnings("deprecation")
	public static String GetDateString(Date date_to_be_change)
	{
		int y,m,d,h,mi,s;
		return date_to_be_change.toGMTString();
		
	/*	
		System.out.println(""+y+" "+m+" "+d+" "+h+" "+mi+" "+s+" ");

		switch(m)
		{
		case 1:return d+"-"+"JAN"+"-"+y;
		case 2:return d+"-"+"FEB"+"-"+y;
		case 3:return d+"-"+"MAR"+"-"+y;
		case 4:return d+"-"+"APR"+"-"+y;
		case 5:return d+"-"+"MAY"+"-"+y;
		case 6:return d+"-"+"JUNE"+"-"+y;
		case 7:return d+"-"+"JULY"+"-"+y;
		case 8:return d+"-"+"AUG"+"-"+y;
		case 9:return d+"-"+"SEP"+"-"+y;
		case 10:return d+"-"+"OCT"+"-"+y;
		case 11:return d+"-"+"NOV"+"-"+y;
		case 12:return d+"-"+"DEC"+"-"+y;
		
		
		}

		return "";*/
		
	}

}
