<!DOCTYPE html>
<html lang="en">
<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
	
	<meta charset="UTF-8">
	<meta name="Generator" content="EditPlus®">
	<meta name="Author" content="">
	<meta name="Keywords" content="">
	<meta name="Description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta name="renderer" content="webkit">
	<title>确认订单-云购物商城</title>
	<link rel="shortcut icon" type="image/x-icon" href="img/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<link rel="stylesheet" type="text/css" href="css/car/base.css">
	<link rel="stylesheet" type="text/css" href="css/car/home.css">

</head>
<body>

<header id="pc-header">
	<div class="pc-header-nav">
		<div class="pc-header-con">
			<div class="fl pc-header-link" >您好！，欢迎来云购物 <a href="login.html" target="_blank">请登录</a> <a href="register.html" target="_blank"> 免费注册</a></div>
			<div class="fr pc-header-list top-nav">
				<ul>
					<li>
						<div class="nav"><i class="pc-top-icon"></i><a href="#">我的订单</a></div>
						<div class="con">
							<dl>
								<dt><a href="">批发进货</a></dt>
								<dd><a href="">已买到货品</a></dd>
								<dd><a href="">优惠券</a></dd>
								<dd><a href="">店铺动态</a></dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="nav"><i class="pc-top-icon"></i><a href="#">我的商城</a></div>
						<div class="con">
							<dl>
								<dt><a href="">批发进货</a></dt>
								<dd><a href="">已买到货品</a></dd>
								<dd><a href="">优惠券</a></dd>
								<dd><a href="">店铺动态</a></dd>
							</dl>
						</div>
					</li>
					<li><a href="#">我的云购</a></li>
					<li><a href="#">我的收藏</a></li>
					<li><a href="#">会员中心</a></li>
					<li><a href="#">客户服务</a></li>
					<li><a href="#">帮助中心</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="pc-header-logo clearfix">
		<div class="pc-fl-logo fl">
			<h1>
				<a href="index.html"></a>
			</h1>
		</div>
		<div class="head-form fl">
			<form class="clearfix">
				<input class="search-text" accesskey="" id="key" autocomplete="off" placeholder="洗衣机" type="text">
				<button class="button" onclick="search('key');return false;">搜索</button>
			</form>
			<div class="words-text clearfix">
				<a href="#" class="red">1元秒爆</a>
				<a href="#">低至五折</a>
				<a href="#">农用物资</a>
				<a href="#">佳能相机</a>
				<a href="#">服装城</a>
				<a href="#">买4免1</a>
				<a href="#">家电秒杀</a>
				<a href="#">农耕机械</a>
				<a href="#">手机新品季</a>
			</div>
		</div>
		<div class="fr pc-head-car">
			<i class="icon-car"></i>
			<a href="#">我的购物车</a>
		</div>
	</div>
	<!--  顶部    start-->
	<div class="yHeader">
		<!-- 导航   start  -->
		<div class="yNavIndex">
			<ul class="yMenuIndex" style="margin-left:0">
				<li style="background:#d1201e"><a href="" target="_blank">云购首页</a></li>
				<li><a href="" target="_blank">女士护肤 </a></li>
				<li><a href="" target="_blank">男士护肤</a></li>
				<li><a href="" target="_blank">洗护染发</a></li>
				<li><a href="" target="_blank">染发</a></li>
				<li><a href="" target="_blank">彩妆</a></li>
				<li><a href="" target="_blank">品牌故事</a></li>
			</ul>
		</div>
		<!-- 导航   end  -->
	</div>

</header>

