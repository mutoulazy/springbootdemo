package com.ccsu.example.dao;

import com.ccsu.example.vo.JpaCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 创建dao接口CategoryDAO，继承了JpaRepository，并且提供泛型<Category,Integer> 表示这个是针对Category类的DAO,Integer表示主键是Integer类型。
 * JpaRepository 这个父接口，就提供了CRUD, 分页等等一系列的查询了，直接拿来用.
 * Created by mutoulazy on 2018/3/1.
 */
public interface JpaCategoryDao extends JpaRepository<JpaCategory, Integer>{

}
