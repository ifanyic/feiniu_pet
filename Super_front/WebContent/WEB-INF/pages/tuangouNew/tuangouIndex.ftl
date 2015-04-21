<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${comSeoIndexPage.seoTitle}</title>
<meta name="keywords" content="${comSeoIndexPage.seoKeyword}"/>
<meta name="description" content="${comSeoIndexPage.seoDescription}"/>

<!--生产线引用-->
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v5/base.css,/styles/v5/common.css,/styles/new_v/header-air.css" >
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v5/modules/form.css,/styles/v5/modules/button.css,/styles/v5/modules/table.css,/styles/v5/modules/tags.css,/styles/v5/modules/tip.css,/styles/v5/modules/paging.css" />
<link rel="stylesheet" href="http://pic.lvmama.com/styles/v5/tuangou.css" />
<#include "/common/coremetricsHead.ftl">

</head>
<body class="lvtg tuangou"> 
<!-- 公共头部开始  -->
<!-- 
 * 此示例展示，暂时使用了js来展现，
 * 但开发上线，务必请引用头部的那个公共模块，参考其他项目
-->
<@s.set var="pageMark" value="'tuangou'" />
<#include "/common/header.ftl">
<input type="hidden" value="freetour" id="pageName">
<!-- 公共头部结束  -->

<div class="wrap">
    <!--顶部banner-->
    <div class="tg_top">
        <div class="banner">
            <ul class="banner_list">
            <@s.iterator value="recommendFocus" status="st" var="benner">
            	<@s.if test="#st.index<5">
            	<li  <@s.if test='#st.index==0'>style="display:block;"</@s.if>><a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="780" height="80"  title="${benner.title}"></a></li>
            	</@s.if>
            </@s.iterator>
            </ul>
            <ul class="banner_tab">
                <@s.iterator value="recommendFocus" status="st" var="benner">
                	<@s.if test="#st.index<5">
            		<li <@s.if test='#st.index==0'>class="active"</@s.if>></li>
            		</@s.if>
            	</@s.iterator>
            </ul>
        </div>
        <ul class="tg_top_r"> 
			<li> 
					<i class="icon icon-tg01"></i> 
					<p>精挑细选</p> 
			</li> 
			<li> 
					<i class="icon icon-tg02"></i> 
				    <p>铁定出行</p> 
			</li> 
			<li> 
					<i class="icon icon-tg03"></i> 
					<p>真实点评</p> 
			</li> 
		</ul>

    </div>
    
    <!--搜索筛选-->
    <div class="tg_seach">
        <div class="seach_t">
            <div class="seach_city">
                <p class="my_city_btn js_city_btn"><i class="icon icon-04"></i>我在<b class="now_city">${fromPlaceName }</b><i class="arrow"></i></p>
                <div class="my_city">
                    <p class="my_city_t"></p>
                    <dl>
                         <!-- 分站  重庆，深圳，南京，杭州，广州，成都，北京，上海-->
                                <a href="javascript:switchIndex('SH','79','上海');">上海</a>
                                <a href="javascript:switchIndex('BJ','1','北京');" >北京</a>
                                <a href="javascript:switchIndex('CD','279','成都');" >成都</a>
                                <a href="javascript:switchIndex('GZ','229','广州');" >广州</a>
                            
                                <a href="javascript:switchIndex('HZ','100','杭州');" >杭州</a>
                                <a href="javascript:switchIndex('NJ','82','南京');" >南京</a>
                                <a href="javascript:switchIndex('SZ','231','深圳');" >深圳</a>
                    </dl>
                </div>
            </div>
                    <form method="post" id="switchIndexForm" action="http://www.lvmama.com/tuangou">
                        <input type="hidden" name="fromPlaceCode" id="fromPlaceCode" value="${fromPlaceCode}" />
                        <input type="hidden" name="fromPlaceId" id="fromPlaceId" value="${fromPlaceId}" />
                        <input type="hidden" name="fromPlaceName" id="fromPlaceName" value="${fromPlaceName}" />
                    </form>
                    
            <ul class="seach_nav">
                <li class="active"><a>特卖会首页</a></li>
                <li ><a href='http://www.lvmama.com/tuangou/all' >精品团购</a></li>
                <li <@s.if test="tgType=='xsms'">class="active"</@s.if>><a href='http://www.lvmama.com/tuangou/all/all-all-xsms-1' >限时秒杀</a></li>
