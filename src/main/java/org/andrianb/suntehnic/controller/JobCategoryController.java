package org.andrianb.suntehnic.controller;

import org.andrianb.suntehnic.domain.Job;
import org.andrianb.suntehnic.domain.JobCategory;
import org.andrianb.suntehnic.service.JobCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Andrian on 4/13/2017.
 */

@Controller
@RequestMapping("api/v1/")
public class JobCategoryController {
    @Autowired
    JobCategoryService jobCategoryService;

    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public ResponseEntity<List<JobCategory>> list() {
         return new ResponseEntity<List<JobCategory>>(jobCategoryService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public JobCategory get(@PathVariable Long id) {
        return jobCategoryService.findOne(id);
    }


}

