## v7.0.0-alpha.22 [2020-11-22]

### Bug修复

修复表单项值校验错误信息提示问题 [7dcad593](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/7dcad593036a9c6ea0612bdbf2e99fc1bee20062)

修复表单新建和更新默认值问题 [426f7930](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/426f793037ca228e3ae2b6449df9c10359d4844a)

修复表格新建更新默认值问题 [73a7f288](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/73a7f288493f8606a3bcf3a697c68c86171d12f2)、[daac8796](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/daac8796532556617979fbfa91dc78033cc31215)

修复搜索表单新建默认值问题 [940c4e6b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/940c4e6b854f7f32de41656535c329da683ca631)

修复图表加载逻辑问题 [b35ee838](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/b35ee83875787b3edb1df20c92c932b55972e092)

修复应用菜单计算权限异常问题 [c3335e88](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/c3335e8858ec1137ca65d35114f3a060ae56e2ba)

修复表单数据对象报错问题 [5722dbb4](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/5722dbb48122dbc60c8904b634995c906d10a456)

修复主信息属性映射表单项名称报错问题 [1a948e6d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/1a948e6d52cf133dae90990cd3c2b0262559fd60)、[b2f366a0](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/b2f366a05fbf2b1ed00d199ad0856a0ac7099809)、[81f9ddee](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/81f9ddee9a859451ed860d155e2ea7d265ee3457)

修复表格分页加载未重置当前页为第一页问题 [8cc91599](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/8cc91599c6ef83e3a1e387d2d8f8857443452af9)

修复图表无数据刷新问题 [485463d8](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/485463d8a13522d87a240eea01faa35da3ae3e1b)

修复多数据选择视图未引入选择视图面板问题 [ed3130dd](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/ed3130dd859417e3659be3ba8af914e3d8622612)

修复视图viewparams为字符串时处理逻辑异常问题 [55d26f5f](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/55d26f5f6729e3bb3ef5211d0459a8503ac3250f)

修复看板视图整合参数问题 [9e4828f1](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/9e4828f1d3be520dfe2c53d4938f13bf569a0d06)

修复表格排序属性异常问题 [5e746632](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/5e7466326a19a411662e10f959d946152eee511c)

修复实体处理逻辑异常问题 [29e2e495](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/29e2e4959afc5a1fcf36e374dd357212fe86f382)

### 功能新增及优化

#### 模板

新增图表视图添加快速分组代码表和快速搜索栏 [b3305963](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/b33059638134e4245aab6c6498a721c87aa8ad61)、[99711fd0](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/99711fd0d50384e03645ff0948d551d5a9b63691)

新增标签(地址栏插件)  [22271ea9](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/22271ea9e5d636dbbc3850511cdce36089bc7dfa)、[a348ff6b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/a348ff6b11b4348cf191a59b422e85e8f67d304e)

新增复合表单项值规则 [0b838bdf](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/0b838bdf805fd48e2c898fc63a296cd4b01151dc)、[a88f78dd](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/a88f78dda0ff2c3bacf58c4bb04cb1ede539792a)

新增表单按钮无图标使用界面行为图标逻辑 [a214c5b8](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/a214c5b88bf0bb1d669b468991180ddfc4b7e4f8)、[90cbf4b8](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/90cbf4b8c3474922e6b065ba70e3138191491947)

新增列表部件操作列界面行为支持 [4a2664b1](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/4a2664b1525f8850cc5c39a541c7bc907a6d81b8)、[0586ad9d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/0586ad9d1534caa06eaecb3484c73f7dc9f0fdfa)、[63dc0dab](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/63dc0dabb1adcf0a56ebe9d97f9bb1ece562fad6)、[6ee19a63](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/6ee19a63f87346f7edd0fc1c7d95ce4b212357f7)

新增数据视图部件操作列界面行为支持 [ef18acdf](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/ef18acdf5b10264fd40fa43a3375aeec2830c71b)、[218333d5](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/218333d54e596ed97b62027bd35340b96e35b5f5)

新增关系界面表格保存提示内容显示 [50b9a9f7](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/50b9a9f7925359aa84e23ffa27bf0d7a9a527cbd)

新增列表批操作工具栏和快速工具栏支持 [ddb1d067](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/ddb1d067b299cab6eab9c049940da5623bd42298)、[d56c3d79](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/d56c3d79747baac4e6d0aa1501873a4680dd1291)