<!--                 <li <@s.if test="tgType=='zyk'">class="active"</@s.if>><a href='http://www.lvmama.com/tuangou/all/all-all-zyk-1' >周游客</a></li> -->
                <li <@s.if test="tgType=='hyr'">class="active"</@s.if>><a href='http://www.lvmama.com/tuangou/all/all-all-hyr-1' >会员日</a></li>
            </ul>
            <div class="seach_t_r">
                <a target="_blank" href="http://www.lvmama.com/tuangouyuyue" >团购预约</a>
            </div>
        </div>
        
        <div class="ceach_box clearfix">
            <div class="seach_box_list">
             <@s.if test="dataCountMap.get('allTypeCount')!=0">
                <div class="seach_list_title">团购分类</div>
                <dl class="seach_list">
                    <dt><a <@s.if test="type=='all'">class="active"</@s.if> href='http://www.lvmama.com/tuangou/${Request["city"]}/all-all-${Request["tgType"]}-1' >全部<span>（${dataCountMap.get('allTypeCount')}）</span></a>
                   	</dt>
                    <dd>
                    <@s.if test="dataCountMap.get('ticketCount')!=0">
                        <a <@s.if test="type=='ticket'">class="active"</@s.if> href='http://www.lvmama.com/tuangou/${Request["city"]}/ticket-all-${Request["tgType"]}-1'>景点门票<span>（${dataCountMap.get('ticketCount')}）</span></a>
					</@s.if>
					<@s.if test="dataCountMap.get('freenessCount')!=0">                        
                        <a <@s.if test="type=='surround'">class="active"</@s.if> href='http://www.lvmama.com/tuangou/${Request["city"]}/surround-all-${Request["tgType"]}-1'>周边游<span>（${dataCountMap.get('freenessCount')}）</span></a>
					</@s.if>                        
                    <@s.if test="dataCountMap.get('grouplongCount')!=0">
                        <a <@s.if test="type=='china'">class="active"</@s.if> href='http://www.lvmama.com/tuangou/${Request["city"]}/china-all-${Request["tgType"]}-1'>国内游<span>（${dataCountMap.get('grouplongCount')}）</span></a>
					</@s.if>
                  	<@s.if test="dataCountMap.get('groupForeign')!=0">
                        <a <@s.if test="type=='abroad'">class="active"</@s.if> href='http://www.lvmama.com/tuangou/${Request["city"]}/abroad-all-${Request["tgType"]}-1'>出境游<span>（${dataCountMap.get('groupForeign')}）</span></a>
                    </@s.if>
					<@s.if test="dataCountMap.get('hotelCount')!=0">                        
                        <a <@s.if test="type=='hotel'">class="active"</@s.if> href='http://www.lvmama.com/tuangou/${Request["city"]}/hotel-all-${Request["tgType"]}-1'>酒店<span>（${dataCountMap.get('hotelCount')}）</span></a>
                    </@s.if>
                        <!--<a class="seach_hot" href="http://wenquan.lvmama.com/tg">温泉<i class="icon icon-05"></i></a>-->
                    </dd>
                </dl>
             </@s.if>
            </div>
            <div class="seach_box_list list_first">
                <div class="seach_list_title">目的地城市</div>
                <dl class="seach_list">
                    <dt><a class="active" href='http://www.lvmama.com/tuangou/all/${Request["type"]}-all-${Request["tgType"]}-1'>全部<span>（${dataCountMap.get('allCityCount')}）</span></a></dt>
                    <dd>
                    <div>
                    <@s.iterator value="cities" status="st" var="b" >
                    	<@s.if test="#st.index<12">
                    	<a href='http://www.lvmama.com/tuangou/${b.cityPinYin}/${Request["type"]}-all-${Request["tgType"]}-1' >${b.cityName}(${b.cityCount})</span></a>
                    	</@s.if>
                    </@s.iterator>
                    </div>
                    <div id="divMoreCity" style="display:none">
                    <@s.iterator value="cities" status="st" var="b" >
                    	<@s.if test="#st.index>=12">
                    	<a href='http://www.lvmama.com/tuangou/${b.cityPinYin}/${Request["type"]}-all-${Request["tgType"]}-1' >${b.cityName}(${b.cityCount})</span></a>
                    	</@s.if>
                    </@s.iterator>
                    </div>
                    </dd>
                </dl>
                <div class="seach_gd_box">
                    <@s.if test="cities != null && cities.size() > 12"><p id="moreId" class="seach_gd_btn js_Morecity_btn">更多<i class="arrow"></i></p></@s.if>&nbsp;
                </div>
            </div>
           
        </div>
        
    </div>
    
