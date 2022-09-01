package com.orange.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.orange.demo.entity.Employer;
import com.orange.demo.service.EmployerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/1 15:11
 * @description:
 */

@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/import")
    public Boolean importExcel(@RequestParam("file") MultipartFile file){
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(2);
        List<Employer> employers=null;
        try {
            employers = ExcelImportUtil.importExcel(file.getInputStream(), Employer.class, importParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employerService.insertBatch(employers);
    }

    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response){
        List<Employer> employers = employerService.selectAll();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 设置防止中文名乱码
        String filename = null;
        try {
            filename = URLEncoder.encode("用户列表", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 文件下载方式(附件下载还是在当前浏览器打开)
        response.setHeader("Content-disposition",
                "attachment;filename=" + filename + ".xls");

        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("用户信息");
        exportParams.setTitle("员工信息");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, Employer.class, employers);
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
