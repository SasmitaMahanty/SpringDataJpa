package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private Integer eno;
	private String ename;
	private String addrs;
	private Float salary;
	
	public EmployeeDTO(Integer eno) {
		this.eno = eno;
	}

	public EmployeeDTO(String ename, String addrs, Float salary) {
		this.ename = ename;
		this.addrs = addrs;
		this.salary = salary;
	}
	
	public EmployeeDTO(Integer eno, String ename, String addrs, Float salary) {
		this.eno = eno;
		this.ename = ename;
		this.addrs = addrs;
		this.salary = salary;
	}
	

	public EmployeeDTO() {
		
	}

	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", ename=" + ename + ", addrs=" + addrs + ", salary=" + salary + "]";
	}
	
	

}
