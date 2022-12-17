package pl.woelke.springmysqlserver.service;

import org.springframework.stereotype.Service;
import pl.woelke.springmysqlserver.model.TechnicalReport;
import pl.woelke.springmysqlserver.repository.TechReportRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TechReportService {
    private static final Logger LOGGER = Logger.getLogger(TechReportService.class.getName());

    private TechReportRepository techReportRepository;

    public TechReportService(TechReportRepository techReportRepository) {
        this.techReportRepository = techReportRepository;
    }

    public List<TechnicalReport> getAllTechReports() {
        LOGGER.info("getAllTechReports()");
        List<TechnicalReport> technicalReports = techReportRepository.findAll();
        LOGGER.info("getAllTechRepository(...)");
        return technicalReports;
    }
}
