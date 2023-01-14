package umlforjava.isp;

import java.time.LocalDate;

/**
 * @author gutenlee
 * @since 2023/01/14
 */
public class StudentEnrollment implements EnrollmentReporter, EnrollmentAccounting {

    @Override
    public String getName(String parameter){
        System.out.println("StudentEnrollment.getName");
        return "NAME";
    }

    @Override
    public LocalDate getDate(String parameter){
        System.out.println("StudentEnrollment.getDate");
        return LocalDate.now();
    }

    @Override
    public void prepareInvoice() {

    }

    @Override
    public void postPayment() {

    }
}
