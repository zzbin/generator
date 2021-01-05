package com.generator.service;

import com.generator.service.bo.TableColumnInfoOutBo;

import java.util.List;

public interface TableColumnInfoService {

    /**
     * 获取表的字段信息
     * @param sql 查询表字段信息的sql
     * @return 返回字段信息列表
     */
    List<TableColumnInfoOutBo> getTableColumnInfos(String queryColumnInfoSql);
}
