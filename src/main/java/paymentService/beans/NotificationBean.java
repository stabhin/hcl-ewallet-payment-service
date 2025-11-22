package paymentService.beans;

import java.util.Map;

import lombok.Data;

@Data
public class NotificationBean {

	private String customerId;
	private String customerName;
	private Long customerMobileNumber;
	private String customerEmailId;
	private Float amount;
	private String transactionId;
	private String merchantId;
	private String merchantName;
	private Map<String, Integer> productMap;
	private String merchantEmail;
	private Long merchantMobileNumber;
	private String status;
	private String reasonForFailure;

}
