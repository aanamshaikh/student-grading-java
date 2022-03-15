package in.one2n.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static in.one2n.exercise.Grade.F;

public class Grader {

    public List<Student> parseCSV(String filepath) {
        // TODO: add your implementation here

        List<Student> students = new ArrayList<>();
        BufferedReader reader ;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                students.add(new Student(values[0],values[1],values[2],
                        Double.valueOf(values[3]),Double.valueOf(values[4]),
                        Double.valueOf(values[5]),Double.valueOf(values[6])));
            }
            reader.close();
            return students;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<Student> calculateGrade(List<Student> students) {
        // TODO: add your implementation here
        if(!students.isEmpty()) {
            for (Student s : students) {
                Double score = s.getFinalScore();
                if (score < 35) {
                    s.setGrade(F);
                }
               else if (score >= 35 && score < 50 ) {
                    s.setGrade(Grade.C);
                }
                else if( score  >= 50 && score < 70) {
                    s.setGrade(Grade.B);
                }else {
                    s.setGrade(Grade.A);
                }
            }
            return students;
        }
         return Collections.emptyList();
    }

    public Student findOverallTopper(List<Student> gradedStudents) {
        // TODO: add your implementation here

        Collections.sort(gradedStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFinalScore().compareTo(o2.getFinalScore());
            }
        });

        return gradedStudents.get(gradedStudents.size()-1);
    }

    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {
        HashMap<String,Student> map = new HashMap<>();
        // TODO: add your implementation her

        Comparator<Student> c = Comparator.comparing(Student::getUniversity).
                thenComparing(Student::getFinalScore);
        Collections.sort(gradedStudents,c);
        for(Student str: gradedStudents) {
            map.put(str.getUniversity(),str);
        }
        if(!map.isEmpty()) {
            return map;
        }

         return new HashMap<>();
    }
}
