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
 * DemoCustomerEntity: 数据映射实体定义
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
    table = "demo_customer",
    schema = "clear_settle"
)
public class DemoCustomerEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId("id")
  private Long id;

  /**
   * 用户名
   */
  @TableField("name")
  private String name;

  /**
   * 昵称
   */
  @TableField("former_name")
  private String formerName;

  /**
   * 英文名
   */
  @TableField("english_name")
  private String englishName;

  /**
   * 手机
   */
  @TableField("phone")
  private String phone;

  /**
   * 邮箱
   */
  @TableField("email")
  private String email;

  /**
   * 归属组织ID
   */
  @TableField("company_id")
  private Long companyId;

  /**
   * 父级ID
   */
  @TableField("partner_id")
  private Long partnerId;

  /**
   * 所属用户
   */
  @TableField("owner_user")
  private Long ownerUser;

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
   * 创建用户
   */
  @TableField("create_user")
  private Long createUser;

  /**
   * 更新用户
   */
  @TableField("update_user")
  private Long updateUser;

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
    return DemoCustomerEntity.class;
  }
}
