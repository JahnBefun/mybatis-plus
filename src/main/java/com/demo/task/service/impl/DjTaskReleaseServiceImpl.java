package com.demo.task.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.task.model.DjTaskRelease;
import com.demo.task.mapper.DjTaskReleaseMapper;
import com.demo.task.service.IDjTaskReleaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务发布 服务实现类
 * </p>
 *
 * @author zbf
 * @since 2019-03-07
 */
@Service
public class DjTaskReleaseServiceImpl extends ServiceImpl<DjTaskReleaseMapper, DjTaskRelease> implements IDjTaskReleaseService {

    @Autowired
    private DjTaskReleaseMapper taskReleaseMapper;

    public IPage<DjTaskRelease> selectPage(Page<DjTaskRelease> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return taskReleaseMapper.selectPageVo(page, state);
    }
}
