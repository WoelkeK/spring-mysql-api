package pl.woelke.springmysqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.woelke.springmysqlserver.model.TechnicalReport;
@Repository
public interface TechReportRepository extends JpaRepository<TechnicalReport, Long> {
    }
