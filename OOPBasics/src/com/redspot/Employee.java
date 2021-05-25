package com.redspot;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int wage;
    private int age;

    public Employee(String name, String position, String email, String phone, int wage, int age) throws Exception {
        setName(name);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setWage(wage);
        setAge(age);
    }

    public void setName(String name) throws Exception{
        if (name == null || name.equals("")) {
            throw new Exception("Некорректное имя сотрудника");
        }
        this.name = name;
    }

    public void setPosition(String position) throws Exception{
        if (position == null || position.equals("")) {
            throw new Exception("Некорректная должность сотрудника");
        }
        this.position = position;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || email.equals("")) {
            throw new Exception("Некорректный email");
        }
        this.email = email;
    }

    public void setPhone(String phone) throws Exception {
        if (phone == null || phone.equals("")) {
            throw new Exception("Некорректный номер телефона");
        }
        this.phone = phone;
    }

    public void setWage(int wage) throws Exception {
        if (wage <= 0) {
            throw new Exception("Некорректная заработная плата");
        }
        this.wage = wage;
    }

    public void setAge(int age) throws Exception {
        if (age < 14 || age > 120) {
            throw new Exception("Некорректный возраст сотрудника");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getWage() {
        return wage;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Сотрудник: \n" +
                " Имя: " + name + '\n' +
                " Должность: " + position + '\n' +
                " Электронная почта: " + email + '\n' +
                " Телефон: " + phone + '\n' +
                " Зарплата: " + wage + '\n' +
                " Возраст: " + age + '\n';
    }
}
