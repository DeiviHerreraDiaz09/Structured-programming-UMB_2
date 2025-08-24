package Class;

import java.io.Writer;

public class EmployeeC extends Employee {

    private float totalSales = 0;
    private float commission = 0;

    public EmployeeC(int id, float salary, float totalSales) {
        super(id, salary);
        this.totalSales = totalSales;
    }

    public float calculateTotalSalary() {
        commission = totalSales * 0.2f;
        return salary + commission;
    }

    public void billingDetails(Writer writer) throws java.io.IOException {
        float totalSalary = calculateTotalSalary();
        writer.write("Empleado #" + (id + 1) + "\n");
        writer.write("----------------------------------------\n");
        writer.write(String.format("Sueldo Base:          $%,.2f%n", salary));
        writer.write(String.format("Ventas Totales:       $%,.2f%n", totalSales));
        writer.write(String.format("Comisión (20%%):       $%,.2f%n", commission));
        writer.write("----------------------------------------\n");
        writer.write(String.format("Sueldo Neto:        $%,.2f%n", totalSalary));
        writer.write("========================================\n\n");
    }

}