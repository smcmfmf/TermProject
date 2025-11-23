package kr.ac.kopo.smcmfmf.example.termproject.repository;

import kr.ac.kopo.smcmfmf.example.termproject.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}