package com.ming.demo;

import com.alibaba.fastjson.JSON;
import com.ming.demo.fluent.mapper.DemoBizActivityMapper;
import com.ming.demo.fluent.mapper.DemoBizNoteMapper;
import com.ming.demo.fluent.mapper.DemoCustomerMapper;
import com.ming.demo.fluent.wrapper.DemoCustomerQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class FluentQueryTest {

	@Resource
	private DemoCustomerMapper demoCustomerMapper;
	@Resource
	private DemoBizActivityMapper demoBizActivityMapper;
	@Resource
	private DemoBizNoteMapper demoBizNoteMapper;

	//select语法
	@Test
	public void testInsert() {
		//select字段
		DemoCustomerQuery customerQuery =
				new DemoCustomerQuery().select.name().formerName().englishName().gmtCreate().gmtModified()
						.end().where.id().eq(1L).end().orderBy.gmtCreate().desc().end();
		List<Map<String, Object>> maps = demoCustomerMapper.listMaps(customerQuery);
		System.out.println(JSON.toJSONString(maps));
	}

	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 9;
		System.out.println(search(nums, target));
	}

	/**
	 * 二分查找
	 * 前提: 1.数组有序;2.数组元素不重复
	 *
	 * @param nums   查询数组
	 * @param target 目标数字
	 * @return
	 */
	private static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
