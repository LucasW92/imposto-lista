package entities;

public class TaxPayer {
    private final double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {

        double monthlyIncome, anualSalaryTax = 0.0;

        if (salaryIncome > 0.0) {
            monthlyIncome = salaryIncome / 12;
            if (monthlyIncome < 3000.0) {
                anualSalaryTax = 0.0;
            } else if (monthlyIncome >= 3000.0 && monthlyIncome < 5000.0) {
                anualSalaryTax = salaryIncome * 0.1;
            } else {
                anualSalaryTax = salaryIncome * 0.2;
            }
        }

        return anualSalaryTax;
    }

    public double servicesTax() {

        double anualServicesTax = 0.0;

        if (servicesIncome > 0.0) {
            anualServicesTax = servicesIncome * 0.15;
        }

        return anualServicesTax;
    }

    public double capitalTax() {

        double anualCapitalTax = 0.0;

        if (capitalIncome > 0.0) {
            anualCapitalTax = capitalIncome * 0.2;
        }

        return anualCapitalTax;
    }

    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {

        double maximumDeductibleTax = grossTax() * 0.3;
        double deductibleSpending = healthSpending + educationSpending;
        double deduction;

        if (maximumDeductibleTax < deductibleSpending) {
            deduction = maximumDeductibleTax;
        } else {
            deduction = deductibleSpending;
        }

        return  deduction;
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }
}
