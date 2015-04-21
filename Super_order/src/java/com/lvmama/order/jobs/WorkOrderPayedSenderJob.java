package com.lvmama.order.jobs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lvmama.comm.bee.po.ord.OrdOrder;
import com.lvmama.comm.bee.service.ord.OrderService;
import com.lvmama.comm.bee.vo.ord.CompositeQuery;
import com.lvmama.comm.bee.vo.ord.CompositeQuery.OrderContent;
import com.lvmama.comm.bee.vo.ord.CompositeQuery.OrderIdentity;
import com.lvmama.comm.bee.vo.ord.CompositeQuery.OrderStatus;
import com.lvmama.comm.bee.vo.ord.CompositeQuery.OrderTimeRange;
import com.lvmama.comm.bee.vo.ord.CompositeQuery.PageIndex;
import com.lvmama.comm.bee.vo.ord.CompositeQuery.SortTypeEnum;
import com.lvmama.comm.utils.DateUtil;
import com.lvmama.comm.vo.Constant;
import com.lvmama.comm.work.builder.WorkOrderSenderBiz;

public class WorkOrderPayedSenderJob implements Runnable {

	private static Log log = LogFactory.getLog(WorkOrderPayedSenderJob.class);

	private WorkOrderSenderBiz workOrderSenderProxy;

	private OrderService orderServiceProxy;

	/**
	 * 综合查询类.
	 */
	private CompositeQuery compositeQuery;
	/**
	 * 根据id查询相关参数.
	 */
	private OrderIdentity orderIdentity;
	/**
	 * 根据时间范围查询相关参数
	 */
	private OrderTimeRange orderTimeRange;
	/**
	 * 根据状态查询相关参数.
	 */
	private OrderStatus orderStatus;
	/**
	 * 根据订单内容查询相关参数.
	 */
	private OrderContent orderContent;
	/**
	 * 分页相关参数.
	 */
	private PageIndex pageIndex;
	/**
	 * 排序的相关参数.
	 */
	private List<SortTypeEnum> typeList;

	/**
	 * 支付后提醒发系统工单给客服
	 * */
	public void run() {
		if (Constant.getInstance().isJobRunnable()) {
			log.info("Auto WorkOrderPayedSenderJob running.....");
			
			/*Date tarDate = new Date("2013/08/17");
			Date curDate = new Date();
			
			if (curDate.after(tarDate)) {
				return;
			}*/

			// 按条件获取订单
			getCompositeQuery();
			List<OrdOrder> ordersList = orderServiceProxy
					.compositeQueryOrdOrder(compositeQuery);

			for (OrdOrder ordOrder : ordersList) {
					// 支付后提醒（客服）
				workOrderSenderProxy.sendWorkOrder(ordOrder,
						Constant.WORK_ORDER_TYPE_AND_SENDGROUP.ZFHTX
								.getWorkOrderTypeCode(), "", Boolean.FALSE,
						Boolean.FALSE, null, null, null, null, null, false);

				// 已支付提醒（计调）
				workOrderSenderProxy.sendWorkOrder(ordOrder,
						Constant.WORK_ORDER_TYPE_AND_SENDGROUP.YZFTX
								.getWorkOrderTypeCode(), "", Boolean.FALSE,
						Boolean.TRUE, null, null, null, null, null, false);
			}
		}
	}

	/**
	 * 包装查询条件.
	 * 
	 * @return CompositeQuery.
	 */
	private CompositeQuery getCompositeQuery() {
		compositeQuery = new CompositeQuery();
		orderTimeRange = new OrderTimeRange();
		orderStatus = new OrderStatus();
		orderContent = new OrderContent();
		orderIdentity = new OrderIdentity();
		typeList = new ArrayList<SortTypeEnum>();
		pageIndex = new PageIndex();

		// 订单状态:正常
		orderStatus.setOrderStatus(Constant.ORDER_STATUS.NORMAL.name());
		// 支付状态：已支付
		orderStatus.setPaymentStatus(Constant.ORDER_VIEW_STATUS.PAYED.name());
		// 游玩时间大于系统时间
		orderTimeRange.setOrdOrderVisitTimeStart(DateUtil
				.getDayStart(getDate(0)));
		// 只获取三个小时内创建的订单
		orderTimeRange.setPayTimeStart(DateUtils.addHours(new Date(), -3));
		orderTimeRange.setPayTimeEnd(new Date());
		//线路类型：出境跟团游、出境自由行
		String[] orderType = { Constant.SUB_PRODUCT_TYPE.GROUP_FOREIGN.name(),
				Constant.SUB_PRODUCT_TYPE.FREENESS_FOREIGN.name()};
		orderContent.setOrderType(orderType);
		
		typeList.add(CompositeQuery.SortTypeEnum.ORDER_ID_DESC);// 降序
		compositeQuery.setExcludedContent(null);
		pageIndex.setBeginIndex(1);
		pageIndex.setEndIndex(9999);
		compositeQuery.setStatus(orderStatus);
		compositeQuery.setContent(orderContent);
		compositeQuery.setTypeList(typeList);
		compositeQuery.setPageIndex(pageIndex);
		compositeQuery.setOrderTimeRange(orderTimeRange);
		compositeQuery.setOrderIdentity(orderIdentity);
		
		compositeQuery.getQueryFlag().setQuerySupplier(false);
		compositeQuery.getQueryFlag().setQueryUser(false);
		return compositeQuery;
	}

	private Date getDate(int addDayCnt) {
		Date date = null;
		Calendar cl = Calendar.getInstance();
		if (addDayCnt != 0) {
			cl.add(Calendar.DATE, addDayCnt);
		}
		date = cl.getTime();
		return date;
	}

	public WorkOrderSenderBiz getWorkOrderSenderProxy() {
		return workOrderSenderProxy;
	}

	public void setWorkOrderSenderProxy(WorkOrderSenderBiz workOrderSenderProxy) {
		this.workOrderSenderProxy = workOrderSenderProxy;
	}

	public OrderService getOrderServiceProxy() {
		return orderServiceProxy;
	}

	public void setOrderServiceProxy(OrderService orderServiceProxy) {
		this.orderServiceProxy = orderServiceProxy;
	}
}
