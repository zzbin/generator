package com.generator.dos.inf;

import com.generator.po.OrdersInBo;
import com.generator.po.OrdersOutBo;

import com.ccb.openframework.persist.PaginationSupport;
import java.util.List;

public interface IOrdersDos {

    /**
     * 查询列表分页
     * @param
     * @return
     */
    PaginationSupport<OrdersOutBo> selectPageList(OrdersInBo inBo);

    /**
     * 新增一条记录
     * @param
     * @return
     */
    int insert(OrdersInBo inBo);

    /**
     * 更新一条信息通过id
     * @param
     * @return
     */
    int updateById(OrdersInBo inBo);

    /**
     * 删除一条信息通过id
     * @param
     * @return
     */
    int deleteById(OrdersInBo inBo);

}
