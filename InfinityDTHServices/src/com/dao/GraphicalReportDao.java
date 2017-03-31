package com.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Graph;
import com.controller.LoginController;
import com.util.DBConnection;

public class GraphicalReportDao extends GenericDao 
{
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	public ArrayList<Graph> getData(String type, String target)
	{
		ArrayList<Graph> data = new ArrayList<Graph>();
		
		Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -1);    
	    prevYear.get(Calendar.YEAR);
		long mills = prevYear.getTimeInMillis();
		Date date = new Date(mills);
		
		
		con = DBConnection.getConnection();	
		StringBuilder sb = new StringBuilder();
		if (type.equals("bar"))
		{
			sb.append("select to_char(creationdate, 'YYYY-MM') as names, count(*) as counts ");
			sb.append("from "+ target +" where creationdate > to_date(?, 'yyyy-mm-dd') ");
			sb.append("group by to_char(creationdate, 'YYYY-MM')");
		}
		else
		{
			if (target.equals("operator"))
			{
				sb.append("select to_char(shifttimeend, 'HH:SS') as names, count(*) as counts "
						+ "from operator group by to_char(shifttimeend, 'HH:SS')");
			}
			else if (target.equals("retailer"))
			{
				sb.append("select state as names, count(retailerid) as counts "
						+ "from retailer, address where address.addressId = retailer.addressid group by state");
			}
			else
			{
				sb.append("select name as names, count(customerid) as counts "
						+ "from retailer r, customer c where c.retailerid = r.retailerid group by name");
			}
		}

		try 
		{
			ps = con.prepareStatement(sb.toString());	
			if (type.equals("bar"))	{ps.setString(1, date.toString());}
			rs = ps.executeQuery();	
			
			while(rs.next()) 
			{
				Graph point = new Graph();
				point.setName(rs.getString("names"));
				point.setCount(rs.getInt("counts"));
				data.add(point);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		DBConnection.CloseConnection(con);

		if(data.size() > 0) 
		{
			return data;
		}
		
		return null;
	}

}
