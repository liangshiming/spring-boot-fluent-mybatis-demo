package com.ming.demo;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;
import org.junit.jupiter.api.Test;

/**
 * @Author: lsm
 * @Description:
 * @Date: 2022/5/20 12:43
 * @Version: 1.0
 */
public class EntityGenerator {

	public static final String url =
			"jdbc:mysql://10.115.88.127:3306/clear_settle?useUnicode=true&characterEncoding=utf8";


	@Test
	public void generate() throws Exception {
		FileGenerator.build(Empty.class);
	}

	@Tables(
			// 设置数据库连接信息
			url = url, username = "bill_user", password = "bill_user_password",
			// 设置entity类生成src目录, 相对于 user.dir
			srcDir = "src/main/java",
			// 设置entity类的package值
			basePack = "com.ming.demo.fluent",
			// 设置dao接口和实现的src目录, 相对于 user.dir
			daoDir = "src/main/java",
			//生成的字段按字母序排列:true:字母序; false: 数据库定义顺序
			alphabetOrder = false,
			// 设置哪些表要生成Entity文件
			tables = {@Table(value = {"demo_customer", "demo_biz_note", "demo_biz_activity"})})
	static class Empty {
	}
}
