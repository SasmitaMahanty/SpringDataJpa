package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public int registerEmployee(EmployeeDTO dto) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(dto, emp);
		Employee entity=repo.save(emp);
		
		return entity.getEno();
	}

	@Override
	public int[] registerAllEmps(List<EmployeeDTO> listDto) {
		List<Employee> listEntities=new ArrayList();
		listDto.forEach(dto->{
			Employee emp=new Employee();
			BeanUtils.copyProperties(dto, emp);
			listEntities.add(emp);
		});
		List<Employee> listEn=(List<Employee>) repo.saveAll(listEntities);
		int[] id=new int[listEn.size()] ;
		for(int i=0;i<listEn.size();++i) {
			id[i]=listEn.get(i).getEno();
			
		}
		
		return id;
	}

	@Override
	public String employeeExistance(int id) {
		boolean flag=false;
		flag=repo.existsById(id);
		if(flag)
			return "Employee exist .";
		else
		return "employee not exist in the db table .";
	}

	@Override
	public long countEmployee() {
		int count=(int) repo.count();
		return count;
	}

	@Override
	public Optional<EmployeeDTO> getEmpById(int id) {
		Optional<Employee> emp=repo.findById(id);
		Optional optDTO=Optional.empty();
		if(emp.isPresent()) {
			Employee emp1=emp.get();
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(emp1, dto);
			optDTO=Optional.of(dto);
		}
		 
		return optDTO;
	}

	@Override
	public void removeEmployee(int id) {
		
		
		repo.deleteById(id);
	}

	@Override
	public List<EmployeeDTO> getEmpsByIds(List<Integer> ids) {
		List<Employee> listEntities=(List<Employee>) repo.findAllById(ids);
		List<EmployeeDTO> listDtos=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDtos.add(dto);
		});
		return listDtos;
	}

	@Override
	public Iterable<EmployeeDTO> getAllEmps() {
		Iterable<Employee> listEmps=repo.findAll();
		Iterable<EmployeeDTO> listDtos=new ArrayList<EmployeeDTO>();
		listEmps.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<EmployeeDTO>) listDtos).add(dto);
		});
		return listDtos;
	}

	@Override
	public String removeEmpsByGivenEntity(List<EmployeeDTO> listDtos) {
		List<Employee> listEntities=new  ArrayList();
		listDtos.forEach(dto->{
			Employee emp=new Employee();
			BeanUtils.copyProperties(dto, emp);
			listEntities.add(emp);
		});
		repo.deleteAll(listEntities);
		return "multiple recorded are deleted .";
	}

}
