package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/12.
 */

public class HomeResult {


    /**
     * GoodsRush : [{"RushId":"f79b404f-4e9f-49a2-932c-106395d4ffa5","Goods_MonthCount":0,"GoodsPrice_Stock":911,"Goods_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Goods_ShopType":1,"GoodsPrice_ID":"45bc81fb-7ca8-4e2e-848c-d4e0b673392e","Goods_Name":"IPhone 兵222","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p>464684<\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":"IPhone 7 亮黑色","GoodsPrice_AttrName":"32G","GoodsPrice_VirtualPrice":4000,"RushStartTime":"2018-07-11 22:00:00","RushEndTime":"2018-07-12 00:00:00","RushNumber":0,"Bond":100,"Price":2000,"GoodsPrice_Price":6000,"IsEnd":0},{"RushId":"f79b404f-4e9f-49a2-932c-106395d4ffa5","Goods_MonthCount":0,"GoodsPrice_Stock":911,"Goods_ID":"f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7","Goods_ShopType":1,"GoodsPrice_ID":"45bc81fb-7ca8-4e2e-848c-d4e0b673392e","Goods_Name":"IPhone 兵222","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p>464684<\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":"IPhone 7 亮黑色","GoodsPrice_AttrName":"32G","GoodsPrice_VirtualPrice":4000,"RushStartTime":"2018-07-11 22:00:00","RushEndTime":"2018-07-12 00:00:00","RushNumber":0,"Bond":100,"Price":2000,"GoodsPrice_Price":6000,"IsEnd":0}]
     * GoodsOpenedAward : [{"Goods_ID":"fd1e07eb-1940-4388-941e-4d7a6b5c9759","Goods_ShopType":2,"GoodsPrice_ID":"863dd59f-154c-49b4-bd5a-d9a1259e8470","AwardId":"7750a589-426e-4205-ad87-acafd98375b3","Goods_Name":"雅茜薇兰罗马之恋系列","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635201428251760617.jpg\" title=\"罗马之恋系列1.jpg\" alt=\"罗马之恋系列1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635429553257629892.jpg\" title=\"罗马之恋系列2.jpg\" alt=\"罗马之恋系列2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635668615753998401.jpg\" title=\"罗马之恋系列3.jpg\" alt=\"罗马之恋系列3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635984240756668853.jpg\" title=\"罗马之恋系列4.jpg\" alt=\"罗马之恋系列4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636213928256767373.jpg\" title=\"罗马之恋系列5.jpg\" alt=\"罗马之恋系列5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636460803259878452.jpg\" title=\"罗马之恋系列6.jpg\" alt=\"罗马之恋系列6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636807678253519186.jpg\" title=\"罗马之恋系列7.jpg\" alt=\"罗马之恋系列7.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637046740754589522.jpg\" title=\"罗马之恋系列8.jpg\" alt=\"罗马之恋系列8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637284240752430613.jpg\" title=\"罗马之恋系列9.jpg\" alt=\"罗马之恋系列9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637526428255257612.jpg\" title=\"罗马之恋系列10.jpg\" alt=\"罗马之恋系列10.jpg\"/><\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":null,"GoodsPrice_AttrName":"1套","GoodsPrice_VirtualPrice":88,"GoodsPrice_Stock":9945,"AwardPeopleCount":100,"NeedCount":100,"Bond":8,"Price":300,"IsEnd":1,"AwardTime":"2018-07-11 00:00:00"}]
     * GoodsNewAward : [{"Goods_ID":"fd1e07eb-1940-4388-941e-4d7a6b5c9759","Goods_ShopType":2,"GoodsPrice_ID":"863dd59f-154c-49b4-bd5a-d9a1259e8470","AwardId":"7750a589-426e-4205-ad87-acafd98375b3","Goods_Name":"雅茜薇兰罗马之恋系列","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg","Goods_Content":"<p><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635201428251760617.jpg\" title=\"罗马之恋系列1.jpg\" alt=\"罗马之恋系列1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635429553257629892.jpg\" title=\"罗马之恋系列2.jpg\" alt=\"罗马之恋系列2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635668615753998401.jpg\" title=\"罗马之恋系列3.jpg\" alt=\"罗马之恋系列3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878635984240756668853.jpg\" title=\"罗马之恋系列4.jpg\" alt=\"罗马之恋系列4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636213928256767373.jpg\" title=\"罗马之恋系列5.jpg\" alt=\"罗马之恋系列5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636460803259878452.jpg\" title=\"罗马之恋系列6.jpg\" alt=\"罗马之恋系列6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878636807678253519186.jpg\" title=\"罗马之恋系列7.jpg\" alt=\"罗马之恋系列7.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637046740754589522.jpg\" title=\"罗马之恋系列8.jpg\" alt=\"罗马之恋系列8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637284240752430613.jpg\" title=\"罗马之恋系列9.jpg\" alt=\"罗马之恋系列9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878637526428255257612.jpg\" title=\"罗马之恋系列10.jpg\" alt=\"罗马之恋系列10.jpg\"/><\/p>","Goods_Parameter":null,"GoodsPrice_SpecName":null,"GoodsPrice_AttrName":"1套","GoodsPrice_VirtualPrice":88,"GoodsPrice_Stock":9945,"AwardPeopleCount":100,"NeedCount":100,"Bond":8,"Price":300,"IsEnd":1,"AwardTime":"2018-07-11 00:00:00"}]
     * GoodsTj : [{"Goods_ID":"1a2fbb6e-863b-45de-917c-cd76056fcadc","Goods_Name":"豆子","Goods_BrandName":"爱美连","Goods_Describe":"1","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/5dd4a181-4428-43d6-b072-ab0176953cf8.jpg","Goods_Content":null,"Goods_LookCount":0,"Goods_MonthCount":0,"Goods_Sort":100,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"77e3412d-3a92-40b2-8b78-e3fa829cf686","Goods_Name":"dwqdwq","Goods_BrandName":"dwqd","Goods_Describe":"dwqd","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/f3e1015e-9fff-4864-baa9-63cfd43fb8af.jpg","Goods_Content":"<p>dwqd<\/p>","Goods_LookCount":3,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"bac3e3e2-80f3-4455-8216-fe9558b2f0e1","Goods_Name":"dwqdw","Goods_BrandName":"dwqdw","Goods_Describe":"dwqd","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/5b4640c0-5e76-48d6-8aeb-9d7b365e8715.jpg","Goods_Content":"<p>dwqwqeqwe<\/p>","Goods_LookCount":3,"Goods_MonthCount":0,"Goods_Sort":99,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"b9bfdcf0-88ef-41b8-b074-b5c2e0dad042","Goods_Name":"雅茜薇兰罗马之恋系列玫蔻原浆","Goods_BrandName":"雅茜薇兰","Goods_Describe":"雅茜薇兰罗马之恋系列玫蔻原浆","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/2a908ea7-5a5f-4f3f-b6a7-ae7a17849e9e.png","Goods_Content":"<p><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793598614070332902257.jpg\" title=\"罗马之恋系列1.jpg\" alt=\"罗马之恋系列1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793598904691614413925.jpg\" title=\"罗马之恋系列2.jpg\" alt=\"罗马之恋系列2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793599164063295955310.jpg\" title=\"罗马之恋系列3.jpg\" alt=\"罗马之恋系列3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793599340623536681426.jpg\" title=\"罗马之恋系列4.jpg\" alt=\"罗马之恋系列4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793599664056897094448.jpg\" title=\"罗马之恋系列5.jpg\" alt=\"罗马之恋系列5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793600256236815318844.jpg\" title=\"罗马之恋系列6.jpg\" alt=\"罗马之恋系列6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793601034351855241171.jpg\" title=\"罗马之恋系列8.jpg\" alt=\"罗马之恋系列8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793603028076331582572.jpg\" title=\"罗马之恋系列9.jpg\" alt=\"罗马之恋系列9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180329/6365793603309322736824251.jpg\" title=\"罗马之恋系列10.jpg\" alt=\"罗马之恋系列10.jpg\"/><\/p>","Goods_LookCount":5852,"Goods_MonthCount":0,"Goods_Sort":5,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"69404e3c-ccc4-442a-bfe8-d5b53dc4cda0","Goods_Name":"雅茜薇兰希腊神话系列","Goods_BrandName":"雅茜薇兰","Goods_Describe":"雅茜薇兰希腊神话无硅控油净发露、护发泥","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/97621a61-f1ea-47f4-8982-fbf97d20248b.jpg","Goods_Content":"<p><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878616624865753012377.jpg\" title=\"希腊神话系列1.jpg\" alt=\"希腊神话系列1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878616968615758194620.jpg\" title=\"希腊神话系列2.jpg\" alt=\"希腊神话系列2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878617562365759648261.jpg\" title=\"希腊神话系列3.jpg\" alt=\"希腊神话系列3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878618026428255831210.jpg\" title=\"希腊神话系列4.jpg\" alt=\"希腊神话系列4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878618467053254084618.jpg\" title=\"希腊神话系列5.jpg\" alt=\"希腊神话系列5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878618749865757853715.jpg\" title=\"希腊神话系列6.jpg\" alt=\"希腊神话系列6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878619059240752309014.jpg\" title=\"希腊神话系列7.jpg\" alt=\"希腊神话系列7.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878619385803258776872.jpg\" title=\"希腊神话系列8.jpg\" alt=\"希腊神话系列8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878619671740751004459.jpg\" title=\"希腊神话系列9.jpg\" alt=\"希腊神话系列9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878619912365759602212.jpg\" title=\"希腊神话系列10.jpg\" alt=\"希腊神话系列10.jpg\"/><\/p>","Goods_LookCount":19353,"Goods_MonthCount":0,"Goods_Sort":3,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"7cc0807a-e460-4021-8476-e7cecb55b417","Goods_Name":"舒优美氧立方卫生巾","Goods_BrandName":"舒优美","Goods_Describe":"舒优美氧立方卫生巾  一大包（3小包），一小包（7片）共21片","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/3cdc0d5f-2cfc-4b78-9cd7-311b381e8c3c.jpg","Goods_Content":"<p><br/><\/p><p><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878607959240759420139.jpg\" title=\"卫生巾1.jpg\" alt=\"卫生巾1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878608307678251588291.jpg\" title=\"卫生巾2.jpg\" alt=\"卫生巾2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878608743615753855792.jpg\" title=\"卫生巾3.jpg\" alt=\"卫生巾3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878608984240758155373.jpg\" title=\"卫生巾4.jpg\" alt=\"卫生巾4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878609268615751451887.jpg\" title=\"卫生巾5.jpg\" alt=\"卫生巾5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878609574865753150524.jpg\" title=\"卫生巾6.jpg\" alt=\"卫生巾6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878609846740757420387.jpg\" title=\"卫生巾7.jpg\" alt=\"卫生巾7.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878610126428259432821.jpg\" title=\"卫生巾8.jpg\" alt=\"卫生巾8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878610417053251944488.jpg\" title=\"卫生巾9.jpg\" alt=\"卫生巾9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878610665490758284812.jpg\" title=\"卫生巾10.jpg\" alt=\"卫生巾10.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878610924865759826197.jpg\" title=\"卫生巾11（透气性）.jpg\" alt=\"卫生巾11（透气性）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878611182678258138337.jpg\" title=\"卫生巾12（吸收对比）.jpg\" alt=\"卫生巾12（吸收对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878611451428251651538.jpg\" title=\"卫生巾13（锁水对比）.jpg\" alt=\"卫生巾13（锁水对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878611752990752662439.jpg\" title=\"卫生巾14（反渗对比）.jpg\" alt=\"卫生巾14（反渗对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878612010803259974579.jpg\" title=\"卫生巾15（荧光剂对比）.jpg\" alt=\"卫生巾15（荧光剂对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878612259240753016730.jpg\" title=\"卫生巾16（淡墨性对比）.jpg\" alt=\"卫生巾16（淡墨性对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878612513928258572208.jpg\" title=\"卫生巾17（摩擦对比）.jpg\" alt=\"卫生巾17（摩擦对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878612745178257198145.jpg\" title=\"卫生巾18（背胶粘着度对比）.jpg\" alt=\"卫生巾18（背胶粘着度对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878612990490752781807.jpg\" title=\"卫生巾19（面料对比）.jpg\" alt=\"卫生巾19（面料对比）.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878613349865758151019.jpg\" title=\"卫生巾20.jpg\" alt=\"卫生巾20.jpg\"/><\/p>","Goods_LookCount":17477,"Goods_MonthCount":0,"Goods_Sort":2,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"96b13741-8226-4389-b4cc-c9add2f8a628","Goods_Name":"雅茜薇兰 生物酶多效洗衣胶囊","Goods_BrandName":"雅茜薇兰","Goods_Describe":"雅茜薇兰 生物酶多效洗衣胶囊","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/930327db-a621-4154-9f2d-0b863fb7c5c7.jpg","Goods_Content":"<p><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878254516038451476451.jpg\" title=\"洗衣胶囊1.jpg\" alt=\"洗衣胶囊1.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878254830096939917658.jpg\" title=\"洗衣胶囊2.jpg\" alt=\"洗衣胶囊2.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878255137905491143712.jpg\" title=\"洗衣胶囊3.jpg\" alt=\"洗衣胶囊3.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878255455088932341581.jpg\" title=\"洗衣胶囊4.jpg\" alt=\"洗衣胶囊4.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878255989457099909492.jpg\" title=\"洗衣胶囊5.jpg\" alt=\"洗衣胶囊5.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878256476950858320152.jpg\" title=\"洗衣胶囊6.jpg\" alt=\"洗衣胶囊6.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878256900382937859175.jpg\" title=\"洗衣胶囊7.jpg\" alt=\"洗衣胶囊7.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878257503500215582804.jpg\" title=\"洗衣胶囊8.jpg\" alt=\"洗衣胶囊8.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878257951931976280611.jpg\" title=\"洗衣胶囊9.jpg\" alt=\"洗衣胶囊9.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878260562836056303364.jpg\" title=\"洗衣胶囊10.jpg\" alt=\"洗衣胶囊10.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878260936268773928473.jpg\" title=\"洗衣胶囊11.jpg\" alt=\"洗衣胶囊11.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878261209702772427582.jpg\" title=\"洗衣胶囊12.jpg\" alt=\"洗衣胶囊12.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878261559698296824979.jpg\" title=\"洗衣胶囊13.jpg\" alt=\"洗衣胶囊13.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878261823757418650444.jpg\" title=\"洗衣胶囊14.jpg\" alt=\"洗衣胶囊14.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878262087816536177737.jpg\" title=\"洗衣胶囊15.jpg\" alt=\"洗衣胶囊15.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878262361250538975018.jpg\" title=\"洗衣胶囊16.jpg\" alt=\"洗衣胶囊16.jpg\"/><img src=\"http://www.eehsxui.cn/Resource/image/20180408/6365878262611247339544587.jpg\" title=\"洗衣胶囊17.jpg\" alt=\"洗衣胶囊17.jpg\"/><\/p>","Goods_LookCount":16167,"Goods_MonthCount":0,"Goods_Sort":2,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"},{"Goods_ID":"e4d17997-f47f-43e0-b0a9-17825957bf8f","Goods_Name":"鑫玺雅茜薇兰美甲","Goods_BrandName":"鑫玺雅茜薇兰","Goods_Describe":"雅茜薇兰穿戴美甲","Goods_ImaPath":"http://www.eehsxui.cn/Resource/PhotoFile/dbe1a6ca-f7c0-4c65-8a2e-51e9a91d680a.jpg","Goods_Content":"<p><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881242772590514752915.jpg\" title=\"未标题-2_01.jpg\" alt=\"未标题-2_01.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243096028019464110.jpg\" title=\"未标题-2_02.jpg\" alt=\"未标题-2_02.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243725715516873941.jpg\" title=\"未标题-2_03.jpg\" alt=\"未标题-2_03.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881243958528018729124.jpg\" title=\"未标题-2_04.jpg\" alt=\"未标题-2_04.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244175715516099166.jpg\" title=\"未标题-2_05.jpg\" alt=\"未标题-2_05.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244425715516668735.jpg\" title=\"未标题-2_06.jpg\" alt=\"未标题-2_06.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244652278015010592.jpg\" title=\"未标题-2_07.jpg\" alt=\"未标题-2_07.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881244867903018151389.jpg\" title=\"未标题-2_08.jpg\" alt=\"未标题-2_08.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245099153016777327.jpg\" title=\"未标题-2_09.jpg\" alt=\"未标题-2_09.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245313215512390706.jpg\" title=\"未标题-2_10.jpg\" alt=\"未标题-2_10.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245555403015217704.jpg\" title=\"未标题-2_11.jpg\" alt=\"未标题-2_11.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881245794465511586213.jpg\" title=\"未标题-2_12.jpg\" alt=\"未标题-2_12.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246055403016356843.jpg\" title=\"未标题-2_13.jpg\" alt=\"未标题-2_13.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246335090518369277.jpg\" title=\"未标题-2_14.jpg\" alt=\"未标题-2_14.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246555403017495981.jpg\" title=\"未标题-2_15.jpg\" alt=\"未标题-2_15.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881246800715513079643.jpg\" title=\"未标题-2_16.jpg\" alt=\"未标题-2_16.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881247019465517977102.jpg\" title=\"未标题-2_17.jpg\" alt=\"未标题-2_17.jpg\"/><img src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20180408/6365881247231965519361236.jpg\" title=\"未标题-2_18.jpg\" alt=\"未标题-2_18.jpg\"/><\/p>","Goods_LookCount":26458,"Goods_MonthCount":0,"Goods_Sort":1,"Goods_IsOn":true,"Goods_IsBuy":true,"Goods_Type":"2e3369cf-5b44-4b96-9633-aa36a8137a34","Goods_LimitCount":1,"StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","Goods_Parameter":null,"Goods_ShopType":0,"TypeName":"服饰","StoreName":"爱美莲"}]
     * Banner : [{"Banner_ID":"b7d21515-fd44-4b98-a4a9-6067f7eaf7b4","Banner_Url":"http://192.168.0.157:8011/Resource/PhotoFile/238dbb19-7d00-4ae2-a76a-44a86a0c692d.jpg","Banner_LinkUrl":"null","AppBanner_LikUrl":null,"Category":"首页轮播图","Banner_Sort":3},{"Banner_ID":"bd78b41b-5caa-4321-8b85-77eb9ae164da","Banner_Url":"http://192.168.0.157:8011/Resource/PhotoFile/acc3a128-5cec-4b8b-b4ff-f748a8c9c09e.jpg","Banner_LinkUrl":"null","AppBanner_LikUrl":null,"Category":"首页轮播图","Banner_Sort":4}]
     * ServerTime : 2018-07-12 14:09:48
     */

