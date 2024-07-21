package learning.spring.mybatis.functionTest;

import learning.spring.mybatis.functionTest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/7/21 17:43
 * @Description:
 */
@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public Student getFirstStudent(){
        return studentInfoMapper.getFirstStudent();
    }

    public List<Student> getAllStudents(){
        return studentInfoMapper.getAllStudents();
    }


}
