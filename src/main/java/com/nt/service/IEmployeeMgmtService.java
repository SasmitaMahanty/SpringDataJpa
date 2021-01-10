package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public int registerEmployee(EmployeeDTO dto);
	public int[] registerAllEmps(List<EmployeeDTO> listDto);
	public String employeeExistance(int id);
	public long countEmployee();
	public Optional<EmployeeDTO> getEmpById(int id);
	public void removeEmployee(int id);
	public List<EmployeeDTO> getEmpsByIds(List<Integer> ids);
	public Iterable<EmployeeDTO> getAllEmps();
	public String removeEmpsByGivenEntity(List<EmployeeDTO> listDtos);

}