新增数据视图批操作工具栏和快速工具栏支持 [aba0f9e0](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/aba0f9e00e50f18b804297bb3a440812d8a32f23)、[9f8fdce8](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/9f8fdce8e73e02b223524812ced0300282429072)、[ef753f43](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/ef753f43754c5ff29b0ee2f1f9986b5bbd44cac1)、[dac712a2](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/dac712a2a2c84653deaab1cdfb0680d2b555a43f)、[6e2bccea](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/6e2bccea860951bb1ea85b2a1be8280189eaca31)、[974aadd1](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/974aadd1fe47768d33a7e508d81323be9c6cd7fd)

新增工作流动态操作视图支持 [065a8dce](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/065a8dce5550b051245793e58af5bc5484464e07)、[6f9a0ee3](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/6f9a0ee3536f4e5cb6d32bcdc79a4c9aec1afd9e)、[5fd6366d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/5fd6366d50dde1fe2e8168e23bfb6d6964792ca0)、[a40bf66b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/a40bf66b9066197c9a2757e66a45f00e3e3eacb5)、[0cdd5713](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/0cdd571311b0f4d379977d836d6ca7c1f287c55c)、[21264471](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/21264471b30b713bdc873ca87d66ae5979b39ef8)、[bc85a97b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/bc85a97bdeb18bdc70c0f71ccc9f29e1448b5399)、[fcea460c](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/fcea460ce3c320c0c02556cf4cb997d5b36a64f2)、[729bc0a6](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/729bc0a680203e81dc3e6118ebfe72bc40784c63)、[b1a569ac](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/b1a569acf82aa3e777cfa6d596615c6048c2f980)、[81857c4a](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/81857c4ac443137a49649023dfc1ac9f7136c10e)

新增表格（透视表）插件 [4f57e1ba](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/4f57e1baad8881fb3a069fb293044b16daa08e44)

新增看板视图支持看板展开与收缩 [104bde80](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/104bde80f844cf4f985e76d234095c9857d4ea59)

新增数据服务查询数据集(post方式)方法 [c2fe9f3b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/c2fe9f3bf8bedd12255650b3969817123b6701de)

新增代码表服务图标属性 [20c54b64](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/20c54b6409d5e3343a74c84ef7241f868d7ddae9)

新增实体地图视图及地图部件 [9943b1c0](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/9943b1c01f1146b95dd45464a2896b03c85783e8)

新增实体地图视图（部件视图） [f3887778](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/f3887778d471cbec33eddf56756e2d4d07a1818f)

新增地图定位组件 [84297814](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/842978148e116dfef3b044cfcce934f5468d16d5)、[fd2ae711](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/fd2ae71184646ad13a5d5a2ac50701bbdc7cd0f5)、[9742d2a0](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/9742d2a0f2210fd4a5e73e2254985cfc21065761)

优化前台调用界面行为关闭编辑或弹出视图逻辑 [8d191a79](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/8d191a790a52ed46985e1f8faf8de8266cfa08d8)

优化表单保存提示信息 [93cdc68b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/93cdc68bc84486c2a4df70ab144eeadae78ab1a3)

优化表格值规则校验 [e3bf8fd1](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/e3bf8fd10f52ff1d3d1746cc675780a9e1d8f0ce)、[a6544f41](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/a6544f41e7e547d9b18893d2b990e0e7ea04458e)、[92f12d80](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/92f12d801cc4e540c7b1034782faed5b6459132c)

优化表单值规则校验 [e100c8eb](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/e100c8eb79eb3d0d9646d93b929698d159a43200)、[5ed59675](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/5ed59675e2a8c515054804d9e40a4de83ff30bf7)、[19d639ee](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/19d639ee7e18e04d678898f8e499b61b18812cb7)

优化表格、表单属性值规则校验异常捕获逻辑 [8f78ffad](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/8f78ffadaa42c2ca1ecb3fac94022df7b6f795a8)、[2cbedd77](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/2cbedd7759be86933b3136ec2d43df4f0b959a2d)、[5f719edd](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/5f719edd3bfce6abff63ba229fc79abaaa5714d7)、[53b99003](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/53b99003e1bfa941d0175ed263825490eacb5b80)

优化直接内容项html类型 [c9712800](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/c9712800819554064b8aace92306e74a4cd41c30)

