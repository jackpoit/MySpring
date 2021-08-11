package com.woniuxy.dao.impl;

import com.woniuxy.bean.App;
import com.woniuxy.dao.AppDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 16:59
 * @Description:
 */
public class AppDaoImpl implements AppDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<App> queryApp() {
		String sql = "SELECT * FROM app";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<App>(App.class));
	}

	@Override
	public int deleteApp(int id) {
		String sql = "DELETE FROM app WHERE id=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateApp(App app) {
		String sql = "UPDATE app set app_name=? ,app_size=?,app_type=?,app_platform=?,app_count=?,app_img=?  WHERE id=?";
		return jdbcTemplate.update(sql, app.getAppName(), app.getAppSize(), app.getAppType(), app.getAppPlatform(), app.getAppCount(), app.getAppImg(), app.getId());
	}

	@Override
	public int addApp(App app) {
		String sql = "INSERT INTO app(app_name,app_size,app_type,app_platform,app_count,app_img) VALUE(?,?,?,?,?,?) ";
		return jdbcTemplate.update(sql, app.getAppName(), app.getAppSize(), app.getAppType(), app.getAppPlatform(), app.getAppCount(), app.getAppImg());
	}
}
