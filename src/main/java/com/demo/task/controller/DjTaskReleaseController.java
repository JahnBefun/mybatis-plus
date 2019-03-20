package com.demo.task.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.task.service.IDjTaskReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 任务发布 前端控制器
 * </p>
 *
 * @author zbf
 * @since 2019-03-07
 */
@RestController
@RequestMapping("/task")
public class DjTaskReleaseController {

    @Autowired
    IDjTaskReleaseService taskReleaseService;
    @RequestMapping("/page")
    private Object page(Long current,Long pageSize,Integer state){
        return taskReleaseService.selectPage(new Page(current,pageSize),state);
    }
}
