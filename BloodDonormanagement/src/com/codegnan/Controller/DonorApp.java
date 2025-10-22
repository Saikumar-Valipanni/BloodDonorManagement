package com.codegnan.Controller;

import com.codegnan.Exceptions.DonorNotFoundException;
import com.codegnan.Service.DonarServiceImpl;
import com.codegnan.Service.DonorService;
import com.codegnan.model.Donor;

public class DonorApp {

	public static void main(String[] args) {
		DonorService service=new DonarServiceImpl();
		service.addDonor(new Donor(1,"sai",21,"A"));
		service.addDonor(new Donor(2,"Ramya",25,"A+"));
		service.addDonor(new Donor(3,"Priya",18,"B-"));
		service.addDonor(new Donor(4,"Mani",28,"B-"));
		service.addDonor(new Donor(5,"Sneha",17,"Ab"));
         System.out.println("Doror Added");
		
		//getDonorByid
		System.out.println("Fetch Donor with id 2");
		try {
			Donor fetchDonor=service.getDonorById(2);
			System.out.println("Found : "+fetchDonor);
		}catch(DonorNotFoundException e) {
			e.printStackTrace();
		}
		//UPDATE EMPLOYEE
		System.out.println("Update donor with id 5");
		try {
			service.updateDonor(new Donor(5,"Saikumar",21,"A+"));
			System.out.println("Updated Sucessfully");
			
		}catch(DonorNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Delete donor with id 5");
		try {
			service.deleteDonor(5);
		}catch(DonorNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
