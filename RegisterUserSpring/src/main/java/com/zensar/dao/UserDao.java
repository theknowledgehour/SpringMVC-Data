package com.zensar.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.zensar.training.beans.User;  
  
public class UserDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(User p){  
    String sql="insert into users(name,salary,designation) values('"+p.getName()+"')";  
    return template.update(sql);  
}  
public int update(User p){  
    String sql="update users set name='"+p.getName()+"'where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from users where id="+id+"";  
    return template.update(sql);  
}  
public User getEmpById(int id){  
    String sql="select * from users where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));  
}  
public List<User> getEmployees(){  
    return template.query("select * from users",new RowMapper<User>(){  
        public User mapRow(ResultSet rs, int row) throws SQLException {  
            User e=new User();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            
            return e;  
        }  
    });  
}  
}  