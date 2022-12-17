package pl.woelke.springmysqlserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.woelke.springmysqlserver.model.TechnicalReport;
import pl.woelke.springmysqlserver.service.TechReportService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/")
public class Maintenance {

    private static final Logger LOGGER = Logger.getLogger(Maintenance.class.getName());
    private TechReportService techReportService;

    public Maintenance(TechReportService techReportService) {
        this.techReportService = techReportService;
    }

    @GetMapping("reports")
    public List<TechnicalReport> getAllReports() {
        LOGGER.info("getAllReports()");
        List<TechnicalReport> allTechReports = techReportService.getAllTechReports();
        LOGGER.info("getAllReports(...)");
        return allTechReports;
    }
}
