package de.tekup.test.invoke.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.test.invoke.client.service.SoapClient;
import de.tekup.test.soap.api.consume.whiteTest.ExamsDisponibleResponse;
import de.tekup.test.soap.api.consume.whiteTest.ExamsRequest;
import de.tekup.test.soap.api.consume.whiteTest.StudentRequest;
import de.tekup.test.soap.api.consume.whiteTest.WhiteTestResponse;

@Controller
public class ExamsController {
	
	@Autowired
	private SoapClient client;

	@GetMapping("/Exams")
	public String studentForm(Model model ) {
		ExamsRequest requestexams = new ExamsRequest();
		model.addAttribute("requestexams", requestexams);
		return "request-exams";
	}

	
	@PostMapping("/Exams")
	public String webServiceResponse(@ModelAttribute ("requestexams") ExamsRequest requestexams , Model model) {
		ExamsDisponibleResponse responseexam  = client.getExams(requestexams);
		model.addAttribute("responseexam", responseexam);
		return "response-exams";
		
	}

}