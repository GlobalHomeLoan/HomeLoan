package com.cjc.hl.enquiry.main.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cjc.hl.enquiry.main.model.CustomerDetails;
import com.cjc.hl.enquiry.main.model.EnquiryDetails;
import com.cjc.hl.enquiry.main.serviceI.homeLoanServiceI;
@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class CustomerDetailsController {
	
	@Autowired
	homeLoanServiceI homeLoanServiceI;
	@PostMapping("/savecustdeteils")
	public String saveCustData(@Valid @RequestBody CustomerDetails cd){
		homeLoanServiceI.saveCustomerDetails(cd);
		return "CustDetailsRegister Successfully";	
	}
	
	@GetMapping("/getcustdeteils")
	public List<CustomerDetails> getCustData(){
		List<CustomerDetails> cd=homeLoanServiceI.getCustomerDetails();
		return cd;	
	}
	
	@GetMapping("/getById/{id}")
	public  CustomerDetails getCustomerDetailsById (@PathVariable int id ) {
		
		CustomerDetails enq=homeLoanServiceI.getCustomerDetailsById(id);
		
		return enq;
		
		
	} 


}