优化表单、表格提示信息内容 [cfefe47d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/cfefe47df2321cbdc5c9149d709e3de6ae3af153)、[6a908895](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/6a908895a4cad9af3b6d2baa8f0b342c06a45ea5)、[ff815b76](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/ff815b766207692483420b3fb3fdc48e1af1a716)

优化表格删除提示信息内容 [3dc02183](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/3dc021833cac72e7e37c963c0f46ed7fa9d3b97c)

优化编辑器占位提示 [60e296d9](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/60e296d94d1c331ff1f6d4c920ea7b929de36e2a)、[3128fdbf](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/3128fdbf55e7dfbb5f6b9438137ef87d549743e8)

优化列表部件数据分组逻辑 [c8a74e10](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/c8a74e10c6f3fa4b15dba8141c4f52509b1ee5eb)、[55a3fb4b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/55a3fb4b649c50a645670ab8dda7d8aad7fea802)

优化表格部件数据分组逻辑 [75624d3e](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/75624d3e042a7a15d55568ae92c1578948ad1b13)、[7873329d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/7873329de8c3f0805d1b72945b43b14220f61bc7)、[982a2c2b](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/982a2c2b48fe71c326b68d7020c22a4daebb4a89)、[276f90d3](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/276f90d3b2bd6cc18899cadec9d11fc2e8236433)、[d6377294](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/d63772945d4db25f2a743d355e1b648992cf0048)、[d326d83a](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/d326d83a2030aa17a04aa2e482b44acf4973e5ad)、[b8ad5bfd](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/b8ad5bfde4fdfc13765a2e25d48a7583b0dcad1a)、[641a67f4](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/641a67f4183997c45dfe3b4775cd1b75b315b195)、[8db35ec3](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/8db35ec34c00a47d67f7f864461e8b005988e597)、[faecb1cc](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/faecb1cc20142420a79a57f9cef5b71053a1d98d)

优化实体工作流动态导航表格视图逻辑 [909f0cd4](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/909f0cd48133b974f2a8d634a252f0dd7248ea5c)、[1e9a4fe9](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/1e9a4fe92e64a86aea9b730da8f9b7a72ee0ee11)、[899e6882](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/899e68821c06e2d584c5b03304ca11d6d6edbc6b)、[64d99a8c](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/64d99a8ceb2c942dbf9c1e6089718d2c53bffc86)、[729bc0a6](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/729bc0a680203e81dc3e6118ebfe72bc40784c63)、[e57c1f14](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/e57c1f141e256f4813c347197461bccaad9c1194)、[bd46e456](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/bd46e4565331e8bb4757514d80b17615186db1d5)、[f3e4468a](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/f3e4468af140170e4dd7c5f5882ff0bcc9621b81)

优化实体工作流动态编辑视图逻辑 [909f0cd4](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/909f0cd48133b974f2a8d634a252f0dd7248ea5c)、[1e9a4fe9](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/1e9a4fe92e64a86aea9b730da8f9b7a72ee0ee11)、[899e6882](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/899e68821c06e2d584c5b03304ca11d6d6edbc6b)、[e89a302d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/e89a302d477433808d61b4cf7ec4f62455a8aeb7)、[91feb5aa](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/91feb5aabcef545b20bc3de935dcb0cd2f92f1f7)、[9c892670](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/9c8926700f7c6526bafd9a84ea00c861f731f521)、[ff0c64f1](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/ff0c64f19a075d13f2258c80fcc19dec77c4ac7f)、[729bc0a6](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/729bc0a680203e81dc3e6118ebfe72bc40784c63)、[bd46e456](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/bd46e4565331e8bb4757514d80b17615186db1d5)、[f3e4468a](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/f3e4468af140170e4dd7c5f5882ff0bcc9621b81)

优化面板标签代码表发布值分隔符 [6a0029df](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/6a0029dfcd0d5970114d0040d1712775105ec4f3)

优化数据图表部件增加高度发布逻辑 [aca0084a](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/aca0084a00011cec55096984293425de4fdef57e)

优化数据看板部件逻辑 [160dedcd](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/160dedcdd4c66e25bc83abebf3e471beebefa857)、[d005eeba](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/d005eeba57c974063a1df0cca914d2c7b012d470)、[d10cf154](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/d10cf154f0887dcd011cdd99f711bdcc98e64205)

优化评分器编辑器支持代码表逻辑 [e2f0d18f](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/e2f0d18f5820a7acbf198635de190843da91467a)

