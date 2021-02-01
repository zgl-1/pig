/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.dao;

import com.zhu.jpa.pojo.UsersExtend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 朱桂林 create 2021/1/25 14:34
 */
public interface UsersExtendDao extends JpaRepository<UsersExtend,Long> {
	@Query(value = "select e from UsersExtend e where (:card is null or e.card = :card) and (:weight is null or e.weight = :weight)")
	List<UsersExtend> findByCardAndAndWeight(String card, Double weight);

	@Query(value = "select e.* from users_extend e where (:card is null or e.card = :card) and (:weight is null or e.weight = :weight)",nativeQuery = true)
	List<UsersExtend> findByCardAndWeight(String card, Double weight);
}
