package com.generator.test;

import com.generator.po.OrdersInBo;
import com.generator.po.OrdersOutBo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class OrdersDosImplTest {

    private static SqlMapClient sqlMapClient = null;

    @BeforeClass
    public static void beforeClass() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
    }

    @Test
    public void selectPageListTest() throws SQLException {
        OrdersInBo inBo = new OrdersInBo();
        //
        inBo.setId("");
        //下单用户id
        inBo.setUserId("");
        //订单号
        inBo.setNumber("");
        //创建订单时间
        inBo.setCreatetime("");
        //备注
        inBo.setNote("");

        List<OrdersOutBo> userOutBoList = sqlMapClient.queryForList("com.generator.dos.impl.orders.selectPageList", inBo);
        System.out.println(userOutBoList);
    }

    @Test
    public void selectPageList_COUNTTest() throws SQLException {
        OrdersInBo inBo = new OrdersInBo();
        //
        inBo.setId("");
        //下单用户id
        inBo.setUserId("");
        //订单号
        inBo.setNumber("");
        //创建订单时间
        inBo.setCreatetime("");
        //备注
        inBo.setNote("");

        int count = (int) sqlMapClient.queryForObject("com.generator.dos.impl.orders.selectPageList_COUNT", inBo);
        System.out.println(count);
    }

    @Test
    public void insertTest() throws SQLException {
        OrdersInBo inBo = new OrdersInBo();
        //
        inBo.setId("");
        //下单用户id
        inBo.setUserId("");
        //订单号
        inBo.setNumber("");
        //创建订单时间
        inBo.setCreatetime("");
        //备注
        inBo.setNote("");

        Object result = sqlMapClient.insert("com.generator.dos.impl.orders.insert", inBo);
        System.out.println(result);
    }

    @Test
    public void updateByIdTest() throws SQLException {
        OrdersInBo inBo = new OrdersInBo();
        //
        inBo.setId("");
        //下单用户id
        inBo.setUserId("");
        //订单号
        inBo.setNumber("");
        //创建订单时间
        inBo.setCreatetime("");
        //备注
        inBo.setNote("");

        int result = sqlMapClient.update("com.generator.dos.impl.orders.updateById", inBo);
        System.out.println(result);
    }

    @Test
    public void deleteByIdTest() throws SQLException {
        OrdersInBo inBo = new OrdersInBo();
        //
        inBo.setId("");
        //下单用户id
        inBo.setUserId("");
        //订单号
        inBo.setNumber("");
        //创建订单时间
        inBo.setCreatetime("");
        //备注
        inBo.setNote("");

        int result = sqlMapClient.delete("com.generator.dos.impl.orders.deleteById", inBo);
        System.out.println(result);
    }

}
