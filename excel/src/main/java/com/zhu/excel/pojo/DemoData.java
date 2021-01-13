/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.excel.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 朱桂林 create 2021/1/13 9:40
 */
@Data
public class DemoData {
	@ExcelProperty("字符串标题")
	private String string;
	@ExcelProperty("日期标题")
	private Date date;
	@ExcelProperty("数字标题")
	private Double doubleData;
	/**
	 * 忽略这个字段
	 */
	@ExcelIgnore
	private String ignore;
}
