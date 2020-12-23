package GeekBrains.Level1.Lesson5.Homework;

public class Task5 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов Иван Иванович", "Стажер-программист", "1@mail.ru", "89996663322", "20000", 20),
                new Employee("Сергеев Сергей Сергеевич", "Стажер-программист", "12@mail.ru", "89996664455", "20000", 22),
                new Employee("Кузвецов Кирилл Вадимович", "Программист", "123@mail.ru", "89918863322", "45000", 21),
                new Employee("Богданов Марк Александрович", "Ведущий программист", "1234@mail.ru", "89057763322", "180000", 41),
                new Employee("Евдокимов Петр Евгеньевич", "Senior-программист", "123456@mail.ru", "89991111111", "250000", 45),
        };

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }
}