</div><!--//.wrap-->


<div class="hr_c"></div>

<div class="wrap wrapbox1">
    <div class="tmain clearfix">
        
<@s.iterator value="indexMap.get('otherPrdList_productsnew')" status="st">
<@s.if test="#st.index<8">  
<dl class="titem">
    <dt><i class="icon <@s.if test='viewRecommendInfo.bakWord1!=null && viewRecommendInfo.bakWord1==1'>icon-xsms</@s.if><@s.elseif test='viewRecommendInfo.bakWord2!=null && viewRecommendInfo.bakWord2==1'>icon-hyr</@s.elseif>"></i><a target="_blank" href="${viewRecommendInfo.url}"><img to="<@s.property  value="comPictureUrl"/>"  height="200" width="300" alt="" /></a></dt>
    <dd class="tinfo">
        <div class="info">
            <h4><a target="_blank" href="${viewRecommendInfo.url}" title='<@s.property value="prodProduct.firstTitle"  escape="false"/>' >${prodProduct.firstTitle}</a></h4>
            <div class="tintro">
                <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>">
                	<p>
                		<@s.property value="@com.lvmama.comm.utils.StringUtil@subStringStr(prodProduct.nextTitle,75)" />
                	</p>
                </a>
            </div>
            <p class="text"><span class="tdate">${viewRecommendInfo.bakWord5}</span>[<@s.property value="prodProduct.zhProductType"/>]<@s.property value="recommendPrdFrom"/>&nbsp;&nbsp;<@s.property value="recommendPrdTo"/></p>
        </div>
    </dd>
    <dd class="tother">
        <div class="dot-line"></div>
         <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="btn btn-big btn-orange fr mt10">去看看</a>
        <p class="tprice">
            <dfn>&yen;<i>${prodProduct.sellPriceYuan?if_exists}</i><small>起</small></dfn>
            <del>&yen;${prodProduct.marketPriceYuan?if_exists}</del>
        </p>
        <p class="tmu">
            <span class="tstar"><i style="width:<@s.property value='avgScore'/>%"></i></span>
            <a class="tcom" target="_blank" href="${viewRecommendInfo.url}#dianping"><@s.property value="cmtCount"/>人评价</a>
        </p>
        <div class="dot-line"></div>
        <p class="other">
            <span class="ttime"><i class="icon icon-time"></i><i class="countdown" data-time="<@s.property  value='diff'/>"></i></span>
            <span class="text"><em><@s.property  value="orderCount"/></em>份已出售</span>
        </p>
    </dd>
