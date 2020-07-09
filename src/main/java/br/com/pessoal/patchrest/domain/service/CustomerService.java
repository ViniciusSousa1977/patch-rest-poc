package br.com.pessoal.patchrest.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.pessoal.patchrest.domain.model.Customer;
import br.com.pessoal.patchrest.domain.model.PaymentCard;

@Service
public class CustomerService {
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	public CustomerService() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("post", true);
		map.put("email", true);
		
		List<PaymentCard> cardsCustomer1 = new ArrayList<PaymentCard>();
		cardsCustomer1.add(new PaymentCard(1L, 45625431625L, "Visa"));
		cardsCustomer1.add(new PaymentCard(2L, 84245895474L, "Mastercard"));
		
		List<PaymentCard> cardsCustomer2 = new ArrayList<PaymentCard>();
		cardsCustomer2.add(new PaymentCard(1L, 81548856441L, "AMEX"));
		cardsCustomer2.add(new PaymentCard(2L, 32548988627L, "Mastercard"));
		
		customers.add(new Customer("1", "19 983303977", Arrays.asList("Eggs", "Milk"), map, cardsCustomer1));
		customers.add(new Customer("2", "21 984781148", Arrays.asList("Eggs", "Milk", "Coke"), map, cardsCustomer2));
		customers.add(new Customer("3", "41 756489521", Arrays.asList("Eggs", "Milk", "Coke", "Cheese"), map, null));
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
		int index = customers.indexOf(customerPatched);
		
		if(index > -1){
			customers.add(index, customerPatched);
        }
		
		System.out.println("Salvando customer.....");
	}	
}