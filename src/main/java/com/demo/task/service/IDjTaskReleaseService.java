package com.demo.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.task.model.DjTaskRelease;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 任务发布 服务类
 * </p>
 *
 * @author zbf
 * @since 2019-03-07
 */
public interface IDjTaskReleaseService extends IService<DjTaskRelease> {
    public IPage<DjTaskRelease> selectPage(Page<DjTaskRelease> page, Integer state);
}
