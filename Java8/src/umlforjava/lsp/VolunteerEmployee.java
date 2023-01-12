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


    private static double violateLSP_case( ) {

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

        return totalPay;
    }

    public static void main(String[] args) {

    }

    private static double violateLSP_case2( ) throws UnpayableEmployeeException {

        double totalPay = 0;

        List<Employee> employees = List.of(new SalariedEmployee(), new HourlyEmployee(), new VolunteerEmployee());
        for (int i = 0; i < employees.size(); i++) {

            Employee employee = employees.get(i);
            // LSP 위반 :  이 경우는 Employee 라는 기반 클래스로 작업하던 코드에서 이제는 이 기반 클래스에서 유도된 클래스까지 명시해야 한다.
            // Employee 사용자는 VolunteerEmployee 가 있다는 사실만으로도 영향을 받는다.
            // instanceof 구문은 OCP 도 어긴다
            if (!(employee instanceof VolunteerEmployee))
                totalPay += employee.calcPay();
        }

        return totalPay;
    }


}
