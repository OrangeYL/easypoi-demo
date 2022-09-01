package com.orange.demo.service.impl;

import com.orange.demo.entity.Education;
import com.orange.demo.entity.Employer;
import com.orange.demo.mapper.EducationMapper;
import com.orange.demo.mapper.EmployerMapper;
import com.orange.demo.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/1 15:10
 * @description:
 */
@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerMapper employerMapper;

    @Autowired
    private EducationMapper educationMapper;

    @Override
    public Boolean insertBatch(List<Employer> list) {
        employerMapper.insertBatch(list);
        for(Employer employer:list){
            List<Education> educationList = employer.getEducationList();
            for(Education education:educationList){
                education.setEmployerId(employer.getId());
            }
            educationMapper.insertBatch(educationList);
        }
        return true;
    }

    @Override
    public List<Employer> selectAll() {
        List<Employer> employers = employerMapper.selectAll();
        for(Employer employer:employers){
            List<Education> educations = educationMapper.selectByEmployerId(employer.getId());
            employer.setEducationList(educations);
        }
        return employers;
    }
}
