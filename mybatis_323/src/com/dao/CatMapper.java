package com.dao;

import org.apache.ibatis.annotations.Param;

import com.pojo.Cat;

public interface CatMapper {

  public Cat findCatByName(@Param("name") String name);

  
}
