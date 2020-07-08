package br.com.pessoal.patchrest.domain.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Customer {

	private String id;
	private String telephone;
	private List<String> favorites;
	private Map<String, Boolean> communicationPreferences;

	public Customer() {
		
	}
	
	public Customer(String id, String telephone, List<String> favorites,
			Map<String, Boolean> communicationPreferences) {
		this.id = id;
		this.telephone = telephone;
		this.favorites = favorites;
		this.communicationPreferences = communicationPreferences;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the favorites
	 */
	public List<String> getFavorites() {
		return favorites;
	}

	/**
	 * @param favorites the favorites to set
	 */
	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}

	/**
	 * @return the communicationPreferences
	 */
	public Map<String, Boolean> getCommunicationPreferences() {
		return communicationPreferences;
	}

	/**
	 * @param communicationPreferences the communicationPreferences to set
	 */
	public void setCommunicationPreferences(Map<String, Boolean> communicationPreferences) {
		this.communicationPreferences = communicationPreferences;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
}