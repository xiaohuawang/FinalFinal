package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Dimension;
import com.bean.SetTopBox;
import com.dao.interfaces.ISetTopBoxDao;
import com.util.DBConnection;

public class SetTopBoxDao implements ISetTopBoxDao{
	
	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected Statement stmt = null;
	protected String query = null;
	
	
	
	@Override
	public Integer addBox(SetTopBox box) throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
		final Logger logger = LogManager.getLogger(DBConnection.class);
		

	//	String sql= "INSERT INTO SetTopBox(SETTOPBOXID,SETTOPBOXTYPE,BOXLENGTH,BOXBREADTH,BOXWIDTH,PRICE, INSTALLATIONCHARGE,UPGRADATIONCHARGE, DISCOUNT, BILLINGTYPE, REFUNDABLEDEPOSITAMOUNT ) VALUES(setTopBox_Sequences.nextval, ?, ?, ?, ?, ?,?,?,?, ?, ?)";
		
		
		String sql= "INSERT INTO SetTopBox(SETTOPBOXID,SETTOPBOXTYPE, BOXLENGTH, BOXBREADTH, BOXWIDTH, PRICE, INSTALLATIONCHARGE, UPGRADATIONCHARGE, DISCOUNT, BILLINGTYPE, SERIALNUMBER, MACID, RCASSETID, DASSETID) VALUES(setTopBox_Sequences.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);
		
		String boxtype_pulled = box.getStbType();
		
		if (boxtype_pulled == "1")
		{
			boxtype_pulled = "Standard";
		}else if (boxtype_pulled == "2")
		{
			boxtype_pulled = "HD";
		}else if (boxtype_pulled == "3")
		{
			boxtype_pulled = "HD+";
		}else {boxtype_pulled = "IPTV";}
		
		String bill_type_pulled = box.getBillType();
		
		if (bill_type_pulled == "1")
		{
			bill_type_pulled = "Prepaid";
		}
		else 
		{
			bill_type_pulled = "Post Paid";
		}
		
		
		System.out.println("The box type is here " +boxtype_pulled);
		
		ps.setString(1, boxtype_pulled);										// type
		ps.setInt(2, (int) box.getDimension().getLength());						// box length		
		ps.setInt(3, (int) box.getDimension().getBreadth());					// box breadth
		ps.setInt(4, (int) box.getDimension().getWidth());						// box width
		ps.setDouble(5,  box.getPrice());										// price
		ps.setDouble(6, box.getInstallationCharges());							// INSTALLATIONCHARGE
		ps.setDouble(7, box.getUpgradingCharges());								// UPGRADATIONCHARGE
		ps.setDouble(8, box.getDiscount());										// DISCOUNT
		ps.setString(9, bill_type_pulled);										// BILLINGTYPE
		//ps.setDouble(10, box.getRefundableDepositAmount());					// REFUNDABLEDEPOSITAMOUNT
		ps.setInt(10, (int) box.getInventory().getSerialNumber());				// SERIALNUMBER
		ps.setInt(11, (int) box.getInventory().getMacId());						// MACID
		ps.setInt(12, (int) box.getInventory().getRemoteControlAssetId());		// RCASSETID
		ps.setInt(13, (int) box.getInventory().getDishAssetId());				// DASSETID
	
		
		
		
		
		

		logger.info("before execute query");
		
		ps.executeUpdate();
		
		
		
		query = "select setTopBox_Sequences.currval from dual";
		System.out.println(query);
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
	

		if(rs.next()) {
			Integer boxId = rs.getInt(1);
			return boxId;
		}
		
		return -1;
		
		
		
		
		
}

	@Override
	public SetTopBox getSetTopBox(String box) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SetTopBox> getAllSamples() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}