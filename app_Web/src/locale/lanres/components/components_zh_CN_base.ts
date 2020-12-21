function getLocaleResourceBase(){
  const data:any = {
      "404": {
          errorText1: '抱歉，您访问的页面不存在！',
          errorText2: '您要找的页面不存在，请返回',
          indexPage: '首页',
          continue: '继续浏览',
      },
      "500": {
          errorText1: '抱歉，服务器出错了！',
          errorText2: '服务器出错了，请返回 ',
          indexPage: '首页',
          continue: '继续浏览',
      },
      appOrgSector:{
        successSwitch:'切换成功',
        errorSwitch:'切换失败',
      },
      appAutocomplete: {
          error: '错误',
          miss: '缺少参数',
          requestException: '请求异常！',
      },
      appBuild: {
        custom: '定制',
      },
      appCheckBox: {
          notExist: '代码表不存在',
      },
      appColumnLink: {
        error: '错误',
        valueItemException:"值项异常",
        rowDataException:"表格行数据异常",
      },
      appColumnRender: {
        select: '请选择...',
        unsupported: '不支持',
      },
      appDashboardDesign: {
        global: '全局',
      },
      appDataUploadView: {
        "viewtitle":"应用数据导入视图",
        "selectfile":"选取文件",
        "uploadserver":"上传服务器",
        "datatemplate":"下载导入数据模板",
        "dataid":"数据标识为",
        "read":"读取成功",
        "importing":"导入中",
        "completed":"导入完成",
        "confirm":"确认",
        "datatemp":"导入数据模板",
        "importfailed":"导入失败"
      },
      appDebugActions:{
        button: '开启配置模式',
      },
      appExportExcel: {
        total: '全部',
        max: '最大',
        row: '行',
        currentPage: '当前页',
        desc:'请输入起始页',
        desc1:'请输入有效的起始页',
      },
      appFileUpload: {
        preview: '查看',
        uploadText: '将文件拖到此处，或<em>点击上传</em>',
        uploadError: '上传失败',
        fileTypeErrorTitle: '文件类型错误',
        fileTypeErrorInfo: '请选择图片类型的文件，如JPEG，GIF，PNG，BMP',
      },
      appFormDRUIPart: {
        blockUITipInfo: '请先保存主数据',
        viewLoadComp:'多数据视图加载完成，触发后续表单项更新',
        save:'关系数据保存完成',
        change:'关系数据值变化',
        change1:'视图数据变化',
        loadComp:'视图加载完成',
      },
      appHeaderMenus: {
        ibizlab:{
            title: 'iBiz开放平台',
        },
        publishProject:{
            title: '项目文件',
        },
        ibizstudio:{
            title: '模型设计工具',
        },
        ibizbbs:{
            title: 'iBiz论坛',
        },
      },
      appMpicker: {
        error: '错误',
        miss: '缺少参数',
        requestException: '请求异常！',
      },
      appPicker: {
        error: '错误',
        miss: '缺少参数',
        requestException: '请求异常！',
        newAndEdit: '创建并编辑...',
        systemException: '系统异常！',
        valueitemException: '值项异常！',
        formdataException: '表单数据异常！',
      },
      appPickerSelectView: {
        error: '错误',
        valueitemException: '值项异常！',
        formdataException: '表单数据异常！',
        placeholder: '请选择...',
      },
      appPortalDesign: {
        customPortal: '自定义门户',
        save: '保存',
      },
      appRangDate: {
        placeholder: '请选择时间...',
        from: '自',
        daystart: '日 0 时 起 至',
        dayend: '日 24 时 止',
      },
      appRangeEditor: {
        placeholder: '请选择时间...',
        input: '请输入...',
      },
      appStudioAction: {
        configTitle: '进入当前视图配置界面',
        configButton: '配置',
        issueTitle: '建立当前界面的issues',
        issueButton: '新建issues',
      },
      appTreePicker: {
        placeholder: '请选择...',
      },
      dateRange: {
        startText: '保险期限 ： 自',
        endText: '日 24 时 止',
        startPlaceholder: '开始日期',
        rangeSeparatorr: ' 0 时起 至',
        endPlaceholder: '结束日期',
      },
      dropDownList: {
        placeholder: '请选择...',
      },
      dropDownListDynamic: {
        placeholder: '请选择...',
      },
      dropDownListMpicker: {
        placeholder: '请选择...',
      },
      login: {
        error: '错误',
        caption: '欢迎登录',
        placeholder1:'用户名',
        placeholder2:'密码',
        name: '登录',
        reset:'重置',
        other:'其他登录方式',
        tip: '输入用户名和密码',
        warning1:'qq授权登录暂未支持',
        warning2:'微信授权登录暂未支持',
        loginname: {
            placeholder: '请输入用户名',
            message: '用户名不能为空',
        },
        password: {
            placeholder: '请输入密码',
            message: '密码不能为空',
        },
        loginfailed: '登录失败',
      },
      appUser: {
        name: '系统管理员',
        logout: '退出登录',
        surelogout: '确认要退出登录？',
        changepwd: "修改密码",
      },
      appTheme: {
        caption: {
          theme: '主题',
          font: '字体',
        },
        fontFamilys: {
            MicrosoftYaHei: '微软雅黑',
            SimHei: '黑体',
            YouYuan: '幼圆',
        },
      },
      appFormGroup: {
        hide: '隐藏字段',
        showMore: '显示更多字段',
      },
      appUpdatePassword: {
        oldPwd: '原密码',
        newPwd: '新密码',
        confirmPwd: '确认密码',
        sure: '确认修改',
        oldPwdErr: '原密码不能为空！',
        newPwdErr: '新密码不能为空！',
        confirmPwdErr: '两次输入密码不一致！',
      },
      appAddressSelection: {
        loadDataFail: '城市数据加载失败'
      },
      appGroupSelect:{
        groupSelect:'分组选择', 
      },
      appImageUpload:{
        uploadFail:'上传失败'
      },
      appOrgSelect:{
        loadFail:'加载数据失败'
      },
      appTransfer:{
        title1:'未选择',
        title2:'已选择',
      },
      appWFApproval:{
        commit:'提交',
        wait:'等待',
        handle:'处理',
        placeholder:'请输入内容',
        end:'结束'
      },
      contextMenuDrag:{
        allApp:'全部应用',
        noFind:'未找到该应用'
      },
      filterMode:{
        placeholder:'条件逻辑',  
      },
      filterTree:{
        title1:'添加条件',
        title2:'添加组',
        placeholder:'属性', 
      },
      iBizGroupPicker:{
        ok:'确认',
        cancel:'取消',
      },
      iBizGroupSelect:{
        groupSelect:'分组选择'
      },
      tabPageExp:{
        more:'更多',
      },
      uploadFile:{
        imgMsg:'将图片拖到这里替换',
        localUpload:'本地上传',
        or:'或',
        imgMsg1:'从素材库选择'
      },
      lockScren:{
        title:'设置锁屏密码',
        label:'锁屏密码',
        message:'锁屏密码不能为空',
        placeholder:'请输入锁屏密码',
        placeholder1:'请输入登录密码',
        message1: '解锁密码错误,请重新输入',
        promptInformation:'是否退出系统, 是否继续?',
        prompt:'提示',
        confirmButtonText:'确定',
        cancelButtonText:'取消',
      },
      cronEditor: {
        label: {
          second: '秒',
          minute: '分',
          hour: '时',
          day: '日',
          week: '周',
          month: '月',
          year: '年',
        },
        public : {
          specify: '指定',
          notSpecify: '不指定',
          cycle: '周期',
          from: '从',
          to: '至',
          loop: '循环',
          every: '每',
          once: '执行一次',
        },
        second: '秒',
        minute: '分',
        hour: {
          title: '时',
          everyHour: '每时',
          hourStart: '时开始，每',
          onceAHour: '时执行一次',
        },
        day: {
          title: '日',
          daily: '每日',
          workDay: '工作日',
          dayStart: '日开始，每',
          onceADay: '日执行一次',
          thisMonth: '本月',
          lastWorkDay: '号，最近的工作日',
          lastDayOfMonth: '本月最后一天',
        },
        month: {
          title: '月',
          everyMonth: '每月',
          monthStart: '月开始，每',
          onceAMonth: '月执行一次',
        },
        week: {
          title: '周',
          everyWeek: '每周',
          from: '从星期',
          to: '至星期',
          start: '开始，每',
          onceADay: '天执行一次',
          specifyWeek: '指定周',
          weekOfMonth: '本月第',
          weekWeek: '周，星期',
          lastOfMonth: '本月最后一个',
          week: '星期',
        },
        year: {
          title: '年',
          everyYear: '每年',
        },
        message: {
          error1: '日期与星期不可以同时为“不指定”',
          error2: '日期与星期必须有一个为“不指定”',
        },
      },
      appMessagePopover: {
        loadMore: '加载更多',
        noMore: '没有更多了'
      },
      diskFileUpload:{
        fileDrag: '将文件拖到此处，或',
        clickUpload: '点击上传',
        load: '下载',
        preview: '预览',
        edit: '编辑',
        delete: '删除',
        clues: '单个文件大小不超过',
        clues1: '文件不超过',
        getFileFailure: '获取文件列表失败',
        loadFailure: '上传文件失败',
        loadFailure1: '上传失败,单个文件不得超过',
        downloadFile: '下载文件失败',
        downloadFile1: '下载文件失败,未获取到文件!',
        deleteFile: '此操作将永久删除该文件, 是否继续?',
        deleteFilePrompt: '提示',
        true: '确定',
        false: '取消',
        deleteFileFailure: '删除文件失败',
        updateFailure: '批量更新文件失败',
      },
      diskImageUpload:{
        preview: '预览',
        OCRdiscern: 'ORC识别',
        load: '下载',
        delete: '删除',
        getImageFailure: '获取图片列表失败',
        loadImageFailure: '下载缩略图失败',
        loadImageFailure1: '下载缩略图失败,未获取到文件!',
        loadImageFailure2:'下载图片失败',
        loadImageFailure3:'下载图片失败,未找到图片!',
        ImageIdNone: '图片id不存在!',
        uploadImageFailure: '上传图片失败',
        uploadImageFailure1: '上传失败,仅支持＇gif，jpg，png，bmp＇格式的图片!',
        uploadFailure: '上传失败,单个图片不得超过',
        notImageUrl: '图片url不存在',
        deleteFile: '此操作将永久删除该文件, 是否继续?',
        deleteFilePrompt: '提示',
        true: '确定',
        false: '取消',
        deleteImageFailure:'删除图片失败',
        updateFailure: '批量更新文件失败',
      },
      appMapPosition: {
        submit: '确认',
        title: '请选择地址'
      },
      appSortBar: {
        title: '排序'
      },
      appAfterTime:{
        minutesAgo: '分钟前',
        hoursAgo: '小时前',
        dayAgo: '天前',
        monthsAgo: '月前',
        yearsAgo: '年前'
      }
  };
  return data;
}
export default getLocaleResourceBase;