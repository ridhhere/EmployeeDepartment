package com.ridh.employee.pojo;

import java.util.Set;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
	@GenericGenerator(name = "myGenerator",strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO,generator ="myGenerator")
	@Id
	@Column(name="DNO")
	private Long dno;
	@Column(name="DNAME")
	private String dname;
	@Column(name="LOC")
	private String loc;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "dno", referencedColumnName = "dno")
	private Set<EmployeeEntity> employee;
	
}
