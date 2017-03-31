package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Dimension;
import com.bean.STBInventory;
import com.bean.SetTopBox;
import com.service.SetTopBoxService;
import com.util.DBConnection;


@WebServlet("/set-top-box")
public class SetTopBoxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
       
    
    public SetTopBoxController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Drop down menu selection
		String setTopBoxType = request.getParameter("setTopBoxType");
		
		
		
		// STB Dimensions 
		String boxLength = request.getParameter("boxLength");
		String boxBreadth = request.getParameter("boxBreadth");
		String boxWidth = request.getParameter("boxWidth");
	
		
		// Cost and Other Charges
		String price = request.getParameter("price");
		String installationCharge = request.getParameter("installationCharge");
		String upgradationCharge = request.getParameter("upgradationCharge");
		String discount = request.getParameter("discount");
	
		
		// Billing Type
		String billingType = request.getParameter("billingType");
	
		
		// Set Top Box Details
		String serialNumber = request.getParameter("serialNumber");
		String macId = request.getParameter("macId");
		String rcAssetId = request.getParameter("rcAssetId");
		String dAssetId = request.getParameter("dAssetId");
		
		// Set Top Box Status
		String setTopBoxStatus = request.getParameter("setTopBoxStatus");
		
		
		// Creating objects
		SetTopBox stb = new SetTopBox();
		
		stb.setStbType(setTopBoxType);
		stb.setPrice(Double.parseDouble(price));
		stb.setInstallationCharges(Double.parseDouble(installationCharge));
		stb.setUpgradingCharges(Double.parseDouble(upgradationCharge));
		stb.setDiscount(Double.parseDouble(discount));
		stb.setBillType(billingType);
		
		
		//stb.setRefundableDepositAmount(refundableDepositAmount); NOT THERE ON THIS PAGE
		Dimension dim = new Dimension();
		dim.setLength(Double.parseDouble(boxLength));
		dim.setWidth(Double.parseDouble(boxWidth));
		dim.setBreadth(Double.parseDouble(boxBreadth));
		stb.setDimension(dim);
		
		STBInventory inv = new STBInventory();
		inv.setSerialNumber(Long.parseLong(serialNumber));
		inv.setMacId(Long.parseLong(macId));
		inv.setRemoteControlAssetId(Long.parseLong(rcAssetId));
		inv.setDishAssetId(Long.parseLong(dAssetId));
		
		stb.setInventory(inv);
		
		SetTopBoxService service = new SetTopBoxService();
		

		try {
			// service will send data to DB
			Integer boxId = service.addBox(stb);
			logger.info("BoxId: " + boxId);
			response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage());
		}
		
		
	}

}
