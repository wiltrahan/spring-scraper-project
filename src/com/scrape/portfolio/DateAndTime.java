package com.scrape.portfolio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndTime {
	
	
	public static void main(String args[]) throws ParseException {
		
		 String date_time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				.format(Calendar.getInstance()
				.getTime());
		 String[] timeSplit = date_time.split("\\s+");
		 String time = formatTime(timeSplit[1]);
		
		System.out.println("Date: " + timeSplit[0]);
		System.out.println("Time: " + time);
		
	}
	
	private static String formatTime(String time) throws ParseException {
		//old format
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    Date timeFormat = sdf.parse(time);
	    //new format
	    SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm aa");
	    //formatting the given time to new format with AM/PM
	    return sdf2.format(timeFormat);
		
	}
	
//	private static final String CURRENT_TIME = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
//																.format(Calendar.getInstance()
//																.getTime());

}


//private void stockInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
//
//    String date = request.getParameter("date");
//    List<Stock> stocks = QuerydbUtil.getStocks(date);
//
//    String[] timeSplit = date.split("\\s+");
//
//    String time = formatTime(timeSplit[1]);
//
//    request.setAttribute("STOCKS_LIST", stocks);
//    request.setAttribute("DATE", timeSplit[0]);
//    request.setAttribute("TIME", time);
//
//    RequestDispatcher dispatcher = request.getRequestDispatcher("stock-info.jsp");
//    dispatcher.forward(request, response);
//}
//
//private String formatTime(String time) throws ParseException {
//    //old format
//    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//    Date date3 = sdf.parse(time);
//    //new format
//    SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm aa");
//    //formatting the given time to new format with AM/PM
//    return sdf2.format(date3);
//}