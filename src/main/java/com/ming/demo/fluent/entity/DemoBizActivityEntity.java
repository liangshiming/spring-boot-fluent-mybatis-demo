package com.ming.demo.fluent.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * DemoBizActivityEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "demo_biz_activity",
    schema = "clear_settle"
)
public class DemoBizActivityEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId("id")
  private Long id;

  /**
   * 活动标签:1-会议,2-电话,3-聚餐
   */
  @TableField("activity_note")
  private Integer activityNote;

  /**
   * 归属组织ID
   */
  @TableField("company_id")
  private Long companyId;

  /**
   * 活动开始时间
   */
  @TableField("plan_end_time")
  private Date planEndTime;

  /**
   * 活动结束时间
   */
  @TableField("plan_start_time")
  private Date planStartTime;

  /**
   * 公共描述
   */
  @TableField("public_description")
  private String publicDescription;

  /**
   * 备注
   */
  @TableField("remark")
  private String remark;

  /**
   * 是否完成:0-否,1-是
   */
  @TableField("done")
  private Boolean done;

  /**
   * 是否删除:0-删除,1-正常
   */
  @TableField("is_deleted")
  private Boolean isDeleted;

  /**
   * 创建时间
   */
  @TableField("gmt_create")
  private Date gmtCreate;

  /**
   * 更新时间
   */
  @TableField("gmt_modified")
  private Date gmtModified;

  @Override
  public final Class entityClass() {
    return DemoBizActivityEntity.class;
  }
}
