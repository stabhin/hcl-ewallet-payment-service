package paymentService.model;

import java.util.List;

public class ProcessPaymentRequest {
    private Long userId;
    private Long merchantId;
    private String currency;
    private List<PurchaseItemRequest> items;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<PurchaseItemRequest> getItems() {
		return items;
	}
	public void setItems(List<PurchaseItemRequest> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "ProcessPaymentRequest [userId=" + userId + ", merchantId=" + merchantId + ", currency=" + currency
				+ "]";
	}

    // Getters and Setters
}