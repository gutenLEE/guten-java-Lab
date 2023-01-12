package umlforjava.lsp;

import java.util.List;

/**
 * @author gutenlee
 * @since 2023/01/12
 */
public class VolunteerEmployee extends Employee {

    @Override
    public double calcPay() throws UnpayableEmployeeException {
        // return 0; 임금 총계가 나온 임금 명세서를 출력하면 당황스러운 상황에 처할 수도 있다.
        throw new UnpayableEmployeeException(); // 예외를 던지도록 변경한다면
    }

    public static void main(String[] args) {

        double totalPay = 0;

        List<Employee> employees = List.of(new SalariedEmployee(), new HourlyEmployee(), new VolunteerEmployee());
        for (int i = 0; i < employees.size(); i++) {

            Employee employee = employees.get(i);
            // try-catch -> 파생 클래스의 제약이 기반 클래스의 사용자에게도 영향을 미치는 상황이 발생
            try {
                totalPay += employee.calcPay();
            } catch (UnpayableEmployeeException e) {
                e.printStackTrace();
            }

        }
    }

}
