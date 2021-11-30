package studentsManger.students;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @auther xianyue
 * @date 2020/10/28 - 星期三 - 21:42
 **/
public class StudentsFile implements Serializable {
    // 执行操作，并返回处理信息字符串
    private Map<String, Student> students;

    public StudentsFile(){
        this.students = new HashMap<String, Student>();
    }

    public String add(Student stu){
        if (this.students.containsKey(stu.getStudentID())) {
            return students.get(stu.getStudentID()) + "  " + "already exists";
        }
        else{
            this.students.put(stu.getStudentID(), stu);
            return "added successfully";
        }
    }

    public String delete(String stuId){
        if (this.students.containsKey(stuId)){
            Student stu = students.get(stuId);
            this.students.remove(stuId);
            return "deleted successfully";
        }
        else {
            return "There is no student whose student ID is" + "  " + stuId;
        }
    }

    public String change(Student stu){
        String stuId = stu.getStudentID();
        if (this.students.containsKey(stuId)){
            Student old = this.students.get(stuId);
            this.students.put(stuId, stu);
            return "changed successfully";
        }
        else{
            return "There is no student whose student ID is" + "  " + stu.getStudentID();
        }
    }

    public String find(String stuId) {
        if (this.students.containsKey(stuId)) {
            return this.students.get(stuId).toString();
        }
        else {
            return "There is no student whose student ID is" + "  " + stuId;
        }
    }

    public Map<String, Student> getStudents() {
        return students;
    }
}
