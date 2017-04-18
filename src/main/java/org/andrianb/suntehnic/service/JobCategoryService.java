package org.andrianb.suntehnic.service;

import org.andrianb.suntehnic.domain.JobCategory;
import org.andrianb.suntehnic.repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrianb on 4/12/2017.
 */
@Service
@Transactional
public class JobCategoryService {

    @Autowired
    JobCategoryRepository jobCategoryRepository;



    public List<JobCategory> findAll() {
        return jobCategoryRepository.findAll();
    }

    public JobCategory findOne(Long id) {
        return jobCategoryRepository.findOne(id);
    }
}
