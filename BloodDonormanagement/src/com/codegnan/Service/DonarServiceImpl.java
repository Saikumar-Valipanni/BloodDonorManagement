package com.codegnan.Service;

import java.util.List;

import com.codegnan.DonorDao.BloodDonorDao;
import com.codegnan.DonorDao.BloodDonorDaoImpl;
import com.codegnan.Exceptions.DonorNotFoundException;
import com.codegnan.model.Donor;

public class DonarServiceImpl implements DonorService {
	BloodDonorDao dao = new BloodDonorDaoImpl();

	@Override
	public void addDonor(Donor donor) {
		dao.save(donor);
	}

	@Override
	public List<Donor> findAll() {

		return dao.findAll();
	}

	@Override
	public Donor getDonorById(int id) throws DonorNotFoundException {

		return dao.FindDonarbyId(id);
	}

	@Override
	public void updateDonor(Donor donor) throws DonorNotFoundException {
		dao.updateDonarById(donor);

	}

	@Override
	public void deleteDonor(int id) throws DonorNotFoundException {
		dao.DeleteById(id);

	}

}
