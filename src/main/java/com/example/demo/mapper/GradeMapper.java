package com.example.demo.mapper;

import com.example.demo.dto.grade.GradeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface GradeMapper {

    List<GradeResponse> getGradeList(@Param("courseId") String courseId, @Param("date") Date date);
}
