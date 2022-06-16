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
 * DemoBizNoteEntity: 数据映射实体定义
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
    table = "demo_biz_note",
    schema = "clear_settle"
)
public class DemoBizNoteEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId("id")
  private Long id;

  /**
   * 所属用户ID
   */
  @TableField("customer_id")
  private Long customerId;

  /**
   * 业务类型编码
   */
  @TableField("biz_type_code")
  private String bizTypeCode;

  /**
   * 笔记类型:1-一般,2-信件
   */
  @TableField("note_type")
  private Integer noteType;

  /**
   * 笔记内容
   */
  @TableField("content")
  private String content;

  /**
   * 是否删除:0-删除,1-正常
   */
  @TableField("is_deleted")
  private Boolean isDeleted;

  /**
   * 备注
   */
  @TableField("remark")
  private String remark;

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
    return DemoBizNoteEntity.class;
  }
}