</dl>
</@s.if>
</@s.iterator>
        
    </div><!--//.tmain-->
    <div class="tside">
        <div class="tsidefixed pinned">
            <div class="sidebox tsidebox">
                <div class="ttitle">
                    <h4 class="tit">限时秒杀</h4>  
                </div>
                <div class="tcontent">
                    <ul class="ul-ver">
                       <@s.iterator value="indexMap.get('msPrdList_recommend_products')" status="status">  
                <li class="<@s.if test='#status.count==1'>selected</@s.if>">
                            <p class="pitem">
                            <span class="desc">${viewRecommendInfo.bakWord5}</span>
                            <b>[<@s.property value="prodProduct.zhProductType"/>]</b>
                            <a target="_blank" href="${viewRecommendInfo.url}" class="tlink"><@s.property value="recommendPrdFrom"/>&nbsp;&nbsp;<@s.property value="recommendPrdTo"/></a>
                            </p>
                    <dl class="dl-ver">
                        <dt><i class="icon icon-xsms"></i><a target="_blank" href="${viewRecommendInfo.url}" class="text-cover" title="${prodProduct.firstTitle}"><img to="<@s.property  value="comPictureUrl"/>" width="326" height="210" alt="${prodProduct.firstTitle}" /><span class="ctext">${prodProduct.firstTitle}</span></a></dt>
                        <dd>
                            <a target="_blank" href="${viewRecommendInfo.url}" class="btn btn-big btn-orange fr">去看看</a>
                            <p class="tprice">
                            <dfn>¥<i>${prodProduct.sellPriceYuan?if_exists}</i><small>起</small></dfn>
                            <del>¥${prodProduct.marketPriceYuan?if_exists}</del>
                            </p>
                            <p class="tmu">
                                <span class="tstar"><i style="width:<@s.property value='avgScore'/>%"></i></span>
                                <a class="tcom" target="_blank" href="${viewRecommendInfo.url}#dianping"><@s.property value="cmtCount"/>人评价</a>
                            </p>
                            <div class="dot-line"></div>
                            <p class="other">
                                <span class="ttime"><i class="icon icon-time"></i><i class="countdown" data-time="<@s.property  value='diff'/>"></i></span>
                                <span class="text"><em><@s.property  value="orderCount"/></em>份已出售</span>
                            </p>
                        </dd>
                    </dl>
                </li>
                </@s.iterator>
                    </ul>
                </div>
            </div><!--//.tsidebox-->
            
            <@s.iterator value="recommendPicList" status="st" var="benner">  
            <@s.if test='#st.count==1'>
            <div class="adside">
                <a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="328" height="90" alt="" /></a>
            </div>
            </@s.if>
            
            <@s.if test='#st.count==2'>
            <div class="adside">
                <a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="328" height="90" alt="" /></a>
            </div>
            </@s.if>
            </@s.iterator>
        </div><!--//.tsidefixed-->
    </div><!--//.tside-->
</div> <!-- //.wrapbox1 -->

<div class="wrap wrapbox3">
    <div class="tmain clearfix">

