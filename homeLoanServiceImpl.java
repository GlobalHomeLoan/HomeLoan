package com.cjc.hl.enquiry.main.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hl.enquiry.main.model.Cibil;
import com.cjc.hl.enquiry.main.model.CustomerDetails;
import com.cjc.hl.enquiry.main.model.Document;
import com.cjc.hl.enquiry.main.model.EnquiryDetails;
import com.cjc.hl.enquiry.main.repository.CibilRepository;
import com.cjc.hl.enquiry.main.repository.CustomerDetailsRepository;
import com.cjc.hl.enquiry.main.repository.DocumentRepository;
import com.cjc.hl.enquiry.main.repository.homeLoanRepository;
import com.cjc.hl.enquiry.main.serviceI.homeLoanServiceI;

@Service
public class homeLoanServiceImpl implements homeLoanServiceI {
@Autowired
homeLoanRepository homeLoanRepository;
@Autowired
CustomerDetailsRepository customerDetailsRepository;
@Autowired
DocumentRepository documentRepository;
@Autowired
CibilRepository cibilRepository;

	@Override
	public EnquiryDetails saveEnquiryDetails(EnquiryDetails ed) {
		EnquiryDetails e=homeLoanRepository.save(ed);
		return e;
	}

	@Override
	public CustomerDetails saveCustomerDetails(CustomerDetails cd) {
		CustomerDetails custd=customerDetailsRepository.save(cd);
		return custd;
	}

	@Override
	public String uploadDoc(Document cust) {
		documentRepository.save(cust);
		// TODO Auto-generated method stub
		return "DocumentUploaded...";
		
	}

	@Override
	public List<CustomerDetails> getCustomerDetails() {
          List<CustomerDetails> d=customerDetailsRepository.findAll();
		return d;
	}

	@Override
	public Cibil checkCibilScore(Cibil cibil) {
		
		Random r=new Random();
		int min=400;
		int max=650;
		int a=r.nextInt((max-min)+max);
		//r.ints(400-600+650).limit(1).forEach(System.out::println);
		System.out.println(a);
		cibil.setCibilScore(a);	
		return  cibilRepository.save(cibil);
	}

	@Override
	public List<EnquiryDetails> getEnquiryDetails() {
		 List<EnquiryDetails> getEnquiryDetails=homeLoanRepository.findAll();
		return getEnquiryDetails;
	}

	@Override
	public EnquiryDetails getEnquiryDetailsById(int id) {
		  Optional<EnquiryDetails> pOptional=homeLoanRepository.findById(id);
		  if(pOptional.isPresent()) {
	    	  
	    	  EnquiryDetails p=pOptional.get();
	    	  return p;
	      }
		return pOptional.get();
	}

	@Override
	public CustomerDetails getCustomerDetailsById(int id) {
		Optional<CustomerDetails> pOptional=customerDetailsRepository.findById(id);
		  if(pOptional.isPresent()) {
	    	  
			  CustomerDetails p=pOptional.get();
	    	  return p;
	      }
		return pOptional.get();
	}
	

}
