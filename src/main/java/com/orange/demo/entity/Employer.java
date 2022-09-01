package com.orange.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/1 11:00
 * @description:
 */
@Data
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private Integer id;

    @Excel(name = "姓名*")
    private String name;

    @Excel(name = "性别*",replace = {"男_0", "女_1"})
    private Integer gender;

    @Excel(name = "手机号*")
    private String phone;

    @Excel(name = "开始工作时间*")
    private Date workTime;

    @Excel(name = "民族*")
    private String national;

    @Excel(name = "语言水平*")
    private String languageProficiency;

    @Excel(name = "出生日期*")
    private Date birth;

    @Excel(name = "职位*")
    private String jobsName;

    @Excel(name = "职位类型*")
    private String categoryName;

    @Excel(name = "薪资*",replace = {"3K以下_1", "3K-5K_2", "5K-10K_3", "10K-20K_4", "20K-50K_5", "50K以上_6"})
    private Integer salary;

    @Excel(name = "工作地点*")
    private String workArea;

    @ExcelCollection(name = "教育经历*")
    private List<Education> educationList;


}
