package com.ridh.employee.pojo;

import java.util.Set;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
	@GenericGenerator(name = "myGenerator",strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO,generator ="myGenerator")
	@Id
	@Column(name="ENO")
	private Long eno;
	@Column(name="ENAME")
	private String ename;
	@Column(name="EADD")
	private String eadd;
	@Column(name="DNO")
	private Long dno;
}
