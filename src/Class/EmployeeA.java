package Class;

import java.io.Writer;

public class EmployeeA extends Employee {

    private float healthDiscount = 0;
    private float pensionDiscount = 0;
    private float totalDiscounts = 0;

    public EmployeeA(int id, float salary) {
        super(id, salary);
    }

    public float calculateTotalSalary() {
        healthDiscount = salary * HEALTH_DISCOUNT_RATE.floatValue();
        pensionDiscount = salary * PENSION_DISCOUNT_RATE.floatValue();
        totalDiscounts = healthDiscount + pensionDiscount;
        return salary - totalDiscounts + ALIMENTACION_SUBSIDY + TRANSPORT_SUBSIDY;
    }

    public void billingDetails(Writer writer) throws java.io.IOException {
        float totalSalary = calculateTotalSalary();
        writer.write("Empleado #" + (id + 1) + "\n");
        writer.write("----------------------------------------\n");
        writer.write(String.format("Sueldo Base:              $%,.2f%n", salary));
        writer.write(String.format("Descuento Salud (4%%):     $%,.2f%n", healthDiscount));
        writer.write(String.format("Descuento Pensión (4%%):   $%,.2f%n", pensionDiscount));
        writer.write(String.format("Total Descuentos:         $%,.2f%n", totalDiscounts));
        writer.write(String.format("Subsidio Alimentación:    $%,.2f%n", ALIMENTACION_SUBSIDY));
        writer.write(String.format("Subsidio Transporte:      $%,.2f%n", TRANSPORT_SUBSIDY));
        writer.write("----------------------------------------\n");
        writer.write(String.format("Sueldo Neto:            $%,.2f%n", totalSalary));
        writer.write("========================================\n\n");
    }

}