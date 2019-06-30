package com.littlepage.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.littlepage.entity.Film;
import com.littlepage.service.FilmService;

/**
 * 图片处理过滤器
 * @author 74302
 * @annoation 首次加载把数据库图片读进服务器,只需要在图片过滤器中对所有数据库原有文件进行保存
 */
@WebFilter("/*")
@Component
public class PictureLoadFilter implements Filter{
	
	@Autowired
	FilmService fs;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		List<Film> liFm=fs.findAll();
//		for (Film film : liFm) {
//			fs.savePic(film.getPosterLink());
//		}
	}
}
