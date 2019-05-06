package com.example.demo.mapper;

import com.example.demo.dto.grade.GradeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface GradeMapper {

    List<GradeResponse> getGradeList(@Param("courseId") String courseId, @Param("date") Date date);

    List<Map<String, Object>> getCourseList();

    List<Map<String, Object>> getTeacherList();

    List<Map<String, Object>> getGradeCourse();

    List<Date> getGradeDate(String courseId);

}
