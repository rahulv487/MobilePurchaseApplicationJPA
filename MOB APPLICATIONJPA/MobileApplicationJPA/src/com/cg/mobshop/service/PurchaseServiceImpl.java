package com.cg.mobshop.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.mobshop.dao.PurchaseDao;
import com.cg.mobshop.dao.PurchaseDaoImpl;
import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;




public class PurchaseServiceImpl implements PurchaseService {
	PurchaseDao dao;
	public PurchaseServiceImpl() throws PurchaseException{
		dao = new PurchaseDaoImpl();
	}
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) {
		int pi = dao.addPurchaseDetails(pr);
		return pi;
	}

	@Override
	public ArrayList<Mobile> getMobileList() {
		return dao.getMobileList();
	}

	@Override
	public ArrayList<Mobile> getMobileList(int min, int max){
		return dao.getMobileList(min, max);
	}

	@Override
	public Mobile updateMobileDetails(Mobile mob) {
		return dao.updateMobileDetails(mob);
	}
	@Override
	public boolean validateName(String name) throws PurchaseException {
		// TODO Auto-generated method stub
		return dao.validateName(name);
	}
	@Override
	public boolean validatePhoneNo(String mob) {
		// TODO Auto-generated method stub
		return dao.validatePhoneNo(mob);
	}
	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return dao.validateEmail(email);
	}
	@Override
	public PurchaseDetails ValidateDetails(PurchaseDetails pd)
			throws PurchaseException {
		// TODO Auto-generated method stub
		return dao.ValidateDetails(pd);
	}

}
