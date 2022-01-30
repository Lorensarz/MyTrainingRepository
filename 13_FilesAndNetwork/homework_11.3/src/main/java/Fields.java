public class Fields {
    private String accountType;
    private String accountNumber;
    private String currency;
    private String dateOperation;
    private String wiringReference;
    private String operationDescription;
    private String income;
    private String expense;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getWiringReference() {
        return wiringReference;
    }

    public void setWiringReference(String wiringReference) {
        this.wiringReference = wiringReference;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public String getIncome() {
        return income.replaceAll(",", ".");
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpense() {
        return expense.replaceAll(",", ".");
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }
}
