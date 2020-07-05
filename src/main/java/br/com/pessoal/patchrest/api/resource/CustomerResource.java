package br.com.pessoal.patchrest.api.resource;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import br.com.pessoal.patchrest.domain.model.Customer;
import br.com.pessoal.patchrest.domain.service.CustomerService;

@RestController
public class CustomerResource {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(path = "customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(required = true) String id) {
		Customer customer = customerService.findCustomer(id);
		
		if (Objects.nonNull(customer)) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PatchMapping(path = "customers/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(required = true) String id, 
			                                       @RequestBody(required = true) JsonPatch patch) {
	    try {
	        Customer customer = customerService.findCustomer(id);
	        
	        if (Objects.nonNull(customer)) {
		        Customer customerPatched = applyPatchToCustomer(patch, customer);
		        customerService.updateCustomer(customerPatched);
		        return ResponseEntity.ok(customerPatched);
	        } else {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    } catch (JsonPatchException | JsonProcessingException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	private Customer applyPatchToCustomer(JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {
		final ObjectMapper objectMapper = new ObjectMapper();
		
	    JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
	    return objectMapper.treeToValue(patched, Customer.class);
	}
}
