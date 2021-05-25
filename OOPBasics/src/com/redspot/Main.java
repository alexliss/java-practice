package com.redspot;

public class Main {

    // 1, 2, 3, 4
    public static void main(String[] args) {
        try {
            // 1, 2, 3, 4
            Employee[] employees = new Employee[5];
            employees[0] = new Employee("Василий Великий", "Чесатель Подмышек", "vasyan@mail.ru",
                    "88005553535", 1500, 45);
            employees[1] = new Employee("Елизавета Лакмус", "Уборщица", "lizzzka@ya.ru",
                    "588533", 9500, 18);
            employees[2] = new Employee("Игорь Папусов", "Джава Джуниор", "prigoryan@gmail.com",
                    "79132288314", 40000, 22);
            employees[3] = new Employee("Эдуард Сухой", "Фотограф", "photobyedik@list.ru",
                    "225348", 34500, 56);
            employees[4] = new Employee("Кристина Товарищ", "Охранник", "walderwaltz@yahoo.com",
                    "567823", 20000, 41);

            for (Employee employee : employees) {
                if (employee.getAge() >= 40) {
                    System.out.println(employee.toString());
                }
            }

            // 5, 6, 7, 8, 9

            Animal[] animals = new Animal[4];
            animals[0] = new Cat("Морда");
            animals[1] = new Cat("Мурик", 1);
            animals[2] = new Dog("Барон");
            animals[3] = new Dog("Креветка", 150);

            for (Animal animal : animals) {
                System.out.println(animal.getName());
                animal.run(175);
                animal.jump(1.5f);
                animal.swim(5);
            }

            Cat[] cats = new Cat[5];
            cats[0] = (Cat) animals[0];
            cats[1] = (Cat) animals[1];
            cats[2] = new Cat("Сосиса");
            cats[3] = new Cat("Франц Фердинанд");
            cats[4] = new Cat("Цитрус");

            Bowl bowl = new Bowl();
            System.out.println(bowl.toString());

            for (Cat cat : cats) {
                System.out.println(cat.toString());
                cat.eat(bowl);
            }

            System.out.println(bowl.toString());
            
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }


}
