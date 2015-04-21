<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
   <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/new_v/header-air.css,/styles/v3/core.css,/styles/new_v/ob_common/ui-components.css,/styles/v3/module.css,/styles/v3/form.css,/styles/v3/channel.css" >
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v4/modules/step.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v4/order.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v4/modules/tip.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v4/group-buy.css">

</head>
<body class="groupBuy">
<div class="order-header wrap">
    <div class="header-inner">
        <a class="logo" href="http://www.lvmama.com/">自助天下游 就找驴妈妈</a>
        <p class="serverTime">
            服务热线时间：8:00-20:00（全年无休）
        </p>
        <p class="serverPhone">
            <strong>400-6040-616</strong>（免长话费）
        </p>
    </div>
</div>
<div class="wrap buy-wrap">
    <#include "/WEB-INF/pages/tuangou/navigation.ftl">
    <@navigation stepView="5"/>
    <h3 class="buy-head-small"><b>预订：</b>【${mainProdBranch.prodProduct.productName?if_exists}】</h3>
    <div class="order-main border">
        <div class="main">
            <div class="pay-feedback">
                <!--预约失败-->
                <div class="tipbox tip-success tip-nowrap">
                <span class="tip-icon-big tip-icon-big-error buy-error"></span>
                <div class="tip-content">
                    <h3 class="tip-color-title" style="color:#000;">对不起，您的订单预约失败。</h3>
                </div>
                <div class="tip-other tip-align pay-backinfo">
                    <div class="backinfo-item">
                        <p>您可以重新进行预约，或联系我们的客服，客服电话： <b  class="pink">400-6040-616</b></p>
                    </div>
                    <div class="backinfo-item">
                        <div class="codeapp-box" alt="扫描下载客户端">
                            <span class="codeapp">
                                <img alt="" src="http://www.lvmama.com/callback/generateCodeImage.do?userid=ff8080813726f6e9013736b517a532c6">
                            </span>
                        </div>
                    </div>
                </div>
                </div>
                <!--预约失败-->
            </div>
        </div>
    </div>
</div>
<div id="order-footer" class="lv-footer wrap">
</div>
<script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js"></script>
<script src="http://pic.lvmama.com/min/index.php?f=/js/common/footer.js"></script>
</body>
</html>