package com.sm.model;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="STUDENT_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Student {
	
	@Id
	@SequenceGenerator(name="gen", sequenceName = "stu_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
	private Integer sid;
	
	@Column(length=30)
//	@NonNull
	private String name;
	//@NonNull
	private Integer year;
	@Column(length=30)
//	@NonNull
	private String dept;

}
