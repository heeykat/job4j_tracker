package ru.job4j.encapsulation;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSurname("Savchuk");
        student.setName("Katya");
        student.setGroupNumber(437862);
        student.setReceiptDate("23.12.2020");

        System.out.println("student " + student.getSurname() + " " + student.getName() +
                " entered the group number " + student.getGroupNumber() + " on " +
                student.getReceiptDate());
    }
}
