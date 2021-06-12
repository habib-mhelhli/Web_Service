package de.tekup.soap.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.Repository.ExamRepository;
import de.tekup.soap.Repository.StudentRepository;

@Service
public class whiteTestService {
	private StudentRepository StudentRepository;
	private ExamRepository examRepository;
	
    @Autowired
    public whiteTestService(StudentRepository StudentRepository , ExamRepository ExamRepository) {
        this.StudentRepository = StudentRepository;
        this.examRepository= ExamRepository;
    }
	
	public WhiteTestResponse getwhiteTest(StudentRequest studentReq) throws DatatypeConfigurationException {

		WhiteTestResponse response = new WhiteTestResponse();
		List<String> badrequests = response.getBadRequests(); 
		Student student  = StudentRepository.findStudent(studentReq.getStudentId());
		Exam exam = examRepository.findExam(studentReq.getExamCode());
        if((student == null)  || (exam ==null)){
        if(student == null) 
        	badrequests.add("Wrong student id");
        if(exam == null)
        	badrequests.add("wrong exam code");
        	
        //return response;
        	
        }else {
        	response.setStudent(student);
        	
            response.setExam(exam);	
            
         	
            GregorianCalendar gr = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gr.add(gr.DAY_OF_MONTH, 7);
            XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gr);

    		response.setDate(cal);
           
        }
        return response;
	}

  

}
