package umlforjava.isp;

/**
 * @author gutenlee
 * @since 2023/01/14
 */
public class EnrollmentReportGenerator {

    private EnrollmentReporter enrollmentReporter;

    public void generateReport() {
        enrollmentReporter.getDate("param");
        enrollmentReporter.getName("param");
    }

}
