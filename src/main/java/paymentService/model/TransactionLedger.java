package paymentService.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "transaction_ledger")
public class TransactionLedger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txId;

	private Long customerId;
	private Long merchantId;
	private String currency;
	private Double amount;
	private Double walletFee;
	private String status;
	private Instant createdAt = Instant.now();
	public Long getTxId() {
		return txId;
	}
	public void setTxId(Long txId) {
		this.txId = txId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getWalletFee() {
		return walletFee;
	}
	public void setWalletFee(Double walletFee) {
		this.walletFee = walletFee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "PaymentProcess [txId=" + txId + ", customerId=" + customerId + ", merchantId=" + merchantId
				+ ", currency=" + currency + ", amount=" + amount + ", walletFee=" + walletFee + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}
	
	

}
