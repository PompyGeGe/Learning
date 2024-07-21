package learning.spring.mybatis.functionTest;

import learning.spring.mybatis.functionTest.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/7/21 17:44
 * @Description:
 */
@Mapper
public interface StudentInfoMapper {

    @Select("select * from student_info order by id desc limit 1 ")
    Student getFirstStudent();

    List<Student> getAllStudents();
}
