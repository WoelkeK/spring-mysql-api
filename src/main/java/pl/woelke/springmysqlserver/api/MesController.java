package pl.woelke.springmysqlserver.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.woelke.springmysqlserver.model.TechnicalReport;
import pl.woelke.springmysqlserver.service.TechReportService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/")
public class MesController {

    private static final Logger LOGGER = Logger.getLogger(MesController.class.getName());
    private TechReportService techReportService;

    public MesController(TechReportService techReportService) {
        this.techReportService = techReportService;
    }

    @GetMapping("reports")
    public List<TechnicalReport> getAllReports() {
        LOGGER.info("getAllReports()");
        List<TechnicalReport> allTechReports = techReportService.getAllTechReports();
        LOGGER.info("getAllReports(...)");
        return allTechReports;
    }
    @PostMapping("reports")
    public TechnicalReport createReport(@RequestBody TechnicalReport report) {
        LOGGER.info("createReport()");
        TechnicalReport createdReport = techReportService.createReport(report);
        LOGGER.info("createReport(...)");
        return createdReport;
    }
    @GetMapping("reports/{id}")
    public TechnicalReport readReport(@PathVariable (name="id") Long id) {
        LOGGER.info("readReport()");
        TechnicalReport technicalReport = techReportService.readReport(id);
        LOGGER.info("readReport(...)");
        return technicalReport;
    }
    @PutMapping("reports")
    public TechnicalReport updateReport(@RequestBody TechnicalReport report) {
        LOGGER.info("updateReport()");
        TechnicalReport updatedReport = techReportService.updateReport(report);
        LOGGER.info("updateReport(...)");
        return updatedReport;
    }
    @DeleteMapping("reports/{id}")
    public String deleteReport(@PathVariable (name = "id") Long id) {
        LOGGER.info("deleteReport()");
        String comfirmation = techReportService.deleteReport(id);
        LOGGER.info("deleteReport(...)");
        return comfirmation;
    }

}
