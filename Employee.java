package Assignments;

/*
* Make below class immutable:
class Employee {
                private String empID;
                private String name;
}

----> Immutable objects are instances whose state doesn’t change after it has been initialized.
----> Immutable class is good for caching purpose because you don’t need to worry about the value changes.
----> Immutable class is inherently thread-safe, so you don’t need to worry about thread safety in case of multi-threaded environment.
*/
public class Employee {
    private final String empID;
    private final String name;


    public Employee(String empID, String name) {
        this.empID = empID;
        this.name = name;
    }

    public String getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getEmpID().equals(employee.getEmpID());
    }

    @Override
    public int hashCode() {
        return getEmpID().hashCode();
    }
}
