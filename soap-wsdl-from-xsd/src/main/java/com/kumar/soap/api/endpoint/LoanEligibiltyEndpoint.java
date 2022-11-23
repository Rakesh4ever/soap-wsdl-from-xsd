/**
 * 
 */
package com.kumar.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.kumar.soap.api.service.LoanEligibilityService;
import com.kumar.soap.api.xsd.CustomerRequest;
import com.kumar.soap.api.xsd.Feedback;

/**
 * @author Rakesh
 *
 */

@Endpoint
public class LoanEligibiltyEndpoint {
	private static final String NAMESPACE = "http://www.kumar.com/soap/api/xsd";
	@Autowired
	private LoanEligibilityService loanService;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Feedback getLoanStatus(@RequestPayload CustomerRequest request) {
		return loanService.loanEligibilityStatus(request);

	}

}
