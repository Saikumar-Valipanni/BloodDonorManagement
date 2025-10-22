package com.codegnan.DonorDao;


import java.util.List;

import com.codegnan.Exceptions.DonorNotFoundException;
//import com.codegnan.Exceptions.InvalidAgeException;
//import com.codegnan.Exceptions.InvalidBloodGroupException;
import com.codegnan.model.Donor;

public interface BloodDonorDao {
	public void save(Donor donor);

//	public void SortDonarsByAge(Donor donar);

	public List<Donor> findAll();

	public Donor FindDonarbyId(int id) throws DonorNotFoundException;

	public void FindDonarByBloodGroup(String Bloodgroup);

	public void updateDonarById(Donor donor) throws DonorNotFoundException;

	public void DeleteById(int id) throws DonorNotFoundException;
}

