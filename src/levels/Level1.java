package levels;

import models.Teacher;
import utils.Data;

import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Display all teachers
         */
        teachers.stream().forEach(teacher -> System.out.println(teacher));

        /*
         * TO DO 2: Display teachers whose name starts with the letter n
         */
        teachers.stream().filter(teacher -> teacher.getName().startsWith("n")).forEach(System.out::println);

        /*
         * TO DO 3: Display teachers whose name starts with the letter n and salary > 100000
         */
        teachers.stream().filter(teacher -> teacher.getName().startsWith("n") && teacher.getSalary() > 100000).forEach(System.out::println);

        /*
         * TO DO 4: Display JAVA teachers sorted by salary (eliminate redundancies)
         */
        teachers.stream().filter(teacher -> teacher.getSubject() == Subject.JAVA).distinct().sorted((t1, t2) -> Integer.compare(t2.getSalary(), t1.getSalary())).forEach(System.out::println);

        /*
         * TO DO 5: Display the names of teachers whose salary > 60000 in two different ways
         */

        /* First Way */
        teachers.stream().filter(teacher -> teacher.getSalary() > 60000).forEach(teacher -> System.out.println(teacher.getName()));
        /* Second Way */
        teachers.stream().filter(teacher -> teacher.getSalary() > 60000).map(Teacher::getName).forEach(System.out::println);

        /*
         * TO DO 6: Add 200 Dt for teachers whose name starts with m and display the one with the highest salary
         */
        teachers.stream().filter(teacher -> teacher.getName().startsWith("m")).peek(teacher -> teacher.setSalary(teacher.getSalary() + 200)).max((t1, t2) -> Integer.compare(t1.getSalary(), t2.getSalary())).ifPresent(System.out::println);

    }
}
