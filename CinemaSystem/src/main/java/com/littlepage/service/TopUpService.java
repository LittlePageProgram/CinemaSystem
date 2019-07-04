package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 充值记录服务类
 * @author 74302
 *
 */

import com.littlepage.entity.TopUp;
import com.littlepage.mapper.TopUpMapper;
@Service
public class TopUpService {
	
	@Autowired
	TopUpMapper topUpMapper;
	
	public void addInfo(int id, String info) {
		topUpMapper.addInfo(id,info);
	}

	public List<TopUp> getAllInfo(int id) {
		return topUpMapper.getAllInfo(id);
	}

}
