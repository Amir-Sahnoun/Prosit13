package levels;

import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Return a string that contains all the names of the teachers in uppercase separated by # */
        String names = teachers.stream().map(teacher -> teacher.getName().toUpperCase()).reduce((name1, name2) -> name1 + "#" + name2).orElse("");

        /* TO DO 2: Return a set of Java teachers whose salary > 80000 */
        Set<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.JAVA && teacher.getSalary() > 80000).collect(Collectors.toSet());

        /* TO DO 3: Return a TreeSet of teachers (sorted by name and in case of equality sorted by salary) */
        TreeSet<Teacher> teachers2 = teachers.stream().collect(Collectors.toCollection(() -> new TreeSet<>((t1, t2) -> {
            int nameComparison = t1.getName().compareTo(t2.getName());
            if (nameComparison != 0) return nameComparison;
            return Integer.compare(t1.getSalary(), t2.getSalary());
        })));

        /* TO DO 4: Return a Map that groups teachers by module */
        Map<Subject, List<Teacher>> map = teachers.stream().collect(Collectors.groupingBy(Teacher::getSubject));

        /* TO DO 5: Return a Map that groups the names of teachers by salary */
        Map<Integer, List<String>> map1 = teachers.stream().collect(Collectors.groupingBy(Teacher::getSalary, Collectors.mapping(Teacher::getName, Collectors.toList())));

        /* TO DO 6: Display the names of teachers of each module */
        map.forEach((subject, teachersList) -> {
            System.out.println("Subject: " + subject);
            teachersList.forEach(teacher -> System.out.println(teacher.getName()));
        });
    }
}
