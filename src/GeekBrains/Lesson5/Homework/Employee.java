
package GeekBrains.Lesson5.Homework;

public class Employee {
    private String FCS;
    private String position;
    private String email;
    private String telephoneNumber;
    private String salary;
    private int age;

    public Employee() {

    }

    public int getAge(){
        return this.age;
    }

    public Employee(String FCS, String position, String email, String telephoneNumber, String salary, int age) {
        this.FCS = FCS;
        this.position = position;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник %s.\n" +
                "Должность: %s\n" +
                "Электронная почта: %s\n" +
                "Номер телефона: %s\n" +
                "Размер зарплаты: %s\n" +
                "Возраст: %d\n", FCS, position, email, telephoneNumber, salary, age);
    }
}
