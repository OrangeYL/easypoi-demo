package com.orange.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/1 11:01
 * @description:
 */
@Data
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private Integer id;

    @ExcelIgnore
    private Integer employerId;

    @Excel(name = "学校*")
    private String schoolName;

    @Excel(name = "学历*", replace = {"初中及以下_1", "中专_2", "高中_3", "大专_4", "本科_5", "硕士_6", "博士_7"})
    private Integer record;

    @Excel(name = "开始年份*")
    private Date beginTime;

    @Excel(name = "毕业年份*")
    private Date finishTime;

    @Excel(name = "专业*")
    private String profession;

}
