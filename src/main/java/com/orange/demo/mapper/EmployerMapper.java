package com.orange.demo.mapper;

import com.orange.demo.entity.Employer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/1 14:50
 * @description:
 */
@Mapper
public interface EmployerMapper {
    /**
     * @description: 批量插入
     * @author: Li ZhiCheng
     * @date: 2022/9/1 14:51
     * @param: [list]
     * @return: void
     **/
    public Boolean insertBatch(List<Employer> list);

    /**
     * @description: 查询所有员工
     * @author: Li ZhiCheng
     * @date: 2022/9/1 16:20
     * @param: []
     * @return: java.util.List<com.orange.demo.entity.Employer>
     **/
    public List<Employer> selectAll();
}
