package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.FilmLike;
import com.littlepage.entity.User;
import com.littlepage.mapper.FilmLikeMapper;
/**
 * 电影喜好服务
 * @author 74302
 *
 */
@Service
public class FilmLikeService {

	@Autowired
	FilmLikeMapper filmLikeMapper;
	
	/**
	 * 检测user是否喜欢id的电影,喜欢为true
	 * @param user
	 * @param id
	 * @return
	 */
	public boolean testLike(User user, int id) {
		List<FilmLike> fl=filmLikeMapper.findAll(user.getId(),id);
		return fl.size()!=0;
	}

	public List<FilmLike> findAll(int uid, int fid) {
		List<FilmLike> fl=filmLikeMapper.findAll(uid, fid);
		return fl;
	}

	public void addFilmLike(int uid, int fid) {
		filmLikeMapper.addFilmLike(uid,fid);
	}

	public void deleteFilmLike(int uid, int fid) {
		filmLikeMapper.deleteFilmLike(uid,fid);
	}
	
}
