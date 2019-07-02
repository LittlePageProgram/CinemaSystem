package com.littlepage.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.ClubCard;
/**
 * 会员卡Mapper接口
 * @author 74302
 *
 */
@Mapper
public interface ClubCardMapper {

	void addClubCard(int id, String price);

	ClubCard getBalanceById(int id);

}
