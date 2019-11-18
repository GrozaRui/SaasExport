package com.rui.dao.company;

import com.rui.domain.company.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: dao层接口
 * @author: caihongrui
 * @createtime: 2019-11-14 17:42
 **/
public interface CompanyDao {

    //查询所有数据
    public List<Company> findAll();

    //根据id查询数据
    public Company findById(String id);

    //保存数据
    public void save(Company company);

    //修改数据
    public void update(Company company);

    //删除数据
    public void delete(String id);

    //查询总记录数
    public long findCount();

    //查询数据列表 param -- 相当于对sql映射文件传递了一个map集合
    public List findByPage(@Param("index") int page, @Param("size") int size);

}
