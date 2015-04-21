/** *  */package com.lvmama.shholiday.request;import java.util.ArrayList;import java.util.List;import com.lvmama.comm.bee.po.meta.MetaTravelCode;import com.lvmama.comm.bee.po.ord.OrdOrder;import com.lvmama.comm.bee.po.ord.OrdOrderItemMeta;import com.lvmama.comm.bee.po.ord.OrdPerson;import com.lvmama.comm.pet.po.businessCoupon.BusinessCoupon;import com.lvmama.comm.utils.DateUtil;import com.lvmama.comm.utils.PriceUtil;import com.lvmama.comm.vo.Constant;import com.lvmama.shholiday.Response;import com.lvmama.shholiday.response.CreateOrderResponse;import com.lvmama.shholiday.vo.order.Contact;import com.lvmama.shholiday.vo.order.OrderBaseInfo;import com.lvmama.shholiday.vo.order.OrderFavorInfo;import com.lvmama.shholiday.vo.order.OrderPassenger;import com.lvmama.shholiday.vo.order.ProductInfo;/** * @author yangbin * */public class CreateOrderRequest extends AbstractRequest{		private OrdOrder order;	List<BusinessCoupon> businessCoupons;	Long favorAmount;	OrdPerson contact;	List<OrdPerson> travelers;		MetaTravelCode metaTravelCode;	/**	 * 该订单当中的子子项是只存在该供应商ID的子子项。其他的都去除	 * @param order	 */	public CreateOrderRequest(OrdOrder order) {		super();		this.order = order;		makeParam();	}	/**	 * 该订单当中的子子项是只存在该供应商ID的子子项。其他的都去除	 * @param order	 */	public CreateOrderRequest(OrdOrder order,List<BusinessCoupon> businessCoupons,Long favorAmount,MetaTravelCode metaTravelCode) {		super();		this.order = order;		this.favorAmount=favorAmount;		this.metaTravelCode=metaTravelCode;		this.businessCoupons=businessCoupons;		this.contact = order.getContact();		this.travelers = order.getTravellerList();		makeParam();	}		/**	 * 该订单当中的子子项是只存在该供应商ID的子子项。其他的都去除	 * @param order	 */	public CreateOrderRequest(OrdOrder order,List<BusinessCoupon> businessCoupons,Long favorAmount,MetaTravelCode metaTravelCode,			OrdPerson contact,List<OrdPerson> travelers) {		super();		this.order = order;		this.favorAmount=favorAmount;		this.metaTravelCode=metaTravelCode;		this.businessCoupons=businessCoupons;		this.contact = contact;		this.travelers = travelers;		makeParam();	}		@Override	public String getTransactionName() {		return REQUEST_TYPE.OTA_TourBookRQ.name();	}	@Override	public Class<? extends Response> getResponseClazz() {		// TODO Auto-generated method stub		return CreateOrderResponse.class;	}	private void makeParam(){				addParam("orderBaseInfo",initOrderBaseInfo());		addParam("productInfo",initProductInfo());		addParam("contact",initContact());		addParam("orderPassengers",initOrderPassenger());		addParam("favorInfos",initOrderFavorInfo());	}		private Contact initContact(){		return new Contact().getContact(contact);	}	private ProductInfo initProductInfo(){		ProductInfo productInfo = new ProductInfo();		OrdOrderItemMeta itemMeta = order.getAllOrdOrderItemMetas().get(0);		productInfo.setTakeoffDate(DateUtil.formatDate(itemMeta.getVisitTime(), "yyyyMMdd"));		if(metaTravelCode!=null){			productInfo.setTeamUniqueId(metaTravelCode.getTravelCodeId());			productInfo.setUniqueId(metaTravelCode.getSupplierProductId());			productInfo.setTeamName(metaTravelCode.getTravelCode());		}		return productInfo;	}	private OrderBaseInfo initOrderBaseInfo(){		Long adultPrice =0l;		Long childPrice =0l;		Long infantPrice =0l;		Long roomPrice =0l;		Long adultNum=0l;		Long childNum =0l;		Long infantNum=0l;		Long accompanyNum=0l;		Long totalAmount =0l;		Long bookAccompanyPrice =0l;		for(OrdOrderItemMeta itemMeta:order.getAllOrdOrderItemMetas()){			if(itemMeta.getProductTypeSupplier()!=null){				if(Constant.SH_HOLIDAY_BRANCH_TYPE.ADULT.getCode().equals(itemMeta.getProductTypeSupplier())){					adultPrice+=itemMeta.getSettlementPrice();					if(adultNum==0){						adultNum = itemMeta.getQuantity();					}					totalAmount = totalAmount + itemMeta.getSettlementPriceLong();				}				if(Constant.SH_HOLIDAY_BRANCH_TYPE.CHILDREN.getCode().equals(itemMeta.getProductTypeSupplier())){					childPrice+=itemMeta.getSettlementPrice();					if(childNum==0){						childNum = itemMeta.getQuantity();					}					totalAmount = totalAmount + itemMeta.getSettlementPriceLong();				}				if(Constant.SH_HOLIDAY_BRANCH_TYPE.INFANT.getCode().equals(itemMeta.getProductTypeSupplier())){					infantPrice+=itemMeta.getSettlementPrice();					if(infantNum==0){						infantNum = itemMeta.getQuantity();					}					totalAmount = totalAmount + itemMeta.getSettlementPriceLong();				}				if(Constant.SH_HOLIDAY_BRANCH_TYPE.ACCOMPANY.getCode().equals(itemMeta.getProductTypeSupplier())){					bookAccompanyPrice+=itemMeta.getSettlementPrice();					if(accompanyNum==0){						accompanyNum = itemMeta.getQuantity();					}					totalAmount = totalAmount + itemMeta.getSettlementPrice();				}if(Constant.SH_HOLIDAY_BRANCH_TYPE.ROOMDIFFER.getCode().equals(itemMeta.getProductTypeSupplier())){					roomPrice+=itemMeta.getSettlementPrice();					totalAmount = totalAmount + itemMeta.getSettlementPriceLong();				}							}					}		StringBuffer priceArithmetic =new StringBuffer("产品价格(");		if(adultNum>0){			priceArithmetic.append("￥").append(PriceUtil.convertToYuan(adultPrice)).append("*").append(adultNum).append("成人");		}		if(childNum>0){			if(priceArithmetic.indexOf("(")!=(priceArithmetic.length()-1)){				priceArithmetic.append("+");			}			priceArithmetic.append("￥").append(PriceUtil.convertToYuan(childPrice)).append("*").append(childNum).append("儿童");		}if(accompanyNum>0){			if(priceArithmetic.indexOf("(")!=(priceArithmetic.length()-1)){				priceArithmetic.append("+");			}			priceArithmetic.append("￥").append(PriceUtil.convertToYuan(bookAccompanyPrice)).append("*").append(accompanyNum).append("全陪");		}if(infantNum>0){			if(priceArithmetic.indexOf("(")!=(priceArithmetic.length()-1)){				priceArithmetic.append("+");			}			priceArithmetic.append("￥").append(PriceUtil.convertToYuan(infantPrice)).append("*").append(infantNum).append("婴儿");		}		if(roomPrice>0){			if(priceArithmetic.indexOf("(")!=(priceArithmetic.length()-1)){				priceArithmetic.append("+");			}			priceArithmetic.append("￥").append(PriceUtil.convertToYuan(roomPrice)).append("*").append(infantNum).append("房差价格");		}		priceArithmetic.append(")");		OrderBaseInfo orderBaseInfo = new OrderBaseInfo();		orderBaseInfo.setExternalOrderNo(order.getOrderId());				orderBaseInfo.setOrderFavorAmount(favorAmount);		orderBaseInfo.setOrderTotalAmount(totalAmount-favorAmount);		orderBaseInfo.setBookAccompanyPrice(bookAccompanyPrice);		orderBaseInfo.setPriceArithmetic(priceArithmetic.toString());		orderBaseInfo.setInfantSalePrice(infantPrice);		orderBaseInfo.setChildrenSalePrice(childPrice);		orderBaseInfo.setAdultSaleProxyPrice(adultPrice);				return orderBaseInfo;	}		private List<OrderPassenger> initOrderPassenger(){		try{			List<OrderPassenger> orderPassengers = new ArrayList<OrderPassenger>();			for(OrdPerson per:travelers){				OrderPassenger orderPrassenger = new OrderPassenger();				orderPrassenger.setAddress(per.getAddress());				orderPrassenger.setBrithday(per.getBrithday());				orderPrassenger.setCertNo(per.getCertNo());				orderPrassenger.setCertType(per.getCertType());				orderPrassenger.setEmail(per.getEmail());				orderPrassenger.setMobile(per.getMobile());				orderPrassenger.setName(per.getName());				orderPrassenger.setGender(per.getGender());				orderPrassenger.setFax(per.getFax());				orderPassengers.add(orderPrassenger);							}			for (OrdOrderItemMeta itemMeta:order.getAllOrdOrderItemMetas()) {				if(Constant.SH_HOLIDAY_BRANCH_TYPE.ROOMDIFFER.getCode().equals(itemMeta.getProductTypeSupplier())){					if(orderPassengers.size()>=itemMeta.getQuantity()){						for(int i=0;i<itemMeta.getQuantity();i++){							orderPassengers.get(i).setSingleRoom("Y");						}					}				}			}			return orderPassengers;		}catch(Exception e){			e.printStackTrace();		}		return null;	}			private List<OrderFavorInfo> initOrderFavorInfo(){		List<OrderFavorInfo>  orderFavorInfos = new ArrayList<OrderFavorInfo>();		if(businessCoupons==null){			return null;		}		for(BusinessCoupon bc:businessCoupons){			OrderFavorInfo ofi = new OrderFavorInfo();			ofi.setFavorName(bc.getCouponName());			ofi.setFavorCode(ofi.getFavorCode());			ofi.setBeginSaleFormatDate(DateUtil.formatDate(bc.getPlayBeginTime(),"yyyy-MM-dd HH:ss"));			ofi.setEndSaleFormatDate(DateUtil.formatDate(bc.getPlayEndTime(),"yyyy-MM-dd HH:ss"));			//ofi.setFavorUniqueId(favorUniqueId);			orderFavorInfos.add(ofi);		}		return orderFavorInfos;	}}