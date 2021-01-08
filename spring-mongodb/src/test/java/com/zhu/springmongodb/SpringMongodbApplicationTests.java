package com.zhu.springmongodb;

import com.zhu.springmongodb.pojo.Comment;
import com.zhu.springmongodb.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringMongodbApplicationTests {

	@Autowired
	private CommentService commentService;
	@Test
	void contextLoads() {
	}
	@Test
	void commentSave() {
		Comment comment=new Comment();
		comment.setId("11");
		comment.setContent("content");
		comment.setArticleid("11");
		comment.setCreatedatetime(LocalDateTime.now());
		comment.setLikenum(11);
		comment.setNickname("nickname");
		comment.setPublishtime(new Date());
		comment.setReplynum(11);
		comment.setState("1");
		comment.setUserid("11");
		commentService.saveComment(comment);
	}
	@Test
	void commentUpdate() {
		Comment comment = commentService.findCommentById("10");
		System.out.println(comment);
		comment.setContent("pig");
		commentService.updateComment(comment);
		comment = commentService.findCommentById("10");
		System.out.println(comment);
	}
	@Test
	void commentFindAdd() {
		List<Comment> list = commentService.findAddComment();
		for (Comment comment : list) {
			System.out.println(comment);
		}
	}
}