优化看板视图部件嵌入面板数据处理 [b07ba68c](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7/commit/b07ba68c5d1f1823fce2e52d985cbcc3a7fb85c4)

#### 基础文件

修复图表视图、图表部件视图获取快速分组和搜索栏参数及样式 [cc9ec9d8](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/cc9ec9d88483c7f14ccd519897778635b9385b14)

修复工具栏按钮异常问题 [f66edc45](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/f66edc45e909ec0d1fbb47861c8ea336819ce0aa)

修复修复下拉列表框不加载数据异常 [503581d7](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/503581d771cbb628a5cfb170bb10e68808cbaf5b)

修复关系界面内嵌视图出现不加载的情况 [c1d6db61](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/c1d6db6130ff6a5768f9d982e75949cde86307f0)

新增部件服务增加根据后台标识获取前台数据标识名称能力 [a07d7088](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/a07d70887e5044f415a29d92f136ef910231a2dd)

新增图标绘制组件 [3a160350](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/3a1603502740cde5ee12051bd2ee3c76abe2b554)、[9653dd15](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/9653dd15cdef7b97ce0c022d78c6236d3bf9d8fe)

新增响应头错误状态汇总 [3cb2a17f](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/3cb2a17f78d262efab0914a3d025de29e36d5641)

新增透视表表格插件 [dbebc115](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/dbebc115cfa9d90cca2518db27646c935fc5c11c)

新增代码表获取代码表项能力 [06c53dca](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/06c53dca2963165c8593cf2b7f2ba6f9e0f13f0c)、[f856c55f](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/f856c55f6983bfab490848dfefed0a8ca29bac9b)

新增实体地图视图引擎 [5ccb40ba](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/5ccb40ba780548f7758e0cf4027fb8a16affc56d)

新增实体地图视图（部件视图）引擎 [da07aede](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/da07aede9151f474740da1cabcaa10e8bc1b3749)

新增地图定位组件 [b76bf4ba](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/b76bf4ba09630d477e1a75637a76b39974b8ff2f)、[19c862e7](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/19c862e71eabdf4e10a56118ea32c3f23793e68b)、[1683f20e](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/1683f20e070d0f2a1c738929ca4eb018d61eaea0)

优化数据选择下拉时清空旧数据 [a42584a4](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/a42584a4235a0beb0d155b47890e5e685d9eb5ac)

优化视图消息样式 [22406733](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/22406733fecb566929770e688e5d06fa7b6ed5d1)

优化代码表组件增加图片识别 [853d4ad4](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/853d4ad406a35cfb013dbc18188aeb45d148b8b6)、[bc879205](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/bc879205eb35dba743974a9af189de0292dd4979)

优化工作流动态编辑视图加载逻辑 [19760cf6](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/19760cf6f32f9bb47aa75ffe13ca5db8639cc250)

优化引用avue.min.js的文件路径 [e4a9d11d](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/e4a9d11db906cc8e18a0f290cb66fd2c3fc277a1)

优化评分器编辑器支持代码表逻辑 [28721171](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/28721171ffa8d5adae6d9b567838041e320c5767)、[453c1e6c](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/453c1e6c79b31a49d189c40a4537a60fa0dd0023)