<div class="center" style="background:#fff">
	<!--收货地址body部分开始-->
	<div class="border_top_cart">
		<script type="text/javascript">
            var checkoutConfig={
                addressMatch:'common',
                addressMatchVarName:'data',
                hasPresales:false,
                hasBigTv:false,
                hasAir:false,
                hasScales:false,
                hasGiftcard:false,
                totalPrice:244.00,
                postage:10,//运费
                postFree:true,//活动是否免邮了
                bcPrice:150,//计算界值
                activityDiscountMoney:0.00,//活动优惠
                showCouponBox:0,
                invoice:{
                    NA:"0",
                    personal:"1",
                    company:"2",
                    electronic:"4"
                }
            };
            var miniCartDisable=true;
		</script>
		<div class="container">
			<div class="checkout-box">
				<form  id="checkoutForm" action="#" method="post">
					<div class="checkout-box-bd">
						<!-- 地址状态 0：默认选择；1：新增地址；2：修改地址 -->
						<input type="hidden" name="Checkout[addressState]" id="addrState"   value="0">
						<!-- 收货地址 -->
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">收货地址</h2>
								<!---->
							</div>
							<div class="box-bd">
								<div class="clearfix xm-address-list" id="checkoutAddrList">
									<dl class="item" >
										<dt>
											<strong class="itemConsignee">留刘海</strong>
											<span class="itemTag tag">家</span>
										</dt>
										<dd>
											<p class="tel itemTel">188010666666</p>
											<p class="itemRegion">北京市 海淀区</p>
											<p class="itemStreet">北京市海淀区双榆树</p>
											<span class="edit-btn J_editAddr">编辑</span>
										</dd>
										<dd style="display:none">
											<input type="radio" name="Checkout[address]" class="addressId"  value="10140916720030323">
										</dd>
									</dl>
									<div class="item use-new-addr"  id="J_useNewAddr" data-state="off">
										<span class="iconfont icon-add"><img src="images/add_cart.png" /></span>
										使用新地址
									</div>
								</div>
								<input type="hidden" name="newAddress[type]" id="newType" value="common">
								<input type="hidden" name="newAddress[consignee]" id="newConsignee">
								<input type="hidden" name="newAddress[province]" id="newProvince">
								<input type="hidden" name="newAddress[city]" id="newCity">
								<input type="hidden" name="newAddress[district]" id="newCounty">
								<input type="hidden" name="newAddress[address]" id="newStreet">
								<input type="hidden" name="newAddress[zipcode]" id="newZipcode">
								<input type="hidden" name="newAddress[tel]" id="newTel">
								<input type="hidden" name="newAddress[tag_name]" id="newTag">
								<!--点击弹出新增/收货地址界面start-->
								<div class="xm-edit-addr-box" id="J_editAddrBox">
									<div class="bd">
										<div class="item">
											<label>收货人姓名<span>*</span></label>
											<input type="text" name="userAddress[consignee]" id="Consignee" class="input" placeholder="收货人姓名" maxlength="15" autocomplete='off'>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>联系电话<span>*</span></label>
											<input type="text" name="userAddress[tel]" class="input" id="Telephone" placeholder="11位手机号" autocomplete='off'>
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>地址<span>*</span></label>
											<select name="userAddress[province]" id="Provinces" class="select-1">
												<option>省份/自治区</option>
											</select>
											<select name="userAddress[city]"  id="Citys" class="select-2" disabled>
												<option>城市/地区/自治州</option>
											</select>
											<select name="userAddress[county]"  id="Countys" class="select-3" disabled>
												<option>区/县</option>
											</select>
											<textarea   name="userAddress[street]" class="input-area" id="Street" placeholder="路名或街道地址，门牌号"></textarea>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>邮政编码<span>*</span></label>
											<input type="text" name="userAddress[zipcode]" id="Zipcode" class="input" placeholder="邮政编码"  autocomplete='off'>
											<p class="zipcode-tip" id="zipcodeTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>地址标签<span>*</span></label>
											<input type="text" name="userAddress[tag]" id="Tag" class="input" placeholder='地址标签：如"家"、"公司"。限5个字内'  >
											<p class="tip-msg tipMsg"></p>
										</div>
									</div>
									<div class="ft clearfix">
										<button  type="button"  class="btn btn-lineDake btn-small " id="J_editAddrCancel">取消</button>
										<button type="button" class="btn btn-primary  btn-small " id="J_editAddrOk">保存</button>
									</div>
								</div>
								<!--点击弹出新增/收货地址界面end-->
								<div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
							</div>                </div>
						<!-- 收货地址 END-->
						<div id="checkoutPayment">
							<!-- 支付方式 -->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">支付方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutPaymentList" class="checkout-option-list clearfix J_optionList">
										<li class="item selected">
											<input type="radio" name="Checkout[pay_id]" checked="checked" value="1">
											<p>
												在线支付                                <span></span>
											</p>
										</li>
									</ul>
								</div>
							</div>
							<!-- 支付方式 END-->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">配送方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutShipmentList" class="checkout-option-list clearfix J_optionList">
										<li class="item selected">
											<input type="radio" data-price="0" name="Checkout[shipment_id]" checked="checked" value="1">
											<p>
												快递配送（免运费）                                <span></span>
											</p>
										</li>
									</ul>
								</div>
							</div>
							<!-- 配送方式 END-->                    <!-- 配送方式 END-->
						</div>
						<!-- 送货时间 -->
						<div class="xm-box">
							<div class="box-hd">
								<h2 class="title">送货时间</h2>
							</div>
							<div class="box-bd">
								<ul class="checkout-option-list clearfix J_optionList">
									<li class="item selected"><input type="radio" checked="checked" name="Checkout[best_time]" value="1"><p>不限送货时间<span>周一至周日</span></p></li><li class="item "><input type="radio"  name="Checkout[best_time]" value="2"><p>工作日送货<span>周一至周五</span></p></li><li class="item "><input type="radio"  name="Checkout[best_time]" value="3"><p>双休日、假日送货<span>周六至周日</span></p></li>                        </ul>
							</div>
						</div>
						<!-- 送货时间 END-->
						<!-- 发票信息 -->
						<div id="checkoutInvoice">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">发票信息</h2>
								</div>
								<div class="box-bd">
									<ul class="checkout-option-list checkout-option-invoice clearfix J_optionList J_optionInvoice">
										<li class="hide">
											电子个人发票4
										</li>
										<li class="item selected">
											<!--<label><input type="radio"  class="needInvoice" value="0" name="Checkout[invoice]">不开发票</label>-->
											<input type="radio"    checked="checked"  value="4" name="Checkout[invoice]">
											<p>电子发票（非纸质）</p>
										</li>
										<li class="item ">
											<input type="radio"   value="1" name="Checkout[invoice]">
											<p>普通发票（纸质）</p>
										</li>
									</ul>
									<p id="eInvoiceTip" class="e-invoice-tip ">
										电子发票是税务局认可的有效凭证，可作为售后维权凭据，不随商品寄送。开票后不可更换纸质发票，如需报销请选择普通发票。<a href="#" target="_blank">什么是电子发票？</a>
									</p>
									<div class="invoice-info nvoice-info-1" id="checkoutInvoiceElectronic" style="display:none;">

										<p class="tip">电子发票目前仅对个人用户开具，不可用于单位报销 ，不随商品寄送</p>
										<p>发票内容：购买商品明细</p>
										<p>发票抬头：个人</p>
										<p>
											<span class="hide"><input type="radio" value="4" name="Checkout[invoice_type]"   checked="checked"   id="electronicPersonal" class="invoiceType"></span>
										<dl>
											<dt>什么是电子发票?</dt>
											<dd>&#903; 电子发票是纸质发票的映像，是税务局认可的有效凭证，与传统纸质发票具有同等法律效力，可作为售后维权凭据。</dd>
											<dd>&#903; 开具电子服务于个人，开票后不可更换纸质发票，不可用于单位报销。</dd>
											<dd>&#903; 您在订单详情的"发票信息"栏可查看、下载您的电子发票。<a href="#" target="_blank">什么是电子发票？</a></dd>
										</dl>
										</p>
									</div>
									<div class="invoice-info invoice-info-2" id="checkoutInvoiceDetail"  style="display:none;" >
										<p>发票内容：购买商品明细</p>
										<p>
											发票抬头：请确认单位名称正确,以免因名称错误耽搁您的报销。注：合约机话费仅能开个人发票
										</p>
										<ul class="type clearfix J_invoiceType">
											<li class="hide">
												<input type="radio" value="0" name="Checkout[invoice_type]" id="noNeedInvoice" >
											</li>
											<li class="">
												<input  class="invoiceType" type="radio" id="commonPersonal" name="Checkout[invoice_type]" value="1" >
												个人
											</li>
											<li class="">
												<input  class="invoiceType" type="radio" name="Checkout[invoice_type]" value="2" >
												单位
											</li>
										</ul>
										<div  id='CheckoutInvoiceTitle' class=" hide  invoice-title">
											<label for="Checkout[invoice_title]">单位名称：</label>
											<input name="Checkout[invoice_title]" type="text" maxlength="49" value="" class="input"> <span class="tip-msg J_tipMsg"></span>
										</div>

									</div>

								</div>
							</div>                </div>
						<!-- 发票信息 END-->
					</div>
					<div class="checkout-box-ft">
						<!-- 商品清单 -->
						<div id="checkoutGoodsList" class="checkout-goods-box">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">确认订单信息</h2>
								</div>
								<div class="box-bd">
									<dl class="checkout-goods-list">
										<dt class="clearfix">
											<span class="col col-1">商品名称</span>
											<span class="col col-2">购买价格</span>
											<span class="col col-3">购买数量</span>
											<span class="col col-4">小计（元）</span>
										</dt>
										<dd class="item clearfix">
											<div class="item-row">
												<div class="col col-1">
													<div class="g-pic">
														<img src="images/shangpinxiangqing/X1.png" width="40" height="40" />
													</div>
													<div class="g-info">
														<a href="#" target="_blank">
															赛亿（shinee)取暖器家用/取暖电器/电暖器/电暖气台式摇头暖风机HN2118PT
														</a>
													</div>
												</div>

												<div class="col col-2">39元</div>
												<div class="col col-3">1</div>
												<div class="col col-4">39元</div>
											</div>
										</dd>
										<dd class="item clearfix">
											<div class="item-row">
												<div class="col col-1">
													<div class="g-pic">
														<img src="images/shangpinxiangqing/X-1.png" width="40" height="40" />
													</div>
													<div class="g-info">
														<a href="#" target="_blank">
															赛亿（shinee)取暖器家用/取暖电器/电暖器/电暖气台式摇头暖风机HN2118PT
														</a>
													</div>
												</div>
												<div class="col col-2">49元</div>
												<div class="col col-3">1</div>
												<div class="col col-4">49元</div>
											</div>
										</dd>
										<dd class="item clearfix">
											<div class="item-row">
												<div class="col col-1">
													<div class="g-pic">
														<img src="images/shangpinxiangqing/X2.png" width="40" height="40" />
													</div>
													<div class="g-info">
														<a href="#" target="_blank">
															赛亿（shinee)取暖器家用/取暖电器/电暖器/电暖气台式摇头暖风机HN2118PT
														</a>
													</div>
												</div>

												<div class="col col-2">39元</div>
												<div class="col col-3">4</div>
												<div class="col col-4">156元</div>
											</div>
										</dd>
									</dl>
									<div class="checkout-count clearfix">
										<div class="checkout-count-extend xm-add-buy">
											<h3 class="title">会员留言</h2></br>
												<input type="text" />

										</div>
										<!-- checkout-count-extend -->
										<div class="checkout-price">
											<ul>

												<li>
													订单总额：<span>244元</span>
												</li>
												<li>
													活动优惠：<span>-0元</span>
													<script type="text/javascript">
                                                        checkoutConfig.activityDiscountMoney=0;
                                                        checkoutConfig.totalPrice=244.00;
													</script>
												</li>
												<li>
													优惠券抵扣：<span id="couponDesc">-0元</span>
												</li>
												<li>
													运费：<span id="postageDesc">0元</span>
												</li>
											</ul>
											<p class="checkout-total">应付总额：<span><strong id="totalPrice">244</strong>元</span></p>
										</div>
										<!--  -->
									</div>
								</div>
							</div>

							<!--S 加价购 产品选择弹框 -->
							<div class="modal hide modal-choose-pro" id="J_choosePro-664">
								<div class="modal-header">
									<span class="close" data-dismiss='modal'><i class="iconfont">&#xe617;</i></span>
									<h3>选择产品</h3>
									<div class="more">
										<div class="xm-recommend-page clearfix">
											<a class="page-btn-prev   J_carouselPrev iconfont" href="javascript: void(0);">&#xe604;</a><a class="page-btn-next  J_carouselNext iconfont" href="javascript: void(0);">&#xe605;</a>
										</div>
									</div>
								</div>
								<div class="modal-body J_chooseProCarousel">
									<div class="J_carouselWrap modal-choose-pro-list-wrap">
										<ul class="clearfix J_carouselList">
										</ul>
									</div>
								</div>
								<div class="modal-footer">
									<a href="#" class="btn btn-disabled J_chooseProBtn">加入购物车</a>
								</div>
							</div>
							<!--E 加价购 产品选择弹框 -->

							<!--S 保障计划 产品选择弹框 -->


						</div>
						<!-- 商品清单 END -->
						<input type="hidden"  id="couponType" name="Checkout[couponsType]">
						<input type="hidden" id="couponValue" name="Checkout[couponsValue]">
						<div class="checkout-confirm">

							<a href="#" class="btn btn-lineDakeLight btn-back-cart">返回购物车</a>
							<a href="my-apy.html" class="btn btn-primary">立即下单</a>

						</div>
					</div>
			</div>

			</form>

		</div>
		<!-- 禮品卡提示 S-->
		<div class="modal hide lipin-modal" id="lipinTip">
			<div class="modal-header">
				<h2 class="title">温馨提示</h2>
				<p> 为保障您的利益与安全，下单后礼品卡将会被使用，<br>
					且订单信息将不可修改。请确认收货信息：</p>
			</div>
			<div class="modal-body">
				<ul>
					<li><strong>收&nbsp;&nbsp;货&nbsp;&nbsp;人：</strong><span id="lipin-uname"></span></li>
					<li><strong>联系电话：</strong><span id="lipin-uphone"></span></li>
					<li><strong>收货地址：</strong><span id="lipin-uaddr"></span></li>
				</ul>
			</div>
			<div class="modal-footer">
				<span class="btn btn-primary" id="useGiftCard">确认下单</span><span class="btn btn-dakeLight" id="closeGiftCard">返回修改</span>
			</div>
		</div>
		<!--  禮品卡提示 E-->
		<!-- 预售提示 S-->
		<div class="modal hide yushou-modal" id="yushouTip">
			<div class="modal-body">
				<h2>请确认收货地址及发货时间</h2>
				<ul class="list">
					<li>
						<strong>请确认配送地址，提交后不可变更：</strong>
						<p id="yushouAddr"> </p>
						<span class="icon-common icon-1"></span>
					</li>
					<li>
						<strong>支付后发货</strong>
						<p>如您随预售商品一起购买的商品，将与预售商品一起发货</p>
						<span class="icon-common icon-2"></span>
					</li>
					<li>
						<strong>以支付价格为准</strong>
						<p>如预售产品发生调价，已支付订单价格将不受影响。</p>
						<span class="icon-common icon-3"></span>
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<p id="yushouOk" class="yushou-ok">
					<span class="icon-checkbox"><i class="iconfont">&#xe626;</i></span>
					我已确认收货地址正确，不再变更</p>
				<span class="btn btn-lineDakeLight" data-dismiss="modal">返回修改地址</span>
				<span class="btn btn-primary" id="yushouCheckout">继续下单</span>

			</div>
		</div>
		<!--  预售提示 E-->

		<script id="newAddrTemplate" type="text/x-dot-template">
			<dl class="item selected" data-isnew="true" data-consignee="{{=it.consignee}}" data-tel="{{=it.tel}}" data-province="{{=it.province}}" data-provincename="{{=it.provinceName}}" data-city="{{=it.city}}" data-cityname="{{=it.cityName}}" data-county="{{=it.county}}" data-countyname="{{=it.countyName}}" data-zipcode="{{=it.zipcode}}" data-street="{{=it.street}}" data-tag="{{=it.tag}}">
				<dt>
					<strong class="itemConsignee">{{=it.consignee}}</strong>
					{{? it.tag }}
					<span  class="itemTag tag">{{=it.tag}}</span>
					{{?}}
				</dt>
				<dd>
					<p class="tel itemTel">{{=it.tel}}</p>
					<p  class="itemRegion">{{=it.provinceName}} {{=it.cityName}} {{=it.countyName}}</p>
					<p  class="itemStreet">{{=it.street}} ({{=it.zipcode}})</p>
					<span class="edit-btn J_editAddr">编辑</span>
				</dd>
			</dl>
		</script>


		<!-- 保险弹窗 -->
		<!-- 保险弹窗 -->




		<script src="js/base.min.js"></script>

		<script type="text/javascript" src="js/address_all.js"></script>
		<script type="text/javascript" src="js/checkout.min.js"></script>
	</div>
	<!--收货地址body部分结束-->