    private String ServerTime;
    private List<GoodsRushBean> GoodsRush;
    private List<GoodsOpenedAwardBean> GoodsOpenedAward;
    private List<GoodsNewAwardBean> GoodsNewAward;
    private List<GoodsTjBean> GoodsTj;
    private List<BannerBean> Banner;

    public String getServerTime() {
        return ServerTime;
    }

    public void setServerTime(String ServerTime) {
        this.ServerTime = ServerTime;
    }

    public List<GoodsRushBean> getGoodsRush() {
        return GoodsRush;
    }

    public void setGoodsRush(List<GoodsRushBean> GoodsRush) {
        this.GoodsRush = GoodsRush;
    }

    public List<GoodsOpenedAwardBean> getGoodsOpenedAward() {
        return GoodsOpenedAward;
    }

    public void setGoodsOpenedAward(List<GoodsOpenedAwardBean> GoodsOpenedAward) {
        this.GoodsOpenedAward = GoodsOpenedAward;
    }

    public List<GoodsNewAwardBean> getGoodsNewAward() {
        return GoodsNewAward;
    }

    public void setGoodsNewAward(List<GoodsNewAwardBean> GoodsNewAward) {
        this.GoodsNewAward = GoodsNewAward;
    }

    public List<GoodsTjBean> getGoodsTj() {
        return GoodsTj;
    }

