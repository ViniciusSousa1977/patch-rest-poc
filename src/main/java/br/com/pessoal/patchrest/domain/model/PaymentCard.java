package br.com.pessoal.patchrest.domain.model;

import java.util.Objects;

public class PaymentCard {
	
	private Long id;
	private Long cardNumber;
	private String flag;
	
	public PaymentCard() {
		
	}

	public PaymentCard(Long id, Long cardNumber, String flag) {
		this.id = id;
		this.cardNumber = cardNumber;
		this.flag = flag;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cardNumber
	 */
	public Long getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
		PaymentCard other = (PaymentCard) obj;
		return Objects.equals(id, other.id);
	}
}
