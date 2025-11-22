package paymentService.service;

import paymentService.beans.AuditBean;

public interface AuditProducer {
	
	public boolean publishAuditEvents(AuditBean audit);
	
}
