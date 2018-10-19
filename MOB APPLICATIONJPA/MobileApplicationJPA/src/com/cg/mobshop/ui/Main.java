package com.cg.mobshop.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;
import com.cg.mobshop.service.PurchaseService;
import com.cg.mobshop.service.PurchaseServiceImpl;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws PurchaseException {
		
		
		Scanner sc = new Scanner(System.in);
		PurchaseService service = new PurchaseServiceImpl();
		
		int ch=0;
		
		do{
			
			System.out.println("Enter your choice...\n1.Add customer details\n2.Display Mobile List\n3.Display Mobiles in range\n4.Update Mobile Details\n5.Exit");
			ch = sc.nextInt();
			switch(ch){
			
			case 1:
		
				System.out.println("Enter Customer Name:");
				String name = sc.next();
				System.out.println("Enter Phone No:");
				String  phn = sc.next();
				System.out.println("Enter mailid:");
				String mail = sc.next();
				System.out.println("Enter Mobile id:");
				int mobid = sc.nextInt();
		
				PurchaseDetails pi = new PurchaseDetails();
		
				pi.setCustName(name);
				pi.setPhoneNo(phn);
				pi.setMailId(mail);
				pi.setMobileId(mobid);
				int pd = service.addPurchaseDetails(pi);
				System.out.println("Record added..." + pd);
				break;
		
			case 2:
				ArrayList<Mobile> list = service.getMobileList();
				if(list.size()==0){
					System.err.println("No records found");
				}
				else
				{
					for(Mobile mob : list){
						System.out.println("Mobile ID: "+mob.getMobileId()+" ");
						System.out.println("Name: "+mob.getName()+" ");
						System.out.println("Price: "+mob.getPrice()+" ");
						System.out.println("Quantity: "+mob.getQuantity()+" ");
						System.out.println("==================================================================================================");
					}
				}
				break;
		
			case 3:
			
				System.out.println("Enter Minimum Price: ");
				int min = sc.nextInt();
				System.out.println("Enter Maximum Price: ");
				int max = sc.nextInt();
			
			
			
				ArrayList<Mobile> list1 = service.getMobileList(min, max);
				if(list1.size()==0){
					System.err.println("No records found");
				}
				else
				{
					for(Mobile mob1 : list1){
						System.out.println("Mobile ID: "+mob1.getMobileId()+" ");
						System.out.println("Name: "+mob1.getName()+" ");
						System.out.println("Price: "+mob1.getPrice()+" ");
						System.out.println("Quantity: "+mob1.getQuantity()+" ");
						System.out.println("==================================================================================================");
					}
				}
				break;
			
			case 4:
				System.out.println("Enter MobileId: ");
				int mid = sc.nextInt();
				System.out.println("Enter Price");
				int pr = sc.nextInt();
				System.out.println("Enter Quantity");
				int qty = sc.nextInt();
				Mobile mob = new Mobile();
				mob.setMobileId(mid);
				mob.setPrice(pr);
				mob.setQuantity(qty);
				mob = service.updateMobileDetails(mob);
				if(mob!=null)
					System.out.println("Details updated Successfully");
				break;
			
			}
	
		}while(ch!=5);
		System.out.println(" Execution Ended !!! ");
	}
}
