package de.tekup.soap.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.soap.Repository.ExamRepository;
import de.tekup.soap.Repository.StudentRepository;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ExamsDisponibleResponse;
import de.tekup.soap.models.whitetest.ExamsRequest;


@Service
public class ExamsService {
	private StudentRepository StudentRepository;
	private ExamRepository examRepository;
	
	
	 @Autowired
	    public ExamsService(StudentRepository StudentRepository , ExamRepository ExamRepository) {
	        this.StudentRepository = StudentRepository;
	        this.examRepository= ExamRepository;
	    } 
	 
	 
	 public ExamsDisponibleResponse getAllExams(ExamsRequest request){
		 ExamsDisponibleResponse response = new ExamsDisponibleResponse();
	    	 List<Exam> exams = examRepository.findAllExams();
	    	 
	    	 System.err.println("exams :"+exams);
	    	 List<Exam> exam = response.getExams();

	    	 for(Exam e : exams) {
	    		 exam.add(e);
	    		 
	    	 }
	    	  response.setNombre(request.getNombre());
	             return response;
	     }
	 

}
