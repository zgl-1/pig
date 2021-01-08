/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springmongodb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 朱桂林 create 2021/1/8 16:49
 */
@Setter
@Getter
@ToString
@Document(collection = "comment")
public class Comment implements Serializable {
	//主键标识，该属性的值会自动对应mongodb的主键字段"_id"，如果该属性名就叫“id”,则该注解可以省略，否则必须写
	@Id
	private String id;//主键
	//该属性对应mongodb的字段的名字，如果一致，则无需该注解
	@Field("content")
	private String content;//吐槽内容
	private Date publishtime;//发布日期
	//添加了一个单字段的索引
	@Indexed
	private String userid;//发布人ID
	private String nickname;//昵称
	private LocalDateTime createdatetime;//评论的日期时间
	private Integer likenum;//点赞数
	private Integer replynum;//回复数
	private String state;//状态
	private String articleid;
}
