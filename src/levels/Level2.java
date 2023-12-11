package levels;

import models.Teacher;
import utils.Data;

import java.util.List;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Return the number of teachers whose name starts with s */
        long nbr = teachers.stream().filter(teacher -> teacher.getName().startsWith("s")).count();

        /* TO DO 2: Return the sum of salaries of all Flutter teachers (hint: mapToInt) */
        long sum = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.FLUTTER).mapToInt(Teacher::getSalary).sum();

        /* TO DO 3: Return the average salary of teachers whose name starts with a */
        double average = teachers.stream().filter(teacher -> teacher.getName().startsWith("a")).mapToInt(Teacher::getSalary).average().orElse(0);

        /* TO DO 4: Return the list of teachers whose name starts with f */
        List<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getName().startsWith("f")).collect(Collectors.toList());

        /* TO DO 5: Return the list of teachers whose name starts with s */
        List<Teacher> teachers2 = teachers.stream().filter(teacher -> teacher.getName().startsWith("s")).collect(Collectors.toList());

        /* TO DO 6: Return true if there is at least one teacher whose salary > 100000, false otherwise */
        boolean test = teachers.stream().anyMatch(teacher -> teacher.getSalary() > 100000);

        /* TO DO 7: Display the first Unity teacher whose name starts with g in two different ways */
        /*First way*/
        teachers.stream().filter(teacher -> teacher.getSubject() == Subject.UNITY && teacher.getName().startsWith("g")).findFirst().ifPresent(System.out::println);
        /*Second way*/
        Optional<Teacher> teacherOptional = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.UNITY && teacher.getName().startsWith("g")).findFirst();
        if (teacherOptional.isPresent()) {
            System.out.println(teacherOptional.get());
        }

        /* TO DO 8: Display the second teacher whose name starts with s */
        teachers.stream().filter(teacher -> teacher.getName().startsWith("s")).skip(1).findFirst().ifPresent(System.out::println);

    }
}
