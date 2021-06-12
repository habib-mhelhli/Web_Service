package de.tekup.soap.endpoint;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.soap.models.whitetest.ExamsDisponibleResponse;
import de.tekup.soap.models.whitetest.ExamsRequest;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.service.ExamsService;
import de.tekup.soap.service.whiteTestService;

@Endpoint
public class ExamsEndpoint {

	public static final String nameSpace="http://www.tekup.de/soap/models/whitetest";

	@Autowired
	ExamsService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "ExamsRequest")
	@ResponsePayload
	public ExamsDisponibleResponse getExams(@RequestPayload ExamsRequest ExamsRequest) throws DatatypeConfigurationException {
		return service.getAllExams(ExamsRequest);
	}
	
}