    public void setGoodsTj(List<GoodsTjBean> GoodsTj) {
        this.GoodsTj = GoodsTj;
    }

    public List<BannerBean> getBanner() {
        return Banner;
    }

    public void setBanner(List<BannerBean> Banner) {
        this.Banner = Banner;
    }

    public static class GoodsRushBean {
        /**
         * RushId : f79b404f-4e9f-49a2-932c-106395d4ffa5
         * Goods_MonthCount : 0
         * GoodsPrice_Stock : 911
         * Goods_ID : f2cfb2f8-b6ec-41fc-bf6b-59c522e80fa7
         * Goods_ShopType : 1
         * GoodsPrice_ID : 45bc81fb-7ca8-4e2e-848c-d4e0b673392e
         * Goods_Name : IPhone 兵222
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg
         * Goods_Content : <p>464684</p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : IPhone 7 亮黑色
         * GoodsPrice_AttrName : 32G
         * GoodsPrice_VirtualPrice : 4000
         * RushStartTime : 2018-07-11 22:00:00
         * RushEndTime : 2018-07-12 00:00:00
         * RushNumber : 0
         * Bond : 100
         * Price : 2000
         * GoodsPrice_Price : 6000
         * IsEnd : 0
         */

        private String RushId;
        private int Goods_MonthCount;
        private int GoodsPrice_Stock;
        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private String GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_VirtualPrice;
        private String RushStartTime;
        private String RushEndTime;
        private int RushNumber;
        private int Bond;
        private int Price;
        private double GoodsPrice_Price;
        private int IsEnd;

