package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.ClubCard;
import com.littlepage.mapper.ClubCardMapper;
/**
 * 会员卡服务
 * @author 74302
 *
 */
@Service
public class ClubCardService {

	@Autowired
	ClubCardMapper clubCardMapper;
	
	public void addClubInfo(int id, String price) {
		clubCardMapper.addClubCard(id,price);
	}

	public String getBalanceById(int id) {
		System.out.println(id);
		ClubCard club=clubCardMapper.getBalanceById(id);
		System.out.println(id);
		return club.getPrices()+"";
	}

	public List<ClubCard> queryAllById(int id) {
		return clubCardMapper.queryAllById(id) ;
	}
}
