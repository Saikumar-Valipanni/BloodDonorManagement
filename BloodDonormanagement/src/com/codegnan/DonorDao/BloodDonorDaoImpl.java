package com.codegnan.DonorDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.Exceptions.DonorNotFoundException;
//import com.codegnan.Exceptions.InvalidAgeException;
//import com.codegnan.Exceptions.InvalidBloodGroupException;
import com.codegnan.Util.DBConnectionUtil;
import com.codegnan.model.Donor;

public class BloodDonorDaoImpl implements BloodDonorDao {

	@Override
	public void save(Donor donor){
		String sqlQuerry="insert into donor(id,name,age,BloodGroup) values(?,?,?,?)";
		try(Connection connection=DBConnectionUtil.getconnection();
				PreparedStatement pst=connection.prepareCall(sqlQuerry)){
			pst.setInt(1, donor.getId());
			pst.setString(2,donor.getName());
			pst.setInt(3, donor.getAge());
			pst.setString(4, donor.getBloodGroup());
			pst.executeUpdate();
			System.out.println("Donor Saved :"+donor);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Save failed"+e.getMessage());
		}
		
	}

	
	

	@Override
	public List<Donor> findAll() {
		List<Donor>list=new ArrayList<>();
		String sql="select * from donor";
		try(Connection con=DBConnectionUtil.getconnection();
			PreparedStatement pst=con.prepareStatement(sql)){
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Donor(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4)
						));	
			}
			
			
		}catch(SQLException e) {
			System.out.println("Fetch all records failed :"+e.getMessage());
		}
		return list;
	}

	@Override
	public Donor FindDonarbyId(int id) throws DonorNotFoundException {
		String sql="select * from donor where id=?";
		try(Connection con=DBConnectionUtil.getconnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return new Donor(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4)
						);
			}else {
				throw new DonorNotFoundException("Id Not found : "+id);
			}
		}catch(SQLException e) {
			throw new DonorNotFoundException("Database Error"+e.getMessage());
		}
 
	}

	@Override
	public void FindDonarByBloodGroup(String Bloodgroup){
		String sql="select * from donor where bloodgroup=?";
		try(Connection con=DBConnectionUtil.getconnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setString(1, Bloodgroup);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				 new Donor(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
 
	}
		


	@Override
	public void updateDonarById(Donor donor) throws DonorNotFoundException {
		String sql="Update donor set name=?,age=?,bloodgroup=?where id=?";
		try(Connection con=DBConnectionUtil.getconnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setString(1, donor.getName());
			pst.setInt(2,donor.getAge());
			pst.setString(3,donor.getBloodGroup());
			pst.setInt(4, donor.getId());
			int rowsEffected=pst.executeUpdate();
			if(rowsEffected==0) {
				throw new DonorNotFoundException("Id Not Found for Updte :"+donor.getId());
			}else {
				System.out.println("updated"+donor);
			}
			
		}catch(SQLException e) {
			System.out.println("Updation Failed"+e.getMessage());
		}
	}
	

	@Override
	public void DeleteById(int id) throws DonorNotFoundException {
		String sql="delete from donor where id=?";
		try(Connection con=DBConnectionUtil.getconnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setInt(1, id);
			int rowsEffected=pst.executeUpdate();
			if(rowsEffected==0) {
				throw new DonorNotFoundException("Id Not Found for Deletion :"+id);
			}else {
				System.out.println("Deleted id"+id);
			}
			
		}catch(SQLException e) {
			System.out.println("Deletion Failed"+e.getMessage());
		}
		
	}

}
