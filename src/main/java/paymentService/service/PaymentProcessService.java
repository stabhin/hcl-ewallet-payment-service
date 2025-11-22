package paymentService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import paymentService.model.ProcessPaymentRequest;
import paymentService.model.ProcessPaymentResponse;
import paymentService.model.PurchaseItemResponse;
import paymentService.model.TransactionLedger;
import paymentService.repository.TransactionLedgerRepository;

@Service
public class PaymentProcessService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentProcessService.class);

    private final TransactionLedgerRepository ledgerRepo;

    public PaymentProcessService(TransactionLedgerRepository ledgerRepo) {
        this.ledgerRepo = ledgerRepo;
    }

    public ProcessPaymentResponse processPayment(ProcessPaymentRequest request) {
    	logger.info("PaymentProcessService - processPayment called with request: {}", request);
        // Calculate total amount
        double total = request.getItems().stream()
                .mapToDouble(i -> i.getUnitPrice() * i.getQuantity())
                .sum();

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
        response.setWalletBalanceAfter(420.02); // Assume wallet balance updated externally
        response.setItems(itemResponses);
        response.setMessage("Payment processed successfully");
        logger.info("PaymentProcessService - processPayment completed with response: {}", response);
        return response;
    }
}
