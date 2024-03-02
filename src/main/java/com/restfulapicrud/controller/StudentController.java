package com.restfulapicrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfulapicrud.dto.StudentRequest;
import com.restfulapicrud.dto.StudentResponse;
import com.restfulapicrud.service.StudentService;
import com.restfulapicrud.util.ResponseStructure;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/students")
@Api(value = "Student Management System", description = "Operations pertaining to student management")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// Common base path for all endPoints in this controller
	@PostMapping
	@ApiOperation(value = "Add a new student")
	public ResponseEntity<ResponseStructure<StudentResponse>> addStudent(@RequestBody StudentRequest studentRequest) {
		return studentService.addStudent(studentRequest);
	}

	@GetMapping("/{studentId}")
	@ApiOperation(value = "Find a student by ID")
	public ResponseEntity<ResponseStructure<StudentResponse>> findStudentById(@PathVariable int studentId) {
		return studentService.findStudentById(studentId);
	}

	@PutMapping("/{studentId}")
	@ApiOperation(value = "Update a student by ID")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudentById(@PathVariable int studentId,
			@RequestBody StudentRequest studentRequest) {
		return studentService.updateStudentById(studentRequest, studentId);
	}

	@DeleteMapping("/{studentId}")
	@ApiOperation(value = "Delete a student by ID")
	public ResponseEntity<ResponseStructure<StudentResponse>> deleteStudentById(@PathVariable int studentId) {
		return studentService.deleteStudentById(studentId);
	}

	@GetMapping
	@ApiOperation(value = "Find all students")
	public ResponseEntity<ResponseStructure<List<StudentResponse>>> findAllStudents() {
		return studentService.findAllStudent();
	}
}
