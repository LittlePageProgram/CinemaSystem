package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.FilmLike;
import com.littlepage.entity.FilmLikeCount;

/**
 * 电影喜欢的mybatis接口
 * @author 74302
 *
 */
@Mapper
public interface FilmLikeMapper {

	List<FilmLike> findAll(int uid, int fid);

	void addFilmLike(int uid, int fid, String date);

	void deleteFilmLike(int uid, int fid);
	
	List<FilmLikeCount> filmLikeCount();
	
}
