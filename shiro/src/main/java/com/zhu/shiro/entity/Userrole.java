package com.zhu.shiro.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author 朱桂林 create 2021/2/3 16:14
 */
@Entity
@Data
public class Userrole implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private Integer userid;
	private Integer roleid;
}