<@s.iterator value="indexMap.get('otherPrdList_productsnew')" status="st">
<@s.if test="#st.index>7 && #st.index<16">    
<dl class="titem">
    <dt><i class="icon <@s.if test='viewRecommendInfo.bakWord1!=null && viewRecommendInfo.bakWord1==1'>icon-xsms</@s.if><@s.elseif test='viewRecommendInfo.bakWord2!=null && viewRecommendInfo.bakWord2==1'>icon-hyr</@s.elseif>"></i><a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>"><img to="<@s.property  value="comPictureUrl"/>"  height="200" width="300" alt="" /></a></dt>
    <dd class="tinfo">
        <div class="info">
            <h4><a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" title='<@s.property value="prodProduct.firstTitle"  escape="false"/>' >${prodProduct.firstTitle}</a></h4>
            <div class="tintro">
                <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>">
                	<p>
                		<@s.property value="@com.lvmama.comm.utils.StringUtil@subStringStr(prodProduct.nextTitle,75)" />
                	</p>
                </a>
            </div>
            <p class="text"><span class="tdate">${viewRecommendInfo.bakWord5}</span>[<@s.property value="prodProduct.zhProductType"/>]<@s.property value="recommendPrdFrom"/>&nbsp;&nbsp;<@s.property value="recommendPrdTo"/></p>
        </div>
    </dd>
    <dd class="tother">
        <div class="dot-line"></div>
         <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="btn btn-big btn-orange fr mt10">去看看</a>
        <p class="tprice">
            <dfn>&yen;<i>${prodProduct.sellPriceYuan?if_exists}</i><small>起</small></dfn>
            <del>&yen;${prodProduct.marketPriceYuan?if_exists}</del>
        </p>
        <p class="tmu">
            <span class="tstar"><i style="width:<@s.property value='avgScore'/>%"></i></span>
            <a class="tcom" target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>#dianping"><@s.property value="cmtCount"/>人评价</a>
        </p>
        <div class="dot-line"></div>
        <p class="other">
            <span class="ttime"><i class="icon icon-time"></i><i class="countdown" data-time="<@s.property  value='diff'/>"></i></span>
            <span class="text"><em><@s.property  value="orderCount"/></em>份已出售</span>
        </p>
    </dd>
</dl>
</@s.if>
</@s.iterator>
        
    </div><!--//.tmain-->
    <div class="tside">
        <div class="tsidefixed pinned">
            <div class="sidebox tsidebox">
                <div class="ttitle">
                    <h4 class="tit">会员日</h4>
                    <a target="_blank" href="http://www.lvmama.com/tuangou/all/all-all-hyr-1" class="thelp">什么是会员日<i class="icon icon-help"></i></a>  
                </div>
                <div class="tcontent">
                    <ul class="ul-ver">
                       <@s.iterator value="indexMap.get('wlyPrdList_recommend_products')" status="status">  
                <li class="<@s.if test='#status.count==1'>selected</@s.if>">
                            <p class="pitem">
                            <span class="desc">${viewRecommendInfo.bakWord5}</span>
                            <b>[<@s.property value="prodProduct.zhProductType"/>]</b>
                            <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="tlink"><@s.property value="recommendPrdFrom"/>&nbsp;&nbsp;<@s.property value="recommendPrdTo"/></a>
                            </p>
                    <dl class="dl-ver">
                        <dt><i class="icon icon-hyr"></i><a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="text-cover" title="${prodProduct.firstTitle}"><img to="<@s.property  value="comPictureUrl"/>" width="326" height="210" alt="${prodProduct.firstTitle}" /><span class="ctext">${prodProduct.firstTitle}</span></a></dt>
                        <dd>
                            <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="btn btn-big btn-orange fr">去看看</a>
                            <p class="tprice">
                            <dfn>¥<i>${prodProduct.sellPriceYuan?if_exists}</i><small>起</small></dfn>
                            <del>¥${prodProduct.marketPriceYuan?if_exists}</del>
                            </p>
                            <p class="tmu">
                                <span class="tstar"><i style="width:<@s.property value='avgScore'/>%"></i></span>
                                <a class="tcom" target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>#dianping"><@s.property value="cmtCount"/>人评价</a>
                            </p>
                            <div class="dot-line"></div>
                            <p class="other">
                                <span class="ttime"><i class="icon icon-time"></i><i class="countdown" data-time="<@s.property  value='diff'/>"></i></span>
                                <span class="text"><em><@s.property  value="orderCount"/></em>份已出售</span>
                            </p>
                        </dd>
                    </dl>
                </li>
                </@s.iterator>
                    </ul>
                </div>
            </div><!--//.tsidebox-->
            
            <@s.iterator value="recommendPicList" status="st" var="benner">  
            <@s.if test='#st.count==3'>
            <div class="adside">
                <a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="328" height="90" alt="" /></a>
            </div>
            </@s.if>
            
            <@s.if test='#st.count==4'>
            <div class="adside">
                <a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="328" height="90" alt="" /></a>
            </div>
            </@s.if>
            </@s.iterator>
        </div><!--//.tsidefixed-->
    </div><!--//.tside-->
