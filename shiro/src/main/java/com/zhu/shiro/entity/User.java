package com.zhu.shiro.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 朱桂林 create 2021/2/3 15:28
 */
@Entity
@Data
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String salt;
}
