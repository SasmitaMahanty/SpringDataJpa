package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class DataProj1UsingCrudRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IEmployeeMgmtService service=null;
		ctx=SpringApplication.run(DataProj1UsingCrudRepoApplication.class, args);
		service=ctx.getBean("empService", EmployeeMgmtServiceImpl.class);
		//EmployeeDTO dto=new EmployeeDTO("saras", "Hyd", 50000.0f);
		/*
		 * EmployeeDTO dto=new EmployeeDTO(42, "suresh", "asam", 600000.0f);
		 * System.out.println("Employee registered with id :"+service.registerEmployee(
		 * dto));
		 */
		
		/*
		 * List<EmployeeDTO> listEmps=List.of(new EmployeeDTO("somesh", "hyd",
		 * 350000.0f), new EmployeeDTO("purbesh", "bihar", 900000.0f), new
		 * EmployeeDTO("akash", "banglore", 7000000.0f));
		 * System.out.println(Arrays.toString(service.registerAllEmps(listEmps)));
		 */
		/* System.out.println(service.employeeExistance(67)); */
		/* System.out.println("Employees count :"+service.countEmployee()); */
		
		/*
		 * Optional<EmployeeDTO> optDTO=service.getEmpById(41); if(optDTO.isPresent())
		 * System.out.println(optDTO.get()); else {
		 * System.out.println("Employee not found ."); }
		 */
		/* service.removeEmployee(42); */
		/* service.getEmpsByIds(List.of(43, 44, 45)).forEach(System.out::println); */
		/* service.getAllEmps().forEach(System.out::println); */
		try {
		service.removeEmpsByGivenEntity(List.of(new EmployeeDTO(42),new EmployeeDTO(43)));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("problem in bulk deletion");
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
