package sks.project.sksbackend.mapper;

import sks.project.sksbackend.dto.EmployeeDto;
import sks.project.sksbackend.entities.Employee;

public class EmployeeMapper {
//3.olarak MAPPER katmanı oluşturuldu
//bu sınıf employee ve employeeDto sınıfları arasında nesneleri dönüştürmek için kullanılır

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);	
		/*Bu metot "Employee" nesnesi alır ve bu nesnenin verilerini kullanarak yeni bir "EmployeeDto"
		  nesnesi oluşturur. */
	}
	public static Employee mapToEmployee (EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
		/*Bu metot "EmployeeDto" nesnesi alır ve bu nesnenin verilerini kullanarak yeni bir "Employee"
		  nesnesi oluşturur*/
		
		
	}
/*Veritabanından veri alırken ve veritabanına veri kaydederken kullanılabilcek bir araç sağlar.
 Örnek olarak veritabanı sorgusu sonucunda elde edilen "Employee" nesnesini kullanıcı arayüzünde göstermek 
 için "EmployeeDto"ya dönüştürebiliriz. Ya da kullanıcı tarafından girilen çalışan bilgilerini veritabanına
 kaydetmek için "EmployeeDto" nesnesini "Employee" nesnesine dönüştürebiliriz.
 DTO (Data Transfer Object)*/
}