</div> <!-- //.wrapbox3 -->

<div class="wrap wrapbox4">
    <div class="tmain clearfix">
        
<@s.iterator value="indexMap.get('otherPrdList_productsnew')" status="st"> 
<@s.if test="#st.index>15&&#st.index<32">    
<dl class="titem">
    <dt><i class="icon <@s.if test='viewRecommendInfo.bakWord1!=null && viewRecommendInfo.bakWord1==1'>icon-xsms</@s.if><@s.elseif test='viewRecommendInfo.bakWord2!=null && viewRecommendInfo.bakWord2==1'>icon-hyr</@s.elseif>"></i><a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>"><img to="<@s.property  value="comPictureUrl"/>"  height="200" width="300" alt="<@s.property value="prodProduct.firstTitle"/>" /></a></dt>
    <dd class="tinfo">
        <div class="info">
            <h4><a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" title='<@s.property value="prodProduct.firstTitle"  escape="false"/>' >${prodProduct.firstTitle}</a></h4>
            <div class="tintro">
                <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>">
                	<p>
                		<@s.property value="@com.lvmama.comm.utils.StringUtil@subStringStr(prodProduct.nextTitle,75)" />
                	</p>
                </a>
            </div>
            <p class="text"><span class="tdate">${viewRecommendInfo.bakWord5}</span>[<@s.property value="prodProduct.zhProductType"/>]<@s.property value="recommendPrdFrom"/>&nbsp;&nbsp;<@s.property value="recommendPrdTo"/></p>
        </div>
    </dd>
    <dd class="tother">
        <div class="dot-line"></div>
         <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="btn btn-big btn-orange fr mt10">去看看</a>
        <p class="tprice">
            <dfn>&yen;<i>${prodProduct.sellPriceYuan?if_exists}</i><small>起</small></dfn>
            <del>&yen;${prodProduct.marketPriceYuan?if_exists}</del>
        </p>
        <p class="tmu">
            <span class="tstar"><i style="width:<@s.property value='avgScore'/>%"></i></span>
            <a class="tcom" target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>#dianping"><@s.property value="cmtCount"/>人评价</a>
        </p>
        <div class="dot-line"></div>
        <p class="other">
            <span class="ttime"><i class="icon icon-time"></i><i class="countdown" data-time="<@s.property  value='diff'/>"></i></span>
            <span class="text"><em><@s.property  value="orderCount"/></em>份已出售</span>
        </p>
    </dd>
