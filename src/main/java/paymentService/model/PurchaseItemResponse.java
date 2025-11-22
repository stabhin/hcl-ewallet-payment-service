package paymentService.model;

public class PurchaseItemResponse {
	private Long productId;
	private String productName;
	private Integer quantity;
	private Double unitPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public PurchaseItemResponse(Long productId, String productName, Integer quantity, Double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "PurchaseItemResponse [productId=" + productId + ", productName=" + productName + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice +  "]";
	}

	// Getters and Setters
}
