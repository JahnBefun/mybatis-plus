package com.demo.task.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.task.model.DjTaskRelease;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 任务发布 Mapper 接口
 * </p>
 *
 * @author zbf
 * @since 2019-03-07
 */
public interface DjTaskReleaseMapper extends BaseMapper<DjTaskRelease> {

    IPage<DjTaskRelease> selectPageVo(Page page, @Param("state") Integer state);
}
