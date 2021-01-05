package com.generator.service.impl;

import com.generator.service.bo.TableColumnInfoOutBo;
import com.generator.service.TableColumnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TableColumnInfoServiceImpl implements TableColumnInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 获取表的字段信息
     * @param sql 查询表字段信息的sql
     * @return 返回字段信息列表
     */
    @Override
    public List<TableColumnInfoOutBo> getTableColumnInfos(String sql) {
        // 查询表字段信息
        List<TableColumnInfoOutBo> tableColumnInfoOutBos = jdbcTemplate.query(sql, new RowMapper<TableColumnInfoOutBo>() {
            @Override
            public TableColumnInfoOutBo mapRow(ResultSet resultSet, int i) throws SQLException {
                TableColumnInfoOutBo tableColumnInfoOutBo = new TableColumnInfoOutBo();
                tableColumnInfoOutBo.setColumnName(resultSet.getString("columnName"));
                tableColumnInfoOutBo.setDataType(resultSet.getString("dataType"));
                tableColumnInfoOutBo.setColumnComment(resultSet.getString("columnComment"));
                return tableColumnInfoOutBo;
            }
        });
        return tableColumnInfoOutBos;
    }
}