        public String getRushId() {
            return RushId;
        }

        public void setRushId(String RushId) {
            this.RushId = RushId;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(String Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public String getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(String GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public String getRushStartTime() {
            return RushStartTime;
        }

        public void setRushStartTime(String RushStartTime) {
            this.RushStartTime = RushStartTime;
        }

        public String getRushEndTime() {
            return RushEndTime;
        }

        public void setRushEndTime(String RushEndTime) {
            this.RushEndTime = RushEndTime;
        }

        public int getRushNumber() {
            return RushNumber;
        }

        public void setRushNumber(int RushNumber) {
            this.RushNumber = RushNumber;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public double getGoodsPrice_Price() {
            return GoodsPrice_Price;
        }

        public void setGoodsPrice_Price(double GoodsPrice_Price) {
            this.GoodsPrice_Price = GoodsPrice_Price;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }
    }

    public static class GoodsOpenedAwardBean {
        /**
         * Goods_ID : fd1e07eb-1940-4388-941e-4d7a6b5c9759
         * Goods_ShopType : 2
         * GoodsPrice_ID : 863dd59f-154c-49b4-bd5a-d9a1259e8470
         * AwardId : 7750a589-426e-4205-ad87-acafd98375b3
         * Goods_Name : 雅茜薇兰罗马之恋系列
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg
         * Goods_Content : <p><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635201428251760617.jpg" title="罗马之恋系列1.jpg" alt="罗马之恋系列1.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635429553257629892.jpg" title="罗马之恋系列2.jpg" alt="罗马之恋系列2.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635668615753998401.jpg" title="罗马之恋系列3.jpg" alt="罗马之恋系列3.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635984240756668853.jpg" title="罗马之恋系列4.jpg" alt="罗马之恋系列4.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878636213928256767373.jpg" title="罗马之恋系列5.jpg" alt="罗马之恋系列5.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878636460803259878452.jpg" title="罗马之恋系列6.jpg" alt="罗马之恋系列6.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878636807678253519186.jpg" title="罗马之恋系列7.jpg" alt="罗马之恋系列7.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878637046740754589522.jpg" title="罗马之恋系列8.jpg" alt="罗马之恋系列8.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878637284240752430613.jpg" title="罗马之恋系列9.jpg" alt="罗马之恋系列9.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878637526428255257612.jpg" title="罗马之恋系列10.jpg" alt="罗马之恋系列10.jpg"/></p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : null
         * GoodsPrice_AttrName : 1套
         * GoodsPrice_VirtualPrice : 88
         * GoodsPrice_Stock : 9945
         * AwardPeopleCount : 100
         * NeedCount : 100
         * Bond : 8
         * Price : 300
         * IsEnd : 1
         * AwardTime : 2018-07-11 00:00:00
         */

        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String AwardId;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private Object GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_VirtualPrice;
        private int GoodsPrice_Stock;
        private int AwardPeopleCount;
        private int NeedCount;
        private int Bond;
        private int Price;
        private int IsEnd;
        private String AwardTime;

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getAwardId() {
            return AwardId;
        }

        public void setAwardId(String AwardId) {
            this.AwardId = AwardId;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(String Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public Object getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(Object GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public int getAwardPeopleCount() {
            return AwardPeopleCount;
        }

        public void setAwardPeopleCount(int AwardPeopleCount) {
            this.AwardPeopleCount = AwardPeopleCount;
        }

        public int getNeedCount() {
            return NeedCount;
        }

        public void setNeedCount(int NeedCount) {
            this.NeedCount = NeedCount;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }

        public String getAwardTime() {
            return AwardTime;
        }

        public void setAwardTime(String AwardTime) {
            this.AwardTime = AwardTime;
        }
    }

    public static class GoodsNewAwardBean {
        /**
         * Goods_ID : fd1e07eb-1940-4388-941e-4d7a6b5c9759
         * Goods_ShopType : 2
         * GoodsPrice_ID : 863dd59f-154c-49b4-bd5a-d9a1259e8470
         * AwardId : 7750a589-426e-4205-ad87-acafd98375b3
         * Goods_Name : 雅茜薇兰罗马之恋系列
         * Goods_ImaPath : http://www.eehsxui.cn/Resource/PhotoFile/c6d130e9-285a-4f7a-bef2-c044d91ce061.jpg
         * Goods_Content : <p><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635201428251760617.jpg" title="罗马之恋系列1.jpg" alt="罗马之恋系列1.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635429553257629892.jpg" title="罗马之恋系列2.jpg" alt="罗马之恋系列2.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635668615753998401.jpg" title="罗马之恋系列3.jpg" alt="罗马之恋系列3.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878635984240756668853.jpg" title="罗马之恋系列4.jpg" alt="罗马之恋系列4.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878636213928256767373.jpg" title="罗马之恋系列5.jpg" alt="罗马之恋系列5.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878636460803259878452.jpg" title="罗马之恋系列6.jpg" alt="罗马之恋系列6.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878636807678253519186.jpg" title="罗马之恋系列7.jpg" alt="罗马之恋系列7.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878637046740754589522.jpg" title="罗马之恋系列8.jpg" alt="罗马之恋系列8.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878637284240752430613.jpg" title="罗马之恋系列9.jpg" alt="罗马之恋系列9.jpg"/><img src="http://www.eehsxui.cn/Resource/image/20180408/6365878637526428255257612.jpg" title="罗马之恋系列10.jpg" alt="罗马之恋系列10.jpg"/></p>
         * Goods_Parameter : null
         * GoodsPrice_SpecName : null
         * GoodsPrice_AttrName : 1套
         * GoodsPrice_VirtualPrice : 88
         * GoodsPrice_Stock : 9945
         * AwardPeopleCount : 100
         * NeedCount : 100
         * Bond : 8
         * Price : 300
         * IsEnd : 1
         * AwardTime : 2018-07-11 00:00:00
         */

        private String Goods_ID;
        private int Goods_ShopType;
        private String GoodsPrice_ID;
        private String AwardId;
        private String Goods_Name;
        private String Goods_ImaPath;
        private String Goods_Content;
        private Object Goods_Parameter;
        private Object GoodsPrice_SpecName;
        private String GoodsPrice_AttrName;
        private double GoodsPrice_VirtualPrice;
        private int GoodsPrice_Stock;
        private int AwardPeopleCount;
        private int NeedCount;
        private int Bond;
        private int Price;
        private int IsEnd;
        private String AwardTime;

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public String getGoodsPrice_ID() {
            return GoodsPrice_ID;
        }

        public void setGoodsPrice_ID(String GoodsPrice_ID) {
            this.GoodsPrice_ID = GoodsPrice_ID;
        }

        public String getAwardId() {
            return AwardId;
        }

        public void setAwardId(String AwardId) {
            this.AwardId = AwardId;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public String getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(String Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public Object getGoodsPrice_SpecName() {
            return GoodsPrice_SpecName;
        }

        public void setGoodsPrice_SpecName(Object GoodsPrice_SpecName) {
            this.GoodsPrice_SpecName = GoodsPrice_SpecName;
        }

        public String getGoodsPrice_AttrName() {
            return GoodsPrice_AttrName;
        }

        public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
            this.GoodsPrice_AttrName = GoodsPrice_AttrName;
        }

        public double getGoodsPrice_VirtualPrice() {
            return GoodsPrice_VirtualPrice;
        }

        public void setGoodsPrice_VirtualPrice(double GoodsPrice_VirtualPrice) {
            this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
        }

        public int getGoodsPrice_Stock() {
            return GoodsPrice_Stock;
        }

        public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
            this.GoodsPrice_Stock = GoodsPrice_Stock;
        }

        public int getAwardPeopleCount() {
            return AwardPeopleCount;
        }

        public void setAwardPeopleCount(int AwardPeopleCount) {
            this.AwardPeopleCount = AwardPeopleCount;
        }

        public int getNeedCount() {
            return NeedCount;
        }

        public void setNeedCount(int NeedCount) {
            this.NeedCount = NeedCount;
        }

        public int getBond() {
            return Bond;
        }

        public void setBond(int Bond) {
            this.Bond = Bond;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getIsEnd() {
            return IsEnd;
        }

        public void setIsEnd(int IsEnd) {
            this.IsEnd = IsEnd;
        }

        public String getAwardTime() {
            return AwardTime;
        }

        public void setAwardTime(String AwardTime) {
            this.AwardTime = AwardTime;
        }
    }

    public static class GoodsTjBean {

        /**
         * Goods_ID : 40ce8944-6441-405d-bb98-c8cc835a8bac
         * Goods_Name : IPhone
         * Goods_BrandName : Apple
         * Goods_Describe : 苹果手机
         * Goods_ImaPath : http://192.168.1.157:8011/Resource/PhotoFile/fcd07f96-22a0-4311-81b4-bfb64a053490.png
         * Goods_Content : null
         * Goods_LookCount : 0
         * Goods_MonthCount : 19
         * Goods_Sort : 1
         * Goods_IsOn : true
         * Goods_IsBuy : true
         * Goods_Type : 94dfa9cc-3d03-4524-af07-8e401a24875d
         * Goods_LimitCount : 1
         * StoreId : f9641e98-a561-46f9-8cb9-aa9c43daabb0
         * Goods_Parameter : null
         * Goods_ShopType : 0
         * TypeName : 手机数码
         * StoreName : 测试不要删除谢谢
         * StoreStatus : 1
         * Goods_PriceMin : 4500
         * Goods_PriceMax : 8000
         * Address : 湖北省武汉市洪山区珞喻路237号
         * Latitude : 30.549420
         * Longitude : 114.265550
         */

        private String Goods_ID;
        private String Goods_Name;
        private String Goods_BrandName;
        private String Goods_Describe;
        private String Goods_ImaPath;
        private Object Goods_Content;
        private int Goods_LookCount;
        private int Goods_MonthCount;
        private int Goods_Sort;
        private boolean Goods_IsOn;
        private boolean Goods_IsBuy;
        private String Goods_Type;
        private int Goods_LimitCount;
        private String StoreId;
        private Object Goods_Parameter;
        private int Goods_ShopType;
        private String TypeName;
        private String StoreName;
        private int StoreStatus;
        private double Goods_PriceMin;
        private double Goods_PriceMax;
        private String Address;
        private String Latitude;
        private String Longitude;

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoods_Name() {
            return Goods_Name;
        }

        public void setGoods_Name(String Goods_Name) {
            this.Goods_Name = Goods_Name;
        }

        public String getGoods_BrandName() {
            return Goods_BrandName;
        }

        public void setGoods_BrandName(String Goods_BrandName) {
            this.Goods_BrandName = Goods_BrandName;
        }

        public String getGoods_Describe() {
            return Goods_Describe;
        }

        public void setGoods_Describe(String Goods_Describe) {
            this.Goods_Describe = Goods_Describe;
        }

        public String getGoods_ImaPath() {
            return Goods_ImaPath;
        }

        public void setGoods_ImaPath(String Goods_ImaPath) {
            this.Goods_ImaPath = Goods_ImaPath;
        }

        public Object getGoods_Content() {
            return Goods_Content;
        }

        public void setGoods_Content(Object Goods_Content) {
            this.Goods_Content = Goods_Content;
        }

        public int getGoods_LookCount() {
            return Goods_LookCount;
        }

        public void setGoods_LookCount(int Goods_LookCount) {
            this.Goods_LookCount = Goods_LookCount;
        }

        public int getGoods_MonthCount() {
            return Goods_MonthCount;
        }

        public void setGoods_MonthCount(int Goods_MonthCount) {
            this.Goods_MonthCount = Goods_MonthCount;
        }

        public int getGoods_Sort() {
            return Goods_Sort;
        }

        public void setGoods_Sort(int Goods_Sort) {
            this.Goods_Sort = Goods_Sort;
        }

        public boolean isGoods_IsOn() {
            return Goods_IsOn;
        }

        public void setGoods_IsOn(boolean Goods_IsOn) {
            this.Goods_IsOn = Goods_IsOn;
        }

        public boolean isGoods_IsBuy() {
            return Goods_IsBuy;
        }

        public void setGoods_IsBuy(boolean Goods_IsBuy) {
            this.Goods_IsBuy = Goods_IsBuy;
        }

        public String getGoods_Type() {
            return Goods_Type;
        }

        public void setGoods_Type(String Goods_Type) {
            this.Goods_Type = Goods_Type;
        }

        public int getGoods_LimitCount() {
            return Goods_LimitCount;
        }

        public void setGoods_LimitCount(int Goods_LimitCount) {
            this.Goods_LimitCount = Goods_LimitCount;
        }

        public String getStoreId() {
            return StoreId;
        }

        public void setStoreId(String StoreId) {
            this.StoreId = StoreId;
        }

        public Object getGoods_Parameter() {
            return Goods_Parameter;
        }

        public void setGoods_Parameter(Object Goods_Parameter) {
            this.Goods_Parameter = Goods_Parameter;
        }

        public int getGoods_ShopType() {
            return Goods_ShopType;
        }

        public void setGoods_ShopType(int Goods_ShopType) {
            this.Goods_ShopType = Goods_ShopType;
        }

        public String getTypeName() {
            return TypeName;
        }

        public void setTypeName(String TypeName) {
            this.TypeName = TypeName;
        }

        public String getStoreName() {
            return StoreName;
        }

        public void setStoreName(String StoreName) {
            this.StoreName = StoreName;
        }

        public int getStoreStatus() {
            return StoreStatus;
        }

        public void setStoreStatus(int StoreStatus) {
            this.StoreStatus = StoreStatus;
        }

        public double getGoods_PriceMin() {
            return Goods_PriceMin;
        }

        public void setGoods_PriceMin(double Goods_PriceMin) {
            this.Goods_PriceMin = Goods_PriceMin;
        }

        public double getGoods_PriceMax() {
            return Goods_PriceMax;
        }

        public void setGoods_PriceMax(double Goods_PriceMax) {
            this.Goods_PriceMax = Goods_PriceMax;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String Latitude) {
            this.Latitude = Latitude;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }
    }

    public static class BannerBean {
        /**
         * Banner_ID : b7d21515-fd44-4b98-a4a9-6067f7eaf7b4
         * Banner_Url : http://192.168.0.157:8011/Resource/PhotoFile/238dbb19-7d00-4ae2-a76a-44a86a0c692d.jpg
         * Banner_LinkUrl : null
         * AppBanner_LikUrl : null
         * Category : 首页轮播图
         * Banner_Sort : 3
         */

        private String Banner_ID;
        private String Banner_Url;
        private String Banner_LinkUrl;
        private Object AppBanner_LikUrl;
        private String Category;
        private int Banner_Sort;

        public String getBanner_ID() {
            return Banner_ID;
        }

        public void setBanner_ID(String Banner_ID) {
            this.Banner_ID = Banner_ID;
        }

        public String getBanner_Url() {
            return Banner_Url;
        }

        public void setBanner_Url(String Banner_Url) {
            this.Banner_Url = Banner_Url;
        }

        public String getBanner_LinkUrl() {
            return Banner_LinkUrl;
        }

        public void setBanner_LinkUrl(String Banner_LinkUrl) {
            this.Banner_LinkUrl = Banner_LinkUrl;
        }

        public Object getAppBanner_LikUrl() {
            return AppBanner_LikUrl;
        }

        public void setAppBanner_LikUrl(Object AppBanner_LikUrl) {
            this.AppBanner_LikUrl = AppBanner_LikUrl;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public int getBanner_Sort() {
            return Banner_Sort;
        }

        public void setBanner_Sort(int Banner_Sort) {
            this.Banner_Sort = Banner_Sort;
        }
    }
}
