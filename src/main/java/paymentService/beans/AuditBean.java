package paymentService.beans;

import lombok.Data;

@Data
public class AuditBean {
	
	private Long transactionId;
    private String request;
    private String response;
    private String event; 

}
