package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Address;

@Mapper
public interface AddressMapper {

	public void add(Address address);
	public void delete(int id);
	public void update(Address address);
	public Address Findbyid(int id);
	public void DeleteAllById(List<Address> address);
	
}
