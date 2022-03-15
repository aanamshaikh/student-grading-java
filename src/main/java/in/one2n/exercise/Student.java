package in.one2n.exercise;

public class Student {

    private String firstname;
    private String lastname;
    private String university;
    private Double test1Score;
    private Double test2Score;
    private Double test3Score;
    private Double test4Score;

    // computed fields
    private Double finalScore;
    private Grade grade;

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getUniversity() {
        return this.university;
    }

    public Student(String firstname, String lastname, String university) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;

    }

    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score, Double test3Score, Double test4Score) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
        this.test1Score = test1Score;
        this.test2Score = test2Score;
        this.test3Score = test3Score;
        this.test4Score = test4Score;
    }

    public Double getFinalScore() {
        // TODO: add your implementation here
        Double total =  this.test1Score + this.test2Score + this.test3Score + this.test4Score;
        return total/4;
    }

    public Grade getGrade() {
        // TODO: add your implementation here
        return this.grade ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Student))
            return false;
        Student st = (Student) obj;
        return st.firstname.equals(firstname) && st.lastname.equals(lastname)
                && st.university.equals(university);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", university='" + university + '\'' +
                ", test1Score=" + test1Score +
                ", test2Score=" + test2Score +
                ", test3Score=" + test3Score +
                ", test4Score=" + test4Score +
                ", finalScore=" + finalScore +
                ", grade=" + grade +
                '}';
    }

}

