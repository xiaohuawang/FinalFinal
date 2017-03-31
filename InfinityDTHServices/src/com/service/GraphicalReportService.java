/**
 * 
 */
package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Graph;
import com.dao.GraphicalReportDao;

/**
 * @author 1381345
 *
 */
public class GraphicalReportService {
	GraphicalReportDao dao = new GraphicalReportDao ();

	public ArrayList<Graph> getData(String type, String target) throws SQLException, ClassNotFoundException  
	{
		return dao.getData(type, target);
	}
}
