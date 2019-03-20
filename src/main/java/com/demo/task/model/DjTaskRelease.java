package com.demo.task.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务发布
 * </p>
 *
 * @author zbf
 * @since 2019-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dj_task_release")
public class DjTaskRelease implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务主键
     */
    private String taskId;

    /**
     * 任务id
     */
    private String projectId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 是否冻结 0：未冻结、1：冻结 
     */
    private Integer freeze;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 任务类型 1：周期、2:手动
     */
    private Integer type;

    /**
     * 调度类型 1:分钟 2:小时 3:天 4:周 5:月 6:年
     */
    private Integer scheduleType;

    /**
     * 责任人
     */
    private String dutyPerson;

    /**
     * 责任人id
     */
    private String dutyPersonId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 任务表达式
     */
    private String cron;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 报警设置标志 0:未设置 1:已设置
     */
    private Integer alarmSet;

    /**
     * 上游任务id 多个用“,”号隔开
     */
    private String parentTask;

    /**
     * 周期依赖关系 1:不依赖上一周期调度关系 2:自依赖,等上一周期调度结束再运行 3:等下游任务的上一周期结束，才能继续运行
     */
    private Integer dependRelation;


}
