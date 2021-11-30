package studentsManger.students;

import java.io.Serializable;

/**
 * @auther xianyue
 * @date 2020/11/12 - 星期四 - 23:18
 **/
public class Student implements Serializable {
    private String studentID;
    private String studentName;
    private String stuSex;

    Student() {
        this.studentID = "未知";
        this.studentName = "未知";
        this.stuSex = "未知";
    }

    public Student(String studentID, String studentName, String sex) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.stuSex = sex;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStuSex() {
        return stuSex;
    }

    @Override
    public String toString() {
        return  "Student{" +
                "ID='" + studentID + '\'' +
                ", Name='" + studentName + '\'' +
                ", Sex='" + stuSex + '\'' +
                '}';
    }
}
