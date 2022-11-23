/**
 * 
 */
package com.kumar.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kumar.soap.api.xsd.CustomerRequest;
import com.kumar.soap.api.xsd.Feedback;

/**
 * @author Rakesh
 *
 */

@Service
public class LoanEligibilityService {

	public Feedback loanEligibilityStatus(CustomerRequest request) {
		Feedback feedback =new Feedback();
		List<String> missMatchedCriterias= feedback.getCriteriaMismatch();
		 if(!(request.getAge()>=30 && request.getAge()<=50)) {
			 missMatchedCriterias.add("Customer age should and must be in between 30 to 50");
		 }
		 if(!(request.getYearlyIncome()>300000)) {
			 missMatchedCriterias.add("Customer income should and must greater than 3 lac");
		 }
		 if(!(request.getCibilScore()>500)) {
			 missMatchedCriterias.add("Your CIBIL Score is low -you can't take this loan ");
		 }
		 if(missMatchedCriterias.size()>0) {
			 feedback.setApprovedAmount(0);
			 feedback.setIsEligible(false);
		 }
		 else {
			 feedback.setApprovedAmount(request.getYearlyIncome()-50000);
			 feedback.setIsEligible(true);
			missMatchedCriterias.clear();
		 }
		return feedback;
		
	}
}
