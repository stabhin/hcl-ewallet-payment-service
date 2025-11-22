package paymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paymentService.model.TransactionLedger;

public interface TransactionLedgerRepository extends JpaRepository<TransactionLedger, Long> {
}
