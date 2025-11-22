package paymentService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paymentService.model.ProcessPaymentRequest;
import paymentService.model.ProcessPaymentResponse;
import paymentService.service.PaymentProcessService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
    private final PaymentProcessService service;

    public PaymentController(PaymentProcessService service) {
        this.service = service;
    }

    @PostMapping("/process")
    public ResponseEntity<ProcessPaymentResponse> processPayment(
            @RequestBody ProcessPaymentRequest request) {
    	logger.info("PaymentController - processPayment called with request: {}", request);
    	
        ProcessPaymentResponse response = service.processPayment(request);
        logger.info("PaymentController - processPayment completed with response: {}", response);
        return ResponseEntity.ok(response);
    }
}
