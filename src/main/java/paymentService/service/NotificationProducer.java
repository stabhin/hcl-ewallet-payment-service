package paymentService.service;

import paymentService.beans.NotificationBean;

public interface NotificationProducer {
	
	public boolean publishNotificationEvents(NotificationBean notification);
	
}
