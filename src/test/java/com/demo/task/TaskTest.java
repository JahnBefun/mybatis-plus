package com.demo.task;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.common.util.PageUtil;
import com.demo.common.util.RedisUtil;
import com.demo.task.mapper.DjTaskReleaseMapper;
import com.demo.task.model.DjTaskRelease;
import com.demo.task.service.IDjTaskReleaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

    @Autowired
    private DjTaskReleaseMapper taskReleaseMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IDjTaskReleaseService taskReleaseService;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<DjTaskRelease> taskList = taskReleaseMapper.selectList(null);
        taskList.forEach(System.out::println);
    }
    @Test
    public void testSelectPage() {
        System.out.println(("----- selectPage method test ------"));
        Page<DjTaskRelease> page = new Page<DjTaskRelease>(1,5);
        IPage<DjTaskRelease> taskPage = taskReleaseService.selectPage(page,0);
        taskPage.getRecords().forEach(System.out::println);
    }
    @Test
    public void testPageUtil() {
        System.out.println(("----- selectPage method test ------"));
        PageUtil<DjTaskRelease> page = new PageUtil<DjTaskRelease>();
        page.setCurrentPage(1);
        page.setPageSize(5);
        IPage<DjTaskRelease> taskPage = taskReleaseService.selectPage( new Page<DjTaskRelease>(page.getCurrentPage(),page.getPageSize()),0);
        page.setTotal(Integer.parseInt(String.valueOf(taskPage.getTotal())));
        page.setRecord(taskPage.getRecords());
        System.out.println(page);
    }

    @Test
    public void testAddKey() {
        DjTaskRelease task = new DjTaskRelease();
        task.setTaskId("12132");
        task.setTaskName("我的任务");
        redisUtil.set("testTaskss",task);
    }
    @Test
    public void testDelKey() {
        redisUtil.get("testTaskss",DjTaskRelease.class);
        redisUtil.del("testTaskss");
    }

}