</div>



<div style="height:100px"></div>

<footer>
	<div class="pc-footer-top">
		<div class="center">
			<ul class="clearfix">
				<li>
					<span>关于我们</span>
					<a href="#">关于我们</a>
					<a href="#">诚聘英才</a>
					<a href="#">用户服务协议</a>
					<a href="#">网站服务条款</a>
					<a href="#">联系我们</a>
				</li>
				<li class="lw">
					<span>购物指南</span>
					<a href="#">新手上路</a>
					<a href="#">订单查询</a>
					<a href="#">会员介绍</a>
					<a href="#">网站服务条款</a>
					<a href="#">帮助中心</a>
				</li>
				<li class="lw">
					<span>消费者保障</span>
					<a href="#">人工验货</a>
					<a href="#">退货退款政策</a>
					<a href="#">运费补贴卡</a>
					<a href="#">无忧售后</a>
					<a href="#">先行赔付</a>
				</li>
				<li class="lw">
					<span>商务合作</span>
					<a href="#">人工验货</a>
					<a href="#">退货退款政策</a>
					<a href="#">运费补贴卡</a>
					<a href="#">无忧售后</a>
					<a href="#">先行赔付</a>
				</li>
				<li class="lss">
					<span>下载手机版</span>
					<div class="clearfix lss-pa">
						<div class="fl lss-img"><img src="img/icon/code.png" alt=""></div>
						<div class="fl" style="padding-left:20px">
							<h4>扫描下载云购APP</h4>
							<p>把优惠握在手心</p>
							<P>把潮流带在身边</P>
							<P></P>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="pc-footer-lin">
			<div class="center">
				<p>友情链接：
					卡宝宝信用卡
					梦芭莎网上购物
					手游交易平台
					法律咨询
					深圳地图
					P2P网贷导航
					名鞋库
					万表网
					叮当音乐网
					114票务网
					儿歌视频大全
				</p>
				<p>
					京ICP证1900075号  京ICP备20051110号-5  京公网安备110104734773474323  统一社会信用代码 91113443434371298269B  食品流通许可证SP1101435445645645640352397
				</p>
				<p style="padding-bottom:30px">版物经营许可证 新出发京零字第朝160018号  Copyright©2011-2015 版权所有 ZHE800.COM </p>
			</div>
		</div>
	</div>
</footer>
<script type="text/javascript">
    //hover 触发两个事件，鼠标移上去和移走
    //mousehover 只触发移上去事件
    $(".top-nav ul li").hover(function(){
        $(this).addClass("hover").siblings().removeClass("hover");
        $(this).find("li .nav a").addClass("hover");
        $(this).find(".con").show();
    },function(){
        //$(this).css("background-color","#f5f5f5");
        $(this).find(".con").hide();
        //$(this).find(".nav a").removeClass("hover");
        $(this).removeClass("hover");
        $(this).find(".nav a").removeClass("hover");
    })
</script>


</body>
</html>