/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.message.service;

import java.util.Map;

/**
 * @author 朱桂林 create 2020/11/7 17:05
 */
public interface MessageService {
	boolean sendMessage(String phoneNumbers, String templateCode, Map<String,Object> code);
}
