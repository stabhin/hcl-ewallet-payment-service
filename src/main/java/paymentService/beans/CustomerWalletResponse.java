package paymentService.beans;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CustomerWalletResponse {
	private long customerId;
	private String fullName;
	private BigDecimal balance;
	private String currency;
	private String email;
}