</dl>
</@s.if>
</@s.iterator>
        
    </div> <!--//.tmain-->
    <div class="tside">
        <div class="tsidefixed pinned">
            <div class="sidebox tsidebox">
                <div class="ttitle">
                    <h4 class="tit">热门推荐</h4>
                    
                </div>
                <div class="tcontent">
                    <ul class="ul-ver">
                       <@s.iterator value="indexMap.get('wxzqPrdList_recommend_products')" status="status">  
                <li class="<@s.if test='#status.count==1'>selected</@s.if>">
                            <p class="pitem">
                            <span class="desc">${viewRecommendInfo.bakWord5}</span>
                            <b>[<@s.property value="prodProduct.zhProductType"/>]</b>
                            <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="tlink"><@s.property value="recommendPrdFrom"/>&nbsp;&nbsp;<@s.property value="recommendPrdTo"/></a>
                            </p>
                    <dl class="dl-ver">
                        <dt> <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="text-cover" title="${prodProduct.firstTitle}"><img to="<@s.property  value="comPictureUrl"/>" width="326" height="210" alt="${prodProduct.firstTitle}" /><span class="ctext">${prodProduct.firstTitle}</span></a></dt>
                        <dd>
                            <a target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>" class="btn btn-big btn-orange fr">去看看</a>
                            <p class="tprice">
                            <dfn>¥<i>${prodProduct.sellPriceYuan?if_exists}</i><small>起</small></dfn>
                            <del>¥${prodProduct.marketPriceYuan?if_exists}</del>
                            </p>
                            <p class="tmu">
                                <span class="tstar"><i style="width:<@s.property value='avgScore'/>%"></i></span>
                                <a class="tcom" target="_blank" href="http://www.lvmama.com/product/<@s.property value="prodProduct.productId"/>#dianping"><@s.property value="cmtCount"/>人评价</a>
                            </p>
                            <div class="dot-line"></div>
                            <p class="other">
                                <span class="ttime"><i class="icon icon-time"></i><i class="countdown" data-time="<@s.property  value='diff'/>"></i></span>
                                <span class="text"><em><@s.property  value="orderCount"/></em>份已出售</span>
                            </p>
                        </dd>
                    </dl>
                </li>
                </@s.iterator>
                    </ul>
                </div>
            </div> <!--//.tsidebox-->
            
            <@s.iterator value="recommendPicList" status="st" var="benner">  
            <@s.if test='#st.count==5'>
            <div class="adside">
                <a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="328" height="90" alt="" /></a>
            </div>
            </@s.if>
            
            <@s.if test='#st.count==6 && null != #benner'>
            <div class="adside">
                <a target="_blank" href="<@s.property value="#benner.url"/>"><img to="<@s.property value="#benner.imgUrl"/>" width="328" height="90" alt="" /></a>
            </div>
            </@s.if>
            </@s.iterator>
        </div> <!--//.tsidefixed-->
    </div> <!--//.tside-->
</div> <!-- //.wrapbox4 -->

<div class="wrap wrapbox5">
    <div class="tmain clearfix">       
    </div> <!--//.tmain-->
    
    <p class="graybox">
        <a target="_blank" href="http://www.lvmama.com/tuangou/all" class="linkmore">查看更多驴妈妈旅游特卖商品&gt;&gt;</a>
    </p>
    
</div> <!-- //.wrapbox5 -->


<!--底部-->
<div class="t_footer">
    <div class="t_footer_inner">
        <h5>驴妈妈旅游特卖会，最好的旅游特卖服务</h5>
        <p>特卖会产品均为驴妈妈资深产品专家结合当季热点，精挑金牌景点、口碑酒店，与景区合力打造的当季旅游精品，提供服务好，价格好，质量好的高性价比“三好”产品！</p>
        <dl>
            <dt><a href='http://www.lvmama.com/tuangou/all/all-all-${Request["tgType"]}-1' title="全部旅游团购">全部旅游团购</a></dt>
            <dd><a href='http://www.lvmama.com/tuangou/all/ticket-all-${Request["tgType"]}-1' title="景点门票团购">景点门票团购</a></dd>
            <dd><a href='http://www.lvmama.com/tuangou/all/surround-all-${Request["tgType"]}-1' title="周边游团购">周边游团购</a></dd>
            <dd><a href='http://www.lvmama.com/tuangou/all/hotel-all-${Request["tgType"]}-1' title="酒店团购">酒店团购</a></dd>
            <dd><a href='http://www.lvmama.com/tuangou/all/china-all-${Request["tgType"]}-1' title="国内旅游团购">国内旅游团购</a></dd>
            <dd><a href='http://www.lvmama.com/tuangou/all/abroad-all-${Request["tgType"]}-1' title="出境旅游团购">出境旅游团购</a></dd>
        </dl>
        <dl>
 <dd><a tager="_blank" href="http://www.lvmama.com/tuangou/beijing/" title="北京团购">北京团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/beihai/" title="北海团购">北海团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/dalian/" title="大连团购">大连团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/guizhou/" title="贵州团购">贵州团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/guilin/" title="桂林团购">桂林团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/haerbin/" title="哈尔滨团购">哈尔滨团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/hangzhou/" title="杭州团购">杭州团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/jiuzhaigou/" title="九寨沟团购">九寨沟团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/kunming/" title="昆明团购">昆明团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/qiandaohu/" title="千岛湖团购">千岛湖团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/qingdao/" title="青岛团购">青岛团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/sanya/" title="三亚团购">三亚团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/shanghai/" title="上海团购">上海团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/sichuan/" title="四川团购">四川团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/taiwan/" title="台湾团购">台湾团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/tianjin/" title="天津团购">天津团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/xian/" title="西安团购">西安团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/xizang/" title="西藏团购">西藏团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/xiamen/" title="厦门团购">厦门团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/yunnan/" title="云南团购">云南团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/zhangjiajie/" title="张家界团购">张家界团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/balidao/" title="巴厘岛团购">巴厘岛团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/hanguo/" title="韩国团购">韩国团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/pujidao/" title="普吉岛团购">普吉岛团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/riben/" title="日本团购">日本团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/saibandao/" title="塞班岛团购">塞班岛团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/taiguo/" title="泰国团购">泰国团购</a></dd>
<dd><a tager="_blank" href="http://www.lvmama.com/tuangou/meiguo/" title="美国团购">美国团购</a></dd>
        </dl>
        <img src="//pic.lvmama.com/img/v5/tuangou/t-footer.gif" width="1000" height="92" border="0" usemap="#Map">
        <map name="Map">
          <area shape="rect" coords="3,4,251,88" href="http://shouji.lvmama.com" target="_blank" title="驴妈妈手机客户端">
          <area shape="rect" coords="557,2,794,89" href="http://www.lvmama.com/main/edm/edmSubscribe!showUpdateSubscribeEmail.do" target="_blank" title="邮件订阅">
          <area shape="rect" coords="835,16,990,44" href="http://weibo.com/lvmamas" target="_blank" title="新浪微博">
          <area shape="rect" coords="837,47,991,74" href="http://t.qq.com/lvmamalvyou" target="_blank" title="腾讯微博">
        </map>
    </div>
</div>
<div class="lvtg_bottom">
	<!-- guide channel -->
	<#include "/common/guide_channel.ftl">
    </div><!--bottom end-->
    <div class="hh_cooperate">
	<#include "/WEB-INF/pages/staticHtml/friend_link/tuangou_footer.ftl">
    </div>
</div>
<!--公共底部-->
<script src="http://pic.lvmama.com/js/common/copyright.js"></script>

<!-- 频道公用js-->
<script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/new_v/top/header-air_new.js"></script>

<script src="http://pic.lvmama.com/js/v5/tuangou.js"></script>

<!--统计代码-->
<script src="http://pic.lvmama.com/js/common/losc.js"></script>
<script type="text/javascript">
  function switchIndex(placeCode,placeId,placeName){
        var $switchIndexForm = $('#switchIndexForm');
        $('#fromPlaceCode').val(placeCode);
        $('#fromPlaceId').val(placeId);
        $('#fromPlaceName').val(placeName);
        $switchIndexForm.submit();
   }
   $(document).ready(function(){
      $("p.js_Morecity_btn").bind("click",function(){
       		var div=$("#divMoreCity");
       		if(div.css("display")=="none"){
       			$("#divMoreCity").css("display","");
       			$("#moreId").addClass("city_show");
       		}	
       		else{
       			$("#divMoreCity").css("display","none");
       			$("#moreId").removeClass("city_show");
       		}
       });
   });
</script>
	<script>
		cmCreatePageviewTag("团购首页", "N0001", null, null);
    </script>
</body>
</html>
