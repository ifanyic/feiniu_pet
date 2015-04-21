package com.lvmama.order.dao;

/**
 * SelectInSQL.
 *
 * <pre></pre>
 *
 * @author wuwei
 * @author tom
 * @version Super二期 10/10/11
 * @since Super二期
 */
public interface SelectInSQL {
	String ORD_ORDER_ITEM_PROD = "SELECT DISTINCT ORD_ORDER_ITEM_PROD.* FROM ORD_ORDER_ITEM_PROD WHERE ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_ORDER_ITEM_META = "SELECT DISTINCT ORD_ORDER_ITEM_META.* FROM ORD_ORDER_ITEM_META WHERE ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_PERSON = "SELECT DISTINCT ORD_PERSON.* FROM ORD_PERSON WHERE ORD_PERSON.OBJECT_TYPE = 'ORD_ORDER' AND ORD_PERSON.OBJECT_ID IN (SELECT ORDER_ID FROM (";
	String USR_USERS = "SELECT DISTINCT USR_USERS.* FROM USR_USERS WHERE USER_ID IN (SELECT USER_ID FROM (";
	String ORD_INVOICE = "SELECT DISTINCT ORD_INVOICE.* FROM ORD_INVOICE INNER JOIN ORD_INVOICE_RELATION ON ORD_INVOICE.INVOICE_ID=ORD_INVOICE_RELATION.INVOICE_ID WHERE ORD_INVOICE_RELATION.ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_INVOICE_RELATION = "SELECT DISTINCT ORD_INVOICE_RELATION.* FROM ORD_INVOICE_RELATION WHERE ORD_INVOICE_RELATION.ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_ORDER_PRE = "SELECT DISTINCT ORD_ORDER_PRE.* FROM ORD_ORDER_PRE WHERE ORD_ORDER_PRE.IS_VALID='Y' AND ORD_ORDER_PRE.ORDER_ID IN (SELECT ORDER_ID  FROM(";
	String ORD_ORDER = "SELECT DISTINCT ORD_ORDER.* FROM ORD_ORDER, ORD_ORDER_ITEM_META WHERE ORD_ORDER.ORDER_ID = ORD_ORDER_ITEM_META.ORDER_ID AND ORD_ORDER_ITEM_META.ORDER_ITEM_META_ID IN (SELECT ORDER_ITEM_META_ID FROM (";
	String ORD_ORDER_ITEM_META_TIME = "SELECT DISTINCT ORD_ORDER_ITEM_META_TIME.* FROM ORD_ORDER_ITEM_META_TIME, ORD_ORDER_ITEM_META WHERE ORD_ORDER_ITEM_META_TIME.ORDER_ITEM_META_ID = ORD_ORDER_ITEM_META.ORDER_ITEM_META_ID AND ORD_ORDER_ITEM_META.ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_ORDER_ITEM_PROD_TIME = "SELECT DISTINCT ORD_ORDER_ITEM_PROD_TIME.* FROM ORD_ORDER_ITEM_PROD_TIME, ORD_ORDER_ITEM_PROD WHERE ORD_ORDER_ITEM_PROD_TIME.ORDER_ITEM_PROD_ID = ORD_ORDER_ITEM_PROD.ORDER_ITEM_PROD_ID AND ORD_ORDER_ITEM_PROD.ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_ORDER_ROUTE = "SELECT DISTINCT ORD_ORDER_ROUTE.* FROM ORD_ORDER_ROUTE WHERE ORD_ORDER_ROUTE.ORDER_ID IN (SELECT ORDER_ID FROM (";
	String ORD_ORDER_TRACK = "SELECT DISTINCT ORD_ORDER_TRACK.* FROM ORD_ORDER_TRACK WHERE ORD_ORDER_TRACK.ORDER_ID IN (SELECT ORDER_ID FROM (";
	String END = "))";
	

	String ORD_ORDER_ITEM_META3 = "select t.*, i.item_name as settlementStatusStr from (SELECT DISTINCT ORD_ORDER_ITEM_META.* FROM ORD_ORDER_ITEM_META WHERE ORDER_ID IN (SELECT ORDER_ID FROM (";
	String PRODUCT_STATUS = ") t, meta_product h, com_code i where t.meta_product_id = h.meta_product_id and i.set_code = 'SETTLEMENT_STATUS' and t.settlement_status = i.item_code";
	
}
