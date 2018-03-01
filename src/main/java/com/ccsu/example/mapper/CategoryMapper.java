package com.ccsu.example.mapper;

import com.ccsu.example.vo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mutoulazy on 2018/3/1.
 */
@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category> findAll();
}
