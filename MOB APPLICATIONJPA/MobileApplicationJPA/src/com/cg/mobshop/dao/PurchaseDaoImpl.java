package com.cg.mobshop.dao;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public class PurchaseDaoImpl implements PurchaseDao{
	EntityManager manager;
	public PurchaseDaoImpl() {
		// TODO Auto-generated constructor stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		manager = emf.createEntityManager();
	}
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) {
		manager.getTransaction().begin();
		manager.persist(pr);
		manager.getTransaction().commit();
		return pr.getPurchaseId();
	}

	@Override
	public ArrayList<Mobile> getMobileList() {
	ArrayList<Mobile> list = new ArrayList<>();
	TypedQuery<Mobile> qry = manager.createQuery("select p from Mobile p ", Mobile.class);
	list = (ArrayList<Mobile>) qry.getResultList();
	
	return list;
	}

	@Override
	public ArrayList<Mobile> getMobileList(int min, int max) {
		TypedQuery<Mobile> qry = manager.createQuery("select p from Mobile p where p.price between :lower and :upper", Mobile.class);
		qry.setParameter("lower", min);
		qry.setParameter("upper", max);
		ArrayList<Mobile> list = (ArrayList<Mobile>) qry.getResultList();
		return list;
   }

	@Override
	public Mobile updateMobileDetails(Mobile mob) {
		manager.getTransaction().begin();
		Mobile mobile = manager.find(Mobile.class, mob.getMobileId());
		mobile.setPrice(mob.getPrice());
		mobile.setQuantity(mob.getQuantity());
		manager.merge(mobile);
		manager.getTransaction().commit();
		return mob;
	}
	@Override
	public boolean validateName(String name) throws PurchaseException {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[A-Z][a-z]{2,12}");
		Matcher mat = pat.matcher(name);
		return mat.matches();
	}
	@Override
	public boolean validatePhoneNo(String mob) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[0-9]{10}");
		Matcher mat = pat.matcher(mob);
		return mat.matches();
	}
	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[A-Za-z0-9]{2,15}@capgemini.com");
		Matcher mat = pat.matcher(email);
		return mat.matches();
	}
	@Override
	public PurchaseDetails ValidateDetails(PurchaseDetails pd)
			throws PurchaseException {
		// TODO Auto-generated method stub
		if(validateEmail(pd.getMailId()) &&
				 validateName(pd.getCustName()) && 
						 validatePhoneNo(pd.getPhoneNo()) )
		return pd;
		else
	return null;
	}
}
