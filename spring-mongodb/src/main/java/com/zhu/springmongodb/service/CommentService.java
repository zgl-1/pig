/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springmongodb.service;

import com.zhu.springmongodb.dao.CommentDao;
import com.zhu.springmongodb.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author 朱桂林 create 2021/1/8 16:57
 */
@Service("commentService")
public class CommentService {
	@Autowired
	private CommentDao commentDao;

	public void saveComment(Comment comment){
		commentDao.save(comment);
	}
	public void updateComment(Comment comment){
		commentDao.save(comment);
	}

	public List<Comment> findAddComment(){
		return commentDao.findAll();
	}

	public Comment findCommentById(String id){
		return commentDao.findById(id).get();
	}
}
