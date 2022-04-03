package br.com.investmentcontrol.repository;

import br.com.investmentcontrol.domain.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
