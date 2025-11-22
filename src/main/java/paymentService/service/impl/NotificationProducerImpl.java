package paymentService.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import paymentService.beans.NotificationBean;
import paymentService.service.NotificationProducer;

@Service
public class NotificationProducerImpl implements NotificationProducer {

	private final KafkaTemplate<String, NotificationBean> kafkaTemplate;
	private static final String NOTIFICATION_TOPIC = "ewllet_notification";
	private static final Logger log = LoggerFactory.getLogger(NotificationProducerImpl.class);

	public NotificationProducerImpl(KafkaTemplate<String, NotificationBean> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public boolean publishNotificationEvents(NotificationBean notification) {
		boolean status = false;
		try {
			kafkaTemplate.send(NOTIFICATION_TOPIC, notification);
			log.info("Message published to notification topic for transaction Id: {}", notification.getTransactionId());
			status = true;
		} catch (Exception e) {
			log.error("Exception Occured {}", e);
		}
		return status;
	}

}
