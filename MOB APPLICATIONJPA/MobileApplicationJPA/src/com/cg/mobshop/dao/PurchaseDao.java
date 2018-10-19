package com.cg.mobshop.dao;

import java.util.ArrayList;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public interface PurchaseDao {

	public int addPurchaseDetails(PurchaseDetails pr);
	public ArrayList<Mobile> getMobileList();
	public ArrayList<Mobile> getMobileList(int min,int max);
	public Mobile updateMobileDetails(Mobile mob);
	public boolean validateName(String name) throws PurchaseException;
	public boolean validatePhoneNo(String mob);
	public boolean validateEmail(String email);
	public PurchaseDetails ValidateDetails(PurchaseDetails pd) throws PurchaseException;
}
