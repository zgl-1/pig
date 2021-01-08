/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springmongodb.dao;

import com.zhu.springmongodb.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 朱桂林 create 2021/1/8 16:55
 */
@Repository("commentDao")
public interface CommentDao extends MongoRepository<Comment,String> {
}
