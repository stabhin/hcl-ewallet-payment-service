package paymentService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paymentService.model.ProcessPaymentRequest;
import paymentService.model.ProcessPaymentResponse;
import paymentService.model.PurchaseItemResponse;
import paymentService.model.TransactionLedger;
import paymentService.repository.TransactionLedgerRepository;

@Service
public class PaymentProcessService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProcessService.class);

    private final TransactionLedgerRepository ledgerRepo;
    
    private final  WalletClient walletClient;

    public PaymentProcessService(TransactionLedgerRepository ledgerRepo, WalletClient walletClient) {
        this.ledgerRepo = ledgerRepo;
        this.walletClient = walletClient;
    }

    /**
     * Transactional ensures:
     * - If any exception occurs, the DB changes are rolled back
     */
    @Transactional(rollbackFor = Exception.class)
    public ProcessPaymentResponse processPayment(ProcessPaymentRequest request) {

        logger.info("PaymentProcessService - processPayment called with request: {}", request);

        try {
            // Validate request
            if (request.getItems() == null || request.getItems().isEmpty()) {
                throw new IllegalArgumentException("No items provided to process payment");
            }

            // Calculate total amount
            double total = request.getItems().stream()
                    .mapToDouble(i -> i.getUnitPrice() * i.getQuantity())
                    .sum();
            Double walletBalance = walletClient.getWalletBalance(request.getUserId());
            walletBalance -= total; // deduct payment
            logger.info("Updated wallet balance after payment: {}", walletBalance);
            
			if (walletBalance < 0) {
				throw new IllegalArgumentException("Insufficient wallet balance");
			}
            
            // Example rule to simulate failure
            if (total <= 0) {
                throw new IllegalArgumentException("Invalid total payment amount");
            }

            double fee = 1.00;
            double netToMerchant = total - fee;

            // Save transaction ledger
            TransactionLedger ledger = new TransactionLedger();
            ledger.setCustomerId(request.getUserId());
            ledger.setMerchantId(request.getMerchantId());
            ledger.setCurrency(request.getCurrency());
            ledger.setAmount(total);
            ledger.setWalletFee(fee);
            ledger.setStatus("SUCCESS");
            
            logger.info("Saving transaction ledger: {}", ledger);

            ledgerRepo.save(ledger);

            // Build response items
            List<PurchaseItemResponse> itemResponses =
                    request.getItems().stream()
                            .map(i -> new PurchaseItemResponse(
                                    i.getProductId(),
                                    i.getProductName(),
                                    i.getQuantity(),
                                    i.getUnitPrice()
                            ))
                            .collect(Collectors.toList());

            // Create API response
            ProcessPaymentResponse response = new ProcessPaymentResponse();
            response.setTransactionId(ledger.getTxId());
            response.setStatus("SUCCESS");
            response.setUserId(request.getUserId());
            response.setMerchantId(request.getMerchantId());
            response.setCurrency(request.getCurrency());
            response.setTotalAmount(total);
            response.setWalletFee(fee);
            response.setNetCreditedToMerchant(netToMerchant);
            response.setWalletBalanceAfter(walletBalance); // simulated
            response.setItems(itemResponses);
            response.setMessage("Payment processed successfully");

            logger.info("PaymentProcessService - processPayment completed with response: {}", response);

            return response;

        } catch (Exception e) {
            logger.error("Exception occurred while processing payment. Rolling back.", e);
            throw e; // triggers rollback
        }
    }
}