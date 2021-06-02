
import java.util.*;

public class StudentManager implements Manager<Student>{
    public List<Student> studentList = null;

    public StudentManager() {
        this.studentList = new LinkedList<>();
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void print() {
        for(Student student: studentList) {
            System.out.println(student);
        }
    }
    @Override
    public int findIndex(String id) {
        for(int i =0; i<studentList.size();i++) {
            if(studentList.get(i).getStudentID().equals(id))
                return i;
        }
        return -1;
    }

    @Override
    public void edit(String id, Student student) {
        int studentIndex = findIndex(id);
        if(findIndex(id)==-1) {
            System.out.println("Student not found");
        } else studentList.set(findIndex(id),student);
    }

    @Override
    public void delete(String id) {
        int studentIndex = findIndex(id);
        if (findIndex(id)==-1) {
            System.out.println("Cannot delete because student not found");
        } else studentList.remove(findIndex(id));
    }

    public void findByID(String ID) {
        for(Student student:studentList) {
            if(student.getStudentID().equals(ID)) {
                System.out.println(student + "\n");
            }
        }
    }

    public void findByGender(int gender) {
        for(Student student:studentList) {
            if(student.getStudentGender()==gender) {
                System.out.println(student + "\n");
            }
        }
    }

    public void findByAddress(String address) {
        for(Student student:studentList) {
            if(student.getStudentAddress().equals(address)) {
                System.out.println(student + "\n");
            }
        }
    }

    public void findByAvgScore(double min, double max) {
        for(Student student:studentList) {
            if(student.getStudentAvgScore()>=min && student.getStudentAvgScore()<=max) {
                System.out.println(student + "\n");
            } else {
                System.out.println("No result!");
            }
        }
    }

//    public void findByAgeRange(int age) {
//        for(Student student:studentList) {
//            if(student.getAge())
//        }
//    }
    public void sortByIDIncrease(String ID) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentID().compareTo(o2.getStudentID());
            }
        });
        List<Student> sortByID = new ArrayList<>();
        for(Student student:studentList) {
            sortByID.add(student);
        }
        System.out.println("#Your result: " + sortByID);
    }

    public void sortByName(String name) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        List<Student> sortByName = new ArrayList<>();
        for(Student student: studentList) {
            sortByName.add(student);
        }
        System.out.println("#Your result: " + sortByName);
    }


}