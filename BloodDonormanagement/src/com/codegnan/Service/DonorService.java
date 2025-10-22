package com.codegnan.Service;

import java.util.List;
import com.codegnan.Exceptions.DonorNotFoundException;
import com.codegnan.model.Donor;

public interface DonorService {
     void addDonor(Donor donor);
     List<Donor> findAll();

 	Donor getDonorById(int id) throws DonorNotFoundException;

 	void updateDonor(Donor donor) throws DonorNotFoundException;

 	void deleteDonor(int id) throws DonorNotFoundException;
}
