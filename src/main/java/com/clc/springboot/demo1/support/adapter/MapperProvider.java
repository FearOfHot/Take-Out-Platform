package com.clc.springboot.demo1.support.adapter;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

import java.util.Iterator;
import java.util.Set;


public class MapperProvider extends BaseUpdateProvider {
    public MapperProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String updateByPrimaryKeyProperty(MappedStatement ms) {
        return getSQLString(ms);
    }

    public String updatePropertyByPrimaryKey(MappedStatement ms) {
        return getSQLString(ms);
    }

    private String getSQLString(MappedStatement ms) {
        Class entityClass = this.getEntityClass(ms);
        return SqlHelper.updateTable(entityClass, this.tableName(entityClass)) +
                this.updateSetColumns(entityClass) +
                this.wherePKColumns(entityClass);
    }


    private String wherePKColumns(Class<?> entityClass) {
        StringBuilder sql = new StringBuilder();
        sql.append("<where>");
        Set columnList = EntityHelper.getPKColumns(entityClass);

        for (Object o : columnList) {
            EntityColumn column = (EntityColumn) o;
            sql.append(" AND ").append(column.getColumnEqualsHolder("entity"));
        }

        sql.append("</where>");
        return sql.toString();
    }


    private String updateSetColumns(Class<?> entityClass) {
        StringBuilder sql = new StringBuilder();
        sql.append("<set>");
        Set columnList = EntityHelper.getColumns(entityClass);
        Iterator iterator = columnList.iterator();

        while(iterator.hasNext()) {
            EntityColumn column = (EntityColumn)iterator.next();
            if (!column.isId() && column.isUpdatable()) {
                sql.append(this.updateProperty(column, column.getColumnEqualsHolder("entity") + ","));
            }
        }

        sql.append("</set>");
        return sql.toString();
    }
    private String updateProperty(EntityColumn column, String contents) {
        StringBuilder sql = new StringBuilder();
        sql.append("<if test=\"")
                .append("property.contains('")
                .append(column.getProperty()).append("')")
                .append("\">")
                .append(contents)
                .append("</if>");
        return sql.toString();
    }
}
