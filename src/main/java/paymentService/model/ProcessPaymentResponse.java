package paymentService.model;

import java.time.Instant;
import java.util.List;

public class ProcessPaymentResponse {

    private Long transactionId;
    private String status;
    private Long userId;
    private Long merchantId;
    private String currency;
    private Double totalAmount;
    private Double walletFee;
    private Double netCreditedToMerchant;
    private Double walletBalanceAfter;
    private List<PurchaseItemResponse> items;
    private Long auditReferenceId;
    private Instant timestamp;
    private String message;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getWalletFee() {
		return walletFee;
	}
	public void setWalletFee(Double walletFee) {
		this.walletFee = walletFee;
	}
	public Double getNetCreditedToMerchant() {
		return netCreditedToMerchant;
	}
	public void setNetCreditedToMerchant(Double netCreditedToMerchant) {
		this.netCreditedToMerchant = netCreditedToMerchant;
	}
	public Double getWalletBalanceAfter() {
		return walletBalanceAfter;
	}
	public void setWalletBalanceAfter(Double walletBalanceAfter) {
		this.walletBalanceAfter = walletBalanceAfter;
	}
	public List<PurchaseItemResponse> getItems() {
		return items;
	}
	public void setItems(List<PurchaseItemResponse> items) {
		this.items = items;
	}
	public Long getAuditReferenceId() {
		return auditReferenceId;
	}
	public void setAuditReferenceId(Long auditReferenceId) {
		this.auditReferenceId = auditReferenceId;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ProcessPaymentResponse [transactionId=" + transactionId + ", status=" + status + ", userId=" + userId
				+ ", merchantId=" + merchantId + ", currency=" + currency + ", totalAmount=" + totalAmount
				+ ", walletFee=" + walletFee + ", netCreditedToMerchant=" + netCreditedToMerchant
				+ ", walletBalanceAfter=" + walletBalanceAfter + ", items=" + items + ", auditReferenceId="
				+ auditReferenceId + ", timestamp=" + timestamp + ", message=" + message + "]";
	}

}
