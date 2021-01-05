package com.generator.dos.impl;

import com.generator.po.OrdersInBo;
import com.generator.po.OrdersOutBo;
import com.generator.dos.inf.IOrdersDos;
import com.ccb.cms.pub.data.doc.inf.IBaseDos;

import com.ccb.openframework.persist.PaginationSupport;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("OrdersDosImpl")
public class OrdersDosImpl extends IBaseDos implements IOrdersDos {

    /**
     * 查询列表分页
     * @param
     * @return
     */
    @Override
    public PaginationSupport<OrdersOutBo> selectPageList(OrdersInBo inBo){
        return (PaginationSupport<OrdersOutBo>)_dos.findPaginatedBySqlMap("com.generator.dos.impl.orders.selectPageList", inBo, inBo.getPagination().getStart(), inBo.getPagination().getRecInPage());
    }

    /**
     * 新增一条记录
     * @param
     * @return
     */
    @Override
    public int insert(OrdersInBo inBo){
        return _dos.insertBySqlMap("com.generator.dos.impl.orders.insert", inBo);
    }

    /**
     * 更新一条信息通过id
     * @param
     * @return
     */
    @Override
    public int updateById(OrdersInBo inBo){
        return _dos.updateBySqlMap("com.generator.dos.impl.orders.insert", inBo);
    }

    /**
     * 删除一条信息通过id
     * @param
     * @return
     */
    @Override
    public int deleteById(OrdersInBo inBo){
        return _dos.deleteBySqlMap("com.generator.dos.impl.orders.insert", inBo);
    }
}
