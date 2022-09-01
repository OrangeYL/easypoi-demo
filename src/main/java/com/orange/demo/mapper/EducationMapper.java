package com.orange.demo.mapper;

import com.orange.demo.entity.Education;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/1 15:28
 * @description:
 */
@Mapper
public interface EducationMapper {


    public Boolean insertBatch(List<Education> list);

    public List<Education> selectByEmployerId(int employerId);
}
