package paymentService.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import paymentService.beans.AuditBean;
import paymentService.service.AuditProducer;

@Service
public class AuditProducerImpl implements AuditProducer {

	private final KafkaTemplate<String, AuditBean> kafkaTemplate;
	private static final String AUDIT_TOPIC = "ewallet_audit";
	private static final Logger log = LoggerFactory.getLogger(AuditProducerImpl.class);

	public AuditProducerImpl(KafkaTemplate<String, AuditBean> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public boolean publishAuditEvents(AuditBean audit) {
		boolean status = false;
		try {
			kafkaTemplate.send(AUDIT_TOPIC, audit);
			log.info("Message published to audit topic for transaction Id: {}", audit.getTransactionId());
			status = true;
		} catch (Exception e) {
			log.error("Exception Occured {}", e);
		}
		return status;
	}

}
