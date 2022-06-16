package com.ming.demo;

import com.ming.demo.fluent.entity.DemoBizActivityEntity;
import com.ming.demo.fluent.entity.DemoBizNoteEntity;
import com.ming.demo.fluent.entity.DemoCustomerEntity;
import com.ming.demo.fluent.mapper.DemoBizActivityMapper;
import com.ming.demo.fluent.mapper.DemoBizNoteMapper;
import com.ming.demo.fluent.mapper.DemoCustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class FluentDataInitTest {

  @Resource
  private DemoCustomerMapper demoCustomerMapper;
  @Resource
  private DemoBizActivityMapper demoBizActivityMapper;
  @Resource
  private DemoBizNoteMapper demoBizNoteMapper;

  @Test
  public void testInsert() {
    DemoCustomerEntity customer = new DemoCustomerEntity()
            .setName("张三")
            .setFormerName("小三")
            .setEnglishName("Tom")
            .setPhone("13800000000")
            .setEmail("www.zhangsan@gmail.com")
            .setCompanyId(100L)
            .setPartnerId(100L)
            .setOwnerUser(100L)
            .setIsDeleted(false)
            .setRemark("备注")
            .setCreateUser(100L)
            .setUpdateUser(100L)
            .setPhone("13800000000")
            .setGmtCreate(new Date())
            .setGmtModified(new Date());
    demoCustomerMapper.saveOrUpdate(customer.setId(1L));
  }

  @Test
  public void testInsertActBatch() {
    List<DemoBizActivityEntity> list = Arrays.asList(
            new DemoBizActivityEntity()
                    .setActivityNote(1)
                    .setCompanyId(100L)
                    .setPlanStartTime(new Date())
                    .setPlanEndTime(new Date())
                    .setPublicDescription("这是一个会议")
                    .setRemark("备注")
                    .setDone(false)
                    .setIsDeleted(false)
                    .setGmtCreate(new Date())
                    .setGmtModified(new Date()),
            new DemoBizActivityEntity()
                    .setActivityNote(2)
                    .setCompanyId(100L)
                    .setPlanStartTime(new Date())
                    .setPlanEndTime(new Date())
                    .setPublicDescription("这是一个电话")
                    .setRemark("备注")
                    .setDone(false)
                    .setIsDeleted(false)
                    .setGmtCreate(new Date())
                    .setGmtModified(new Date()));
    demoBizActivityMapper.insertBatch(list);
  }

    @Test
    public void testInsertNoteBatch() {
      List<DemoBizNoteEntity> list = Arrays.asList(
              new DemoBizNoteEntity()
                      .setCustomerId(1L)
                      .setBizTypeCode("随笔")
                      .setNoteType(1)
                      .setContent("这是一个笔记")
                      .setRemark("备注")
                      .setIsDeleted(false)
                      .setGmtCreate(new Date())
                      .setGmtModified(new Date()),
              new DemoBizNoteEntity()
                      .setCustomerId(1L)
                      .setBizTypeCode("随笔")
                      .setNoteType(1)
                      .setContent("这是一个笔记")
                      .setRemark("备注")
                      .setIsDeleted(false)
                      .setGmtCreate(new Date())
                      .setGmtModified(new Date()));
      demoBizNoteMapper.insertBatch(list);
  }
}
