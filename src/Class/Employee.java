package Class;

import java.math.BigDecimal;

public abstract class Employee {

    protected int id;
    protected float salary;
    protected static final float ALIMENTACION_SUBSIDY = Float.parseFloat(System.getenv("ALIMENTACION_SUBSIDY") != null && !System.getenv("ALIMENTACION_SUBSIDY").isEmpty() ? System.getenv("ALIMENTACION_SUBSIDY") : "100000.0F");
    protected static final float TRANSPORT_SUBSIDY = Float.parseFloat(System.getenv("TRANSPORT_SUBSIDY") != null && !System.getenv("TRANSPORT_SUBSIDY").isEmpty() ? System.getenv("TRANSPORT_SUBSIDY") : "150000.0F");
    protected static final BigDecimal HEALTH_DISCOUNT_RATE = new BigDecimal(System.getenv("HEALTH_DISCOUNT_RATE") != null && !System.getenv("HEALTH_DISCOUNT_RATE").isEmpty() ? System.getenv("HEALTH_DISCOUNT_RATE") : "0.04");
    protected static final BigDecimal PENSION_DISCOUNT_RATE = new BigDecimal(System.getenv("PENSION_DISCOUNT_RATE") != null && !System.getenv("PENSION_DISCOUNT_RATE").isEmpty() ? System.getenv("PENSION_DISCOUNT_RATE") : "0.04");

    public Employee(int id, float salary) {
        this.id = id;
        this.salary = salary;
    }

}