优化表单项label长度过长显示异常和支持label显示html [fc754a29](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/fc754a294d553d70d4e634df940069012a16a7e1)、[ed804eb6](http://demo.ibizlab.cn/ibizr7pfstdtempl/ibizvuer7res/commit/ed804eb6b5bccab109b92edd5419310363bc0b68)

## v7.0.0-alpha.21 [2020-10-31]

### Bug修复

修复视图类型门户部件通知嵌入视图刷新问题

修复表格行编辑传值无效和设置表格行编辑禁用无效问题

修复表格列触发行为权限控制无效问题

修复表格导出代码表转化问题

修复行编辑时合并行主键到上下文中

修复多表单编辑视图(部件视图)临时模式异常问题

修复修复表单值规则异常问题

### 功能新增及优化

#### 模板

新增导航类部件快速搜索栏提示

新增分页导航面板主状态逻辑

新增图片预览（可旋转）控件

新增多数据部件无值显示内容适配

新增分页导航视图工具栏权限状态逻辑

新增适配界面行为中显示处理

新增支持是否支持实体主状态属性

优化列表加载、刷新逻辑

优化直接内容项组件

优化甘特图部件和树表格部件加载逻辑

优化后台界面行为异常处理逻辑

优化分页导航面板切换分页刷新逻辑

优化树导航视图树节点刷新逻辑

优化表单更新项传入调用方法名称

优化行编辑值校验错误信息提示

#### 基础文件

新增图片预览（可旋转）控件

新增计算分页导航视图工具栏权限状态逻辑

新增支持是否支持实体主状态逻辑

新增切换组织部门功能

优化数据选择下拉控件（下拉列表宽度和编辑器宽度保持一致）

优化直接内容项组件

修复数据选择无值抛出null

修复登录完成user存储到localStorage

修复表格值为0不显示问题

## v7.0.0-alpha.20 [2020-10-18]

### Bug修复

修复获取数据对象的主状态值统一转字符串处理逻辑

修复表单空输入异常问题

修复下拉数据数据加载异常问题

修复表单分页图标重复发布异常

修复数据选择增加外键值附加数据回填逻辑

修复表格行编辑可设置数据主键和清空仿真主键问题 

修复代码表返回数据不合法抛出的异常

修复表单值规则部分逻辑

修复导航类视图修改右侧表单数据时，只能跳转第一条数据BUG

### 功能新增及优化

#### 模板

新增动态表单支持

新增视图消息支持

新增表单、面板、工具栏、数据看板直接内容项支持

新增日历项支持标识属性和文本属性

新增应用组件包支持

新增导航工具栏权限控制支持

新增图表绘制最终参数

新增门户部件界面行为组权限校验

新增表单、表格数据对象方式新建、更新默认值

新增导航视图搜索框提示可搜索字段名称

新增部件逻辑插件支持

新增工具栏、工具栏项插件支持

优化调整代码表服务基类位置

#### 基础文件

新增动态表单组件、直接内容项组件、视图消息组组件和视图消息组件

优化导航类部件工具栏状态逻辑

修复表单空输入异常问题

修复下拉数据数据加载异常

修复关系页第一次进入不加载问题

## v7.0.0-alpha.19 [2020-9-13]

### Bug修复

修复表单动态隐藏和权限控制冲突问题

修复向导面板上一步去除表单校验逻辑

修复行为逻辑和附加后逻辑共同使用异常问题

修复树导航数据变化刷新当前节点问题

### 功能新增及优化

#### 模板

新增首页统一待办组件

新增实体工作流动态导航表格视图批量提交流程数据

新增菜单、工具栏、表单分组按钮、表单按钮、表格操作列单机模式支持

新增挂载外部配置文件

新增支持静态代码表样式表

新增增加树视图节点、日历项上下文菜单权限支持

新增支持表格导航、列表导航、卡片导航支持快速分组

新增部门人员选择器组件、文件上传（磁盘）组件、图片上传（磁盘）组件、动态表单组件

新增列表、数据视图回到顶部功能

新增表格分组、列表分组、数据视图分组功能

新增数据选择编辑器自填模式文本属性、值属性支持

新增附加逻辑外部逻辑支持

新增应用主题配置

优化项布局面板功能

优化列表样式

优化计数器支持

优化表格行编辑新建行追加在第一行

#### 基础文件

修复表单动态隐藏和权限控制冲突问题

修复嵌入视图组件初始化导航数据和抛值问题

修复app-format-data组件时间格式化转化异常 

优化工作流审批组件

优化穿梭框组件样式

优化app-span精度逻辑

优化计数器处理逻辑

优化快速分组代码表抛值逻辑

优化debug组件和头部菜单增加开发环境配置

新增统一待办组件

新增实体工作流动态导航表格视图批量提交数据

新增菜单、工具栏、表单分组按钮、表单按钮、表格操作列单机模式支持

新增挂载外部配置文件

新增支持静态代码表样式表

新增部门人员选择器组件、文件上传（磁盘）组件、图片上传（磁盘）组件、动态表单组件

新增应用主题配置

## v7.0.0-alpha.18 [2020-8-23]

### Bug修复

修复后续界面行为异常问题

修复表格合计行去掉N/A字样

修复树表跳转页面逻辑

修复嵌入表格保存提示信息重复问题

修复表格表格值清空保存问题

### 功能新增及优化

#### 模板

新增向导面板支持状态属性

新增应用全屏功能和应用锁屏功能

新增搜索表单新建默认值逻辑

新增实体表格值规则

新增动态工作流导航视图计数器

新增工作流审批意见控件时光轴样式组件和cron表达式组件

新增支持日历部件项布局面板

优化视图标题问题

优化表单属性值规则,无值的时候不校验

优化表单按钮、表单分组界面行为、表格操作列、工具栏、操作列权限控制

优化实体数据多项选择视图选中效果

优化动态代码表本地缓存逻辑

优化合入应用级上下文时机

优化实体数据重定向视图逻辑

优化表单开始流程和提交流程逻辑

#### 基础文件

修复表格滑动条表头与内容不齐

修复数据选择（嵌入视图）抛值异常问题

优化权限服务基类菜单权限和统一资源权限

优化动态工作流导航视图引擎

优化表单按钮、表单分组界面行为、表格操作列、工具栏、操作列权限控制

优化表单项增加padding

新增应用全屏组件和应用锁屏组件

新增工作流审批意见控件时光轴样式组件和cron表达式组件

## v7.0.0-alpha.17 [2020-8-9]

### Bug修复

修复系统级的操作标识异常问题

修复表格新增插件异常问题

修复表格单击行绑定数据异常bug

修复表格合计行样式问题

### 功能新增及优化

#### 模板

新增支持前后端分离部署

新增动态代码表预定义代码表支持

新增数据选择（调用接口）组件

新增部件样式表支持

优化数据服务逻辑

优化代码表服务基类、动态代码表

优化导航参数处理逻辑

优化数据拷贝逻辑

优化组织、部门、人员控件只绑定id逻辑

优化部件关联外键值

#### 基础文件

新增前后端分离部署

新增下拉列表控件支持树状代码表

新增数据选择（调用接口）组件

优化数据拷贝逻辑

优化组织、部门、人员控件只绑定id逻辑

## v7.0.0-alpha.16 [2020-8-2]

### Bug修复

修复表格聚合异常

修复文本框精度问题

修复属性值规则常规规则异常

修复应用菜单标题重复问题

修复界面行为异常问题

修复下拉选组件代码表类型和属性进行不匹配问题

### 功能新增及优化

#### 模板

新增应用数据看板视图（卡片样式）、实体数据看板视图（卡片样式）

优化拷贝功能

优化临时模式新建置空父键

优化实体行为执行后逻辑

优化操作栏触发界面行为逻辑

优化实体主状态

#### 基础文件

优化数值框数值位置

优化应用语言选择组件和应用组织部门信息呈现组件

优化无数据主键界面行为逻辑

## v7.0.0-alpha.15 [2020-7-23]

### Bug修复

修复修复数值框错误问题

修复表单通知关系界面上下文、表单数据先后顺序

修复实体行为执行前、后逻辑增加行为逻辑者判断

修复表单loadDraft清空表单临时主键

修复数据图表月份显示问题

修复首页横向菜单呈现

修复树视图部件国际化问题

### 功能新增及优化

#### 模板

新增表单属性值规则（正则式规则、数值范围规则、字符长度规则、常规规则、系统值规则、规则组）支持

新增数据选择、自动填充编辑器自填模式排序

新增表单传入关系界面临时模式

新增数据选择编辑器自填模式界面行为组（662）

新增向导添加数据

优化向导面板成功提示、忽略版本检查

优化导航类部件选中事件

优化表格操作列分隔符问题

优化表单准备工作流数据,填充未存库数据

#### 基础文件

修复数值框firstElementChild异常问题

修复图表视图无搜索表单加载数据问题

修复表格视图标题问题

更新view-design组件库的版本，修复面板分割组件

优化关系界面内嵌表格视图先行通知，再保存表单逻辑

优化部门选择、组织选择编辑器的样式

优化导入文件逻辑

新增关系界面增加无临时数据模式判断

新增数据选择、自动填充编辑器自填模式排序

新增数据选择编辑器自填模式界面行为组（662）

## v7.0.0-alpha.14 [2020-7-18]

### Bug修复

修复表格列千分位格式化

修复标签值格式化

修复表格转化数据错误问题

修复嵌套关系无数据时设置数据为空数组

### 功能新增及优化

#### 模板

新增编辑器插件

新增数据服务增加临时模式判断

新增支持实体行为定义检查方法

新增实体行为执行前、后逻辑 

新增操作栏主状态无权限模式

优化开发环境错误提示友好性

优化应用菜单多层嵌套问题

#### 基础文件

优化popover组件

实体数据服务基类增加saveBatch方法

优化应用菜单多层嵌套问题

## v7.0.0-alpha.13 [2020-7-12]

### Bug修复

修复表格设置更新默认值不生效

修复行编辑中文本字段修改数据保存无法生效

修复行编辑时的错误提示

修复表格开关部件保存异常问题

修复表单可以修改数据主键问题

修复表格操作列问题

#### 基础文件

优化关系界面逻辑

## v7.0.0-alpha.12 [2020-7-2]

### Bug修复

修复mpicker解析调整

修复表格列class逻辑调整

修复面板标签，隐藏表单项

修复嵌入视图导航服务逻辑调整

修复选择多数据视图选择数据异常

修复多行输入十行 高度问题

修复调整实体处理逻辑（参数name转化为codeName）

修复表单项更新值规则校验

修复单位部门选择器禁用功能

修复修复去掉某个子菜单后，主菜单不显示

### 功能新增及优化

#### 模板

新增表单显示更多模式（658）

新增首页应用切换器（658）

新增状态向导面板（658）

新增门户操作栏图标（654）

新增首页空白模式支持

新增表格支持列拖动

新增主状态操作标识权限逻辑

新增工具栏、表格操作列、表单分组主状态操作标识判断

优化应用级数据状态同步功能（654）

优化应用国际化部分

#### 基础文件

新增修改密码功能（654）

优化无权限错误信息友好提示

优化应用国际化部分

## v7.0.0-alpha.11 [2020-6-21]

### Bug修复

修复标题工具栏样式遮挡bug

修复表格行编辑字段格式对齐

修复日历部件初始化压缩成一行问题

修复下拉多选组件最后一项数据无法删除

### 功能新增及优化

#### 模板

新增支持表单、表格新建默认值（当前时间）

新增行编辑浮点数精度格式化

新增首页面包屑导航模式

新增编辑视图第一条记录、上一条记录、下一条记录、最后一条记录界面行为

优化面板和多数据部件数据流向

优化表单在模态打开模式中padding样式

优化嵌入视图中工具栏消息数量提示样式

优化动态导航视图树样式

#### 基础文件

新增行编辑浮点数精度格式化

## v7.0.0-alpha.10 [2020-6-18]

### Bug修复

分页导航视图页面刷新bug

表单项更新，实体行为调用不到bug

关系界面子界面保存不触发父界面保存

表单样式调整

### 功能新增及优化

#### 模板

表格操作列只显示图标时显示tooltip

门户部件高度为0时自适应

面板和多数据部件数据流向

列表，数据视图保存功能

门户部件标题界面行为tooltip

新增面包屑、应用切换器组件

#### 基础文件

formitem样式调整，label适配位置

表格行编辑切换，app-picker不显示

文件上传下载参数格式处理

## v7.0.0-alpha.9 [2020-6-11]

### Bug修复

数值代码表多语言

树右键菜单滚动条样式bug

列表面板界面行为bug

多选视图界面逻辑修复

图表刷新bug修复

日历部件选中抛出数据逻辑调整

编辑视图，app-span显示0时不显示

树视图右键界面行为刷新bug

快捷菜单控制台报错bug

门户加载自定义模型错误时，正常显示默认看板

修复雷达图显示异常问题

修复编辑类、分页导航视图带数据标题问题

修复饼图、漏斗图 获取序列参数错误问题

### 功能新增及优化

#### 模板

看板和门户布局模板调整，支持门户部件标题栏界面行为组

支持数据选择、地址框、自动完成、下拉列表、标签、选项框列表、单选列表等编辑器导航参数调整

支持树导航栏、表格导航栏、列表导航栏、卡片导航栏、日历导航栏、表单关系界面、数据选择面板、分页导航面板、数据关系栏、界面行为、新建逻辑、编辑逻辑导航参数调整

支持图表无数据时显示暂无数据

支持表格新建默认值

支持日历部件右键菜单

支持表格列触发界面行为

面板布局调整

#### 基础文件

门户部件视图的样式

数据选择，地址框，自动完成，下拉列表，标签，选项框列表，单选列表等编辑器导航参数调整

表单项label位置

调整登录页面

穿梭框编辑器支持

## v7.0.0-alpha.8 [2020-6-4]

### Bug修复

修复树右键菜单事件传值bug

修复树节点图标样式

修复viewdata和viewparams解析不同步

修复界面行为多主键分隔符由";"改为","

修复多层导航失效

数据选择，自动填充编辑器参数处理，动态代码表编辑器参数

修复富文本国际化bug

修复坐标轴的自定义参数

修复分页面板配置导航参数

修复实体处理逻辑

修复应用级context对象特性丢失的问题

修复新建逻辑

修复动态代码表传递上下文、参数逻辑

### 功能新增及优化

#### 模板

树选择双击

列表快速分组和快速搜索表单

数据视图快速分组和快速搜索表单

日历图例、日历快速分组和批处理工具栏

实体国际化路径调整

面板界面行为支持

列表，数据视图下拉加载

增加图表名称代码表识别、雷达图支持

uaa菜单权限

增加数据看板动态模型数据存库

应用样式调整

#### 基础文件

人员选择标准控件样式调整

应用样式调整

## v7.0.0-alpha.7 [2020-5-28]

### Bug修复

修复门户部件flex布局

修复表格选择框列样式出现省略号

修复批删除传递参数调整

修复表单上界面行为参数传递bug

修复分页导航、编辑类视图标题

修复界面行为多主键分隔符由";"改为","

修复导航类视图宽度格式

修复图表排序

修复关系界面逻辑

修复401跳登录页清除user和token

### 功能新增及优化

#### 模板

列表，数据视图默认排序

面板项支持偏移

应用支持自定义默认端口

门户部件图标和容器样式

表格列头图片和头部样式

表格操作列图标

表格编辑项值规则

增加树选择双击事件

增加图表分组属性计数统计（srfcount）

增加雷达图支持

#### 基础文件

修复分页导航、编辑类视图标题

修复界面行为多主键分隔符由";"改为","

修复关系界面逻辑

修复401跳登录页清除user和token

## v7.0.0-alpha.6 [2020-5-23]

### Bug修复

修复处理快速分组模型动态数据部分

修复列表，数据视图默认排序


### 功能新增及优化

#### 模板

补充单位选择器、部门选择器、人员选择器

#### 基础文件

补充单位选择器、部门选择器、人员选择器

## v7.0.0-alpha.5 [2020-5-21]

### Bug修复

修复表格视图搜索placeholder显示为搜索字段

修复表单嵌表单分页异常

修复门户视图操作栏标题

修复看板部件高度自动撑

修复表单分组，界面行为组不显示

修复表格操作列数据异常


### 功能新增及优化

#### 模板

支持拷贝功能

支持实体甘特图视图

支持面板项隐藏表单项

支持表格列最小宽度和操作列样式支持

支持列表项、面板代码表转化

#### 基础文件

支持列表项、面板代码表转化

修复表单分组，界面行为组不显示

## v7.0.0-alpha.4 [2020-5-14]

### Bug修复

修复代码表代码项图标和数据

修复数据多项选择视图UI逻辑不匹配

修复列表高度异常

修复树节点上下文

修复表格（视图）高度，滚动条问题

修复表单loaddraft服务仿真主键丢失修复

修复user显示名称逻辑

修复issue地址为正式环境地址


### 功能新增及优化

#### 模板

模态时视图样式调整

增加菜单权限

增加快速分组搜索或快速搜索表单功能

增加表格内置工具栏

代码表多选控件分割符从分号转化为逗号


#### 基础文件

增加数据选择类插件表格呈现插件


## v7.0.0-alpha.3 [2020-5-10]

### Bug修复

分页导航栏传递srfparentdename和srfparentkey问题

提交流程、启动流程刷新表格数据问题

修复视图自定义导航参数大小写问题

修复批添加功能

修复树部件查询数据集合异常处理

修复图表排序问题

修复富文本国际化切换失效

### 功能新增及优化

#### 模板

搜索面板布局优化

表格checkbox宽度优化

选择类视图不显示标题

补充树节点关系导航上下文，导航参数上下文

#### 基础文件

登录页面调整

## v7.0.0-alpha.2 [2020-5-7]

### Bug修复

分页导航栏添加图标配置

### 功能新增及优化

#### 模板

表格文件上传信息显示

批添加、批删除

实体工作流动态视图

实体工作流动态导航表格视图

富文本信息模式

更新默认值

#### 基础文件

表格文件上传信息显示

实体工作流动态视图

实体工作流动态导航表格视图

## v7.0.0-alpha.1 [2020-4-29]

初始化文件