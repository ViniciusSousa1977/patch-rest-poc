package br.com.pessoal.patchrest.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.pessoal.patchrest.domain.model.Customer;

@Service
public class CustomerService {
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	public CustomerService() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("post", true);
		map.put("email", true);
		
		customers.add(new Customer("1", "19 983303977", Arrays.asList("Eggs", "Milk"), map));
		customers.add(new Customer("2", "21 984781148", Arrays.asList("Eggs", "Milk", "Coke"), map));
		customers.add(new Customer("3", "41 756489521", Arrays.asList("Eggs", "Milk", "Coke", "Cheese"), map));
	}
	
	public Customer findCustomer(String id) {
		for (Customer customer : customers) {
			if (customer.getId().equals(id)) {
				return customer;
			}
		}
		
		return null;
	}
	
	public void updateCustomer(Customer customerPatched) {
		System.out.println("Salvando customer.....");
	}	
}