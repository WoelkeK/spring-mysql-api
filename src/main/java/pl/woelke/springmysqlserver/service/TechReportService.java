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

    public TechnicalReport createReport(TechnicalReport report) {
        LOGGER.info("createReport()");
        TechnicalReport savedReport = techReportRepository.save(report);
        LOGGER.info("createReport(...)");
        return savedReport;
    }

    public TechnicalReport readReport(Long id) {
        LOGGER.info("readReport()");
        TechnicalReport technicalReport = techReportRepository.findById(id).orElseThrow();
        LOGGER.info("readReport(...)");
        return technicalReport;
    }

    public TechnicalReport updateReport(TechnicalReport report) {
        LOGGER.info("updateReport()");
        TechnicalReport editedReport = techReportRepository.findById(report.getId()).orElseThrow();
        editedReport.setName(report.getName());
        editedReport.setFailure(report.getFailure());
        editedReport.setCreated(report.getCreated());
        TechnicalReport updatedReport = techReportRepository.save(editedReport);
        LOGGER.info("updateReport(...)");
        return updatedReport;
    }

    public String deleteReport(Long id) {
        LOGGER.info("deleteReport()");
        techReportRepository.deleteById(id);
        LOGGER.info("deleteReport(...)");
        return "Record " + id + " deleted";
    }
}
