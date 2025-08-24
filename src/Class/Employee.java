package Class;

import java.math.BigDecimal;

public abstract class Employee {

    protected int id;
    protected float salary;
    protected static final float ALIMENTACION_SUBSIDY = 100000f;
    protected static final float TRANSPORT_SUBSIDY = 150000f;
    protected static final BigDecimal HEALTH_DISCOUNT_RATE = new BigDecimal("0.04");
    protected static final BigDecimal PENSION_DISCOUNT_RATE = new BigDecimal("0.04");

    public Employee(int id, float salary) {
        this.id = id;
        this.salary = salary;
    }

}
