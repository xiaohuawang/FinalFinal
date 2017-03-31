package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.SampleBean;
import com.dao.interfaces.ISampleDao;
import com.util.DBConnection;

public class SampleDao extends GenericDao implements ISampleDao {
	
	@Override
	public Integer addSample(SampleBean sample) throws SQLException, ClassNotFoundException {
		int sampleId = -1;
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		ps = con.prepareStatement("insert into Sample values(Sample_Sequence.nextval, ?, ?)");
		ps.setString(1, sample.getSampleName());
		
		// USE THIS TO CONVERT DATES FROM java.util.Date TO java.sql.Date
		java.sql.Date sqlDate = this.convertDate(sample.getSampleDate());
		
		ps.setDate(2, sqlDate);

		// Execute SQL statement
		ps.executeUpdate();
		
		// This will retrieve the id that was just generated
		String query = null;
		query = "select Sample_Sequence.currval from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			sampleId = rs.getInt(1);
			logger.info("SampleID: " + sampleId);
		}
		
		return sampleId;
	}

	@Override
	public SampleBean getSampleByName(String sampleName) throws SQLException, ClassNotFoundException {	
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		ps = con.prepareStatement("select * from Sample where sampleName = ?");
		ps.setString(1, sampleName);

		// Execute SQL statement
		rs = ps.executeQuery();
		
		if(rs.next()) {
			SampleBean sample = new SampleBean();
			sample.setSampleId(rs.getInt("sampleId"));
			sample.setSampleName(rs.getString("sampleName"));
			
			return sample;
		}
		
		return null;
	}

	@Override
	public List<SampleBean> getAllSamples() throws SQLException, ClassNotFoundException {
		List<SampleBean> samples = new ArrayList<>();
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		ps = con.prepareStatement("select * from Sample");

		// Execute SQL statement
		rs = ps.executeQuery();
		
		while(rs.next()) {
			SampleBean sample = new SampleBean();
			sample.setSampleId(rs.getInt("sampleId"));
			sample.setSampleName(rs.getString("sampleName"));
			
			samples.add(sample);
		}
		
		return samples;
	}
}
