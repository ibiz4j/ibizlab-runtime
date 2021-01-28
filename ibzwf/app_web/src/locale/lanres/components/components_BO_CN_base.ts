function getLocaleResourceBase(){
  const data:any = {
      "404": {
          errorText1: 'དགོངས་པ་མ་ཚོམ།ཁྱེད་རང་གི་བཅར་འདྲིའི་དྲ་ངོས་མི་འདུག',
          errorText2: 'ཁྱེད་རང་བཙལ་བའི་ལྡེབ་ངོས་མི་གནས་པ་དང་།ཕྱིར་ལོག་རོགས་།',
          indexPage: 'གཙོ་ངོས།',
          continue: 'མུ་མཐུད་དུ་རགས་ལྟ་',
      },
      "500": {
          errorText1: 'དགོངས་པ་མ་ཚོམ།ཞབས་ཞུའི་འཕྲུལ་ཆས་ནོར་འདུག',
          errorText2: 'ཞབས་ཞུ་ཆས་ནོར་འདུག་ཕྱིར་ལོག་རོགས་། ',
          indexPage: 'གཙོ་ངོས།',
          continue: 'མུ་མཐུད་དུ་རགས་ལྟ་',
      },
      appOrgSector:{
        successSwitch:'བརྗེ་ཐུབ་སོང་།',
        errorSwitch:'བརྗེ་སྤོར་ཕམ་པ།',
      },
      appAutocomplete: {
          error: 'ནོར་འཁྲུལ།',
          miss: 'ཞུགས་གྲངས་ཆད་པ།',
          requestException: 'རྒྱུན་ལྡན་མིན་པའི་རེ་བ་ཞུ།',
      },
      appBuild: {
        custom: 'གཏན་སྲོལ་',
      },
      appCheckBox: {
          notExist: 'ཚབ་ཨང་རེའུ་མིག',
      },
      appColumnLink: {
        error: 'ནོར་འཁྲུལ།',
        valueItemException:"གྲངས་ཐང་ཚན་རྒྱུན་འགལ།",
        rowDataException:"རེའུ་མིག་ཕྲེང་གི་གཞི་གྲངས་རྒྱུན་འགལ།",
      },
      appColumnRender: {
        select: 'གང་ལགས་ཤེ་ན།...',
        unsupported: 'རྒྱབ་སྐྱོར་མི་བྱེད་པ་',
      },
      appDashboardDesign: {
        global: 'ཁྱོན་ཡོངས།',
      },
      appDataUploadView: {
        "viewtitle":"ཉེར་སྤྱོད་གཞི་གྲངས་ནང་འདྲེན་མཐོང་རིས་",
        "selectfile":"ཡིག་ཆ་འདེམས་པ་",
        "uploadserver":"ཡར་བསྐུར་ཞབས་ཞུ་ཆས་།",
        "datatemplate":"ཕབ་ལེན་ནང་འདྲེན་གཞི་གྲངས་དཔེ་པང་།",
        "dataid":"གཞི་གྲངས་ཀྱི་མཚོན་རྟགས་",
        "read":"ཀློག་ལེན་གྲུབ་འབྲས་ཐོབ་པའི་ངང་",
        "importing":"ནང་འདྲེན་བྱེད་བཞིན་ཡོད།",
        "completed":"ནང་འདྲེན་ལེགས་སྒྲུབ་",
        "confirm":"ངོས་འཛིན་",
        "datatemp":"ནང་འདྲེན་གཞི་གྲངས་དཔེ་པང་",
        "importfailed":"ནང་འདྲེན་ཕམ་པ།"
      },
      appDebugActions:{
        button: 'ཁ་འབྱེད་སྡེབ་སྒྲིག་རྣམ་པ་',
      },
      appExportExcel: {
        total: 'ཚང་མ།',
        max: 'ཆེ་ཤོས་',
        row: 'ཕྲེང་',
        currentPage: 'མིག་སྔའི་ལྡེབ་ངོས།',
        desc:'ཐོག་མའི་ཤོག་ངོས་ནང་འཇུག་རོགས་།',
        desc1:'ནུས་ལྡན་གྱི་ཐོག་མའི་ཤོག་ངོས་ནང་འཇུག་རོགས་།',
      },
      appFileUpload: {
        preview: 'ལྟ་ཞིབ་',
        uploadText: 'ཡིག་ཆ་འདིར་དྲུད་།，ཡང་ན་<em>སྣོན་ནས་ཡར་སྐུར་དགོས།</em>',
        uploadError: 'ཡར་བསྐུར་ཕམ་',
        fileTypeErrorTitle: 'ཡིག་ཆའི་རིགས་ཀྱི་ནོར་འཁྲུལ་',
        fileTypeErrorInfo: 'པར་རིས་རིགས་ཀྱི་ཡིག་ཆ་འདེམ་དགོས།，དཔེར་ན་JPEG GIF PNG BMP། ',
      },
      appFormDRUIPart: {
        blockUITipInfo: 'གཞི་གྲངས་གཙོ་བོ་སྔོན་ལ་ཉར་ཚགས་བྱེད་རོགས་།',
        viewLoadComp:'གཞི་གྲངས་མང་བའི་མཐོང་རིས་སྣོན་འཇུག་དང་།འཕྲད་ཐོན་རྗེས་མཐུད་རེའུ་མིག་ཁེར་རྐྱང་གསར་སྒྱུར་།',
        save:'འབྲེལ་བའི་གཞི་གྲངས་ཉར་ཚགས།',
        change:'འབྲེལ་བའི་གཞི་གྲངས་ཐང་གི་འགྱུར་ལྡོག་',
        change1:'མཐོང་རིས་གཞི་གྲངས་འགྱུར་ལྡོག་',
        loadComp:'མཐོང་རིས་སྣོན་འཇུག་ལེགས་འགྲུབ་',
      },
      appHeaderMenus: {
        ibizlab:{
            title: 'iBizསྒོ་འབྱེད་སྟེགས་བུ་',
        },
        publishProject:{
            title: 'རྣམ་གྲངས་ཡིག་ཆ།',
        },
        ibizstudio:{
            title: 'དཔེ་དབྱིབས་ཇུས་འགོད་ལག་ཆ།',
        },
        ibizbbs:{
            title: 'iBizགླེང་སྟེགས།',
        },
      },
      appMpicker: {
        error: 'ནོར་འཁྲུལ།',
        miss: 'ཞུགས་གྲངས་ཆད་པ།',
        requestException: 'རྒྱུན་ལྡན་མིན་པའི་རེ་བ་ཞུ།',
      },
      appPicker: {
        error: 'ནོར་འཁྲུལ།',
        miss: 'ཞུགས་གྲངས་ཆད་པ།',
        requestException: 'རྒྱུན་ལྡན་མིན་པའི་རེ་བ་ཞུ།',
        newAndEdit: 'གསར་སྐྲུན་དང་རྩོམ་སྒྲིག...',
        systemException: 'མ་ལག་རྒྱུན་ལྡན་མ་རེད།',
        valueitemException: 'རྣམ་གྲངས་རྒྱུན་ལྡན་མིན་པ།',
        formdataException: 'གྲངས་ཀ་རྒྱུན་ལྡན་མ་རེད།',
      },
      appPickerSelectView: {
        error: 'ནོར་འཁྲུལ།',
        valueitemException: 'རྣམ་གྲངས་རྒྱུན་ལྡན་མིན་པ།',
        formdataException: 'གྲངས་ཀ་རྒྱུན་ལྡན་མ་རེད།',
        placeholder: 'གང་ལགས་ཤེ་ན།...',
      },
      appPortalDesign: {
        customPortal: 'རང་གིས་མཚན་ཉིད་བཞག་པའི་སྒོ་མོ།',
        save: 'ཉར་ཚགས།',
      },
      appRangDate: {
        placeholder: 'དུས་ཚོད་འདེམ་རོགས།...',
        from: 'རང་',
        daystart: 'ཉི་མ་ཆུ་ཚོད་བཅུ་པ་ནས་བཟུང།',
        dayend: 'ཉིན་རེའི་ཆུ་ཚོད་24བར་།',
      },
      appRangeEditor: {
        placeholder: 'དུས་ཚོད་འདེམ་རོགས།...',
        input: 'ནང་འཇུག།...',
      },
      appStudioAction: {
        configTitle: 'མིག་སྔའི་མཐོང་རིས་སྡེབ་སྒྲིག་མཐུད་མཚམས་',
        configButton: 'སྡེབ་སྒྲིག',
        issueTitle: 'མིག་སྔའི་མཐུད་མཚམས་འཛུགས་ཀྱི་issus།',
        issueButton: 'གསར་དུ་བསྐྲུན་པའི་issus',
      },
      appTreePicker: {
        placeholder: 'གང་ལགས་ཤེ་ན།...',
      },
      dateRange: {
        startText: 'གུན་སྐྱོབ་ཀྱི་དུས་བཅད་ ： རང་',
        endText: 'ཉིན་རེའི་ཆུ་ཚོད་24བར་།',
        startPlaceholder: 'འགོ་འཛུགས་དུས་ཚོད།',
        rangeSeparatorr: ' 0 དུས་ཐོག་ཏུ་སླེབས་པ།',
        endPlaceholder: 'མཇུག་རྫོགས་ཚེས་གྲངས།',
      },
      dropDownList: {
        placeholder: 'གང་ལགས་ཤེ་ན།...',
      },
      dropDownListDynamic: {
        placeholder: 'གང་ལགས་ཤེ་ན།...',
      },
      dropDownListMpicker: {
        placeholder: 'གང་ལགས་ཤེ་ན།...',
      },
      login: {
        error: 'ནོར་འཁྲུལ།',
        caption: 'ཐོ་འགོད་ལ་ཕེབས་པར་དགའ་བསུ་ཞུ་།',
        placeholder1:'སྤྱོད་མཁན་གྱི་མིང་',
        placeholder2:'གསང་ཨང་',
        name: 'ཐོ་འགོད།',
        reset:'བསྐྱར་འཇོག',
        other:'ཐོ་འཇུག་བྱེད་སྟངས་གཞན་དག་།',
        tip: 'སྤྱོད་མཁན་གྱི་མིང་དང་གསང་ཨང་ནང་འཇུག་',
        warning1:'qqདབང་བཅོལ་ཐོ་འཇུག་གནས་སྐབས་སུ་རྒྱབ་སྐྱོར་མ་བྱས་།',
        warning2:'སྐད་འཕྲིན་དབང་སྤྲོད་ཐོ་འཇུག་གནས་སྐབས་རྒྱབ་སྐྱོར་མ་བྱས་།',
        loginname: {
            placeholder: 'འཇུག་རོགས་།སྤྱོད་མཁན་གྱི་མིང་།',
            message: 'སྤྱོད་མཁན་གྱི་མིང་སྟོང་མི་ཆོག',
        },
        password: {
            placeholder: 'གསང་ཨང་ནང་འཇུག་རོགས་།',
            message: 'གསང་ཨང་སྟོང་མི་རུང་།',
        },
        loginfailed: 'ཐོ་འཇུག་ཕམ་པ།',
      },
      appUser: {
        name: 'རྒྱུད་ཁོངས་དོ་དམ་པ་',
        logout: 'ཐོ་འཇུག་ནས་ཕྱིར་འབུད་',
        surelogout: 'ཐོ་འགོད་ནས་ཕྱིར་འབུད་རྒྱུ་ཡིན་ནམ།',
        changepwd: "གསང་ཨང་བཅོས་པ།",
      },
      appTheme: {
        caption: {
          theme: 'བརྗོད་བྱ་གཙོ་བོ།',
          font: 'ཡིག་གཟུགས།',
        },
        fontFamilys: {
            MicrosoftYaHei: 'ཝེ་རོན་ཡ་ཧེ།',
            SimHei: 'ནག་གཟུགས།',
            YouYuan: 'ཕྲུ་གུ་',
        },
      },
      appFormGroup: {
        hide: 'སྦས་པའི་ཡིག་དུམ།',
        showMore: 'དེ་ལས་མང་བའི་ཡིག་དུམ།',
      },
      appUpdatePassword: {
        oldPwd: 'ཐོག་མའི་གསང་ཨང་',
        newPwd: 'གསང་ཨང་གསར་པ།',
        confirmPwd: 'གསང་ཨང་ངོས་འཛིན་',
        sure: 'ངོས་འཛིན་བཟོ་བཅོས་',
        oldPwdErr: 'དེ་སྔའི་གསང་གྲངས་སྟོང་པ་མ་རེད།',
        newPwdErr: 'གསང་གྲངས་གསར་པ་སྟོང་པ་མ་རེད།',
        confirmPwdErr: 'ཐེངས་གཉིས་ལ་གསང་ཨང་ནང་འཇུག་མི་མཐུན།',
      },
      appAddressSelection: {
        loadDataFail: 'གྲོང་ཁྱེར་གཞི་གྲངས་ཁུར་སྣོན་ཕམ་'
      },
      appGroupSelect:{
        groupSelect:'སྐོར་བགོས་གདམ་གསེས་', 
      },
      appImageUpload:{
        uploadFail:'ཡར་བསྐུར་ཕམ་'
      },
      appOrgSelect:{
        loadFail:'ཁུར་སྣོན་གཞི་གྲངས་ཕམ་པ།'
      },
      appTransfer:{
        title1:'མ་བདམས་',
        title2:'བདམས་ཟིན་',
      },
      appWFApproval:{
        commit:'འབུལ་བ་',
        wait:'སྒུག་པ་',
        handle:'ཐག་གཅོད་',
        placeholder:'ནང་དོན་རོགས་།',
        end:'མཇུག་སྒྲིལ།'
      },
      contextMenuDrag:{
        allApp:'ཆ་ཚང་བེད་སྤྱོད།',
        noFind:'བེད་སྤྱོད་དེ་རྙེད་མ་བྱུང་།'
      },
      filterMode:{
        placeholder:'ཆ་རྐྱེན་གཏན་ཚིགས།',  
      },
      filterTree:{
        title1:'ཁ་སྣོན་ཆ་རྐྱེན།',
        title2:'ཁ་སྣོན་ཚོ་',
        placeholder:'ངོ་བོ་', 
      },
      iBizGroupPicker:{
        ok:'ངོས་འཛིན་',
        cancel:'མེད་པར་བཟོ་བ་',
      },
      iBizGroupSelect:{
        groupSelect:'སྐོར་བགོས་གདམ་གསེས་'
      },
      tabPageExp:{
        more:'དེ་བས་མང་བ་',
      },
      uploadFile:{
        imgMsg:'རི་མོ་འདིར་དྲུད་ནས་བརྗེ་།',
        localUpload:'རང་སའི་ཡར་སྤྲོད་དགོས།',
        or:'ཡང་ན་',
        imgMsg1:'རྒྱུ་ཆ་མཛོད་ནས་འདེམས་དགོས།'
      },
      lockScren:{
        title:'སྒྲོག་ཡོལ་གསང་ཨང་འགོད་པ་',
        label:'སྒྲོག་ཤེལ་གསང་ཨང་',
        message:'ཟྭ་ཡོལ་གསང་ཨང་སྟོང་མི་རུང་།',
        placeholder:'སྒོ་ལྕགས་ཀྱི་གསང་ཨང་ནང་འཇུག་རོགས་།',
        placeholder1:'གསང་ཨང་ནང་འཇུག་རོགས་།',
        message1: 'སྒྲོག་འགྲོལ་གསང་ཨང་ནོར་འཁྲུལ་,ཡང་བསྐྱར་ནང་འཇུག་རོགས་།',
        promptInformation:'ཕྱིར་འཐེན་བྱེད་མིན་རྒྱུད་ཁོངས།, མུ་མཐུད་ཡིན་ནམ།',
        prompt:'གསལ་འདེབས་',
        confirmButtonText:'གཏན་ཁེལ་',
        cancelButtonText:'མེད་པར་བཟོ་བ་',
      },
      cronEditor: {
        label: {
          second: 'སྐར་ཆ་',
          minute: 'སྐར་མ་',
          hour: 'དུས་',
          day: 'ཉི་མ།',
          week: 'གཟའ་འཁོར།',
          month: 'ཟླ་བ།',
          year: 'ལོ་',
        },
        public : {
          specify: 'དམིགས་འཛུགས་',
          notSpecify: 'དམིགས་འཛུགས་མི་བྱེད་པ་',
          cycle: 'འཁོར་ཡུན་',
          from: 'ནས།',
          to: 'སླེབས་པ་',
          loop: 'རྒྱུན་འཁོར།',
          every: 'རེ་རེ།',
          once: 'ལག་ལེན་ཐེངས་གཅིག་',
        },
        second: 'སྐར་ཆ་',
        minute: 'སྐར་མ་',
        hour: {
          title: 'དུས་',
          everyHour: 'དུས་དང་རྣམ་པ་ཀུན་ཏུ་',
          hourStart: 'དུས་མགོ་བརྩམས་།，རེ་རེ།',
          onceAHour: 'དུས་ལག་བསྟར་ཐེངས་གཅིག་།',
        },
        day: {
          title: 'ཉི་མ།',
          daily: 'ཉིན་རེ་',
          workDay: 'ལས་ཞག་',
          dayStart: 'ཉིན་མོ་འགོ་ཚུགས་།，རེ་རེ།',
          onceADay: 'ཉིན་རེར་ལག་བསྟར་ཐེངས་རེ།',
          thisMonth: 'ཟླ་བ་འདི་གར།',
          lastWorkDay: 'ཨང་།，ཆེས་ཉེ་བའི་ལས་ཞག་',
          lastDayOfMonth: 'ཟླ་འདིའི་ཆེས་མཇུག་མཐའི་ཉིན་མོ་།',
        },
        month: {
          title: 'ཟླ་བ།',
          everyMonth: 'ཟླ་རེ།',
          monthStart: 'ཟླ་བ་མགོ་བརྩམས་།，རེ་རེ།',
          onceAMonth: 'ཟླ་བ་ལག་བསྟར་ཐེངས་གཅིག་།',
        },
        week: {
          title: 'གཟའ་འཁོར།',
          everyWeek: 'གཟའ་འཁོར་རེ་',
          from: 'གཟའ་འཁོར།',
          to: 'ནས་གཟའ་འཁོར་།',
          start: 'འགོ་ཚུགས་པ་，རེ་རེ།',
          onceADay: 'གནམ་ནས་ལག་བསྟར་ཐེངས་གཅིག་བྱེད།',
          specifyWeek: 'དམིགས་བཙུགས་གཟའ་འཁོར།',
          weekOfMonth: 'ཟླ་འདིའི་ཟླ་བ།',
          weekWeek: 'གཟའ་འཁོར།，གཟའ་འཁོར།',
          lastOfMonth: 'ཟླ་འདིའི་ཆེས་མཇུག་མ།',
          week: 'གཟའ་འཁོར།',
        },
        year: {
          title: 'ལོ་',
          everyYear: 'ལོ་རེ་',
        },
        message: {
          error1: 'དུས་ཚོད་དང་གཟའ་འཁོར་གཉིས་དུས་གཅིག་ཏུ་“དམིགས་འཛུགས་མ་བྱས་”ཆོག་གི་མ་རེད་།',
          error2: 'དུས་ཚོད་དང་གཟའ་འཁོར་ངེས་པར་དུ་“དམིགས་འཛུགས་མི་བྱེད་པ་”ཞིག་ཡོད་།',
        },
      },
      appMessagePopover: {
        loadMore: 'མང་ཙམ་བླུགས་རོགས།',
        noMore: 'དེ་ལས་མང་བ་མི་འདུག'
      },
      diskFileUpload:{
        fileDrag: 'ཡིག་ཆ་འདིར་དྲུད་།，ཡང་ན་',
        clickUpload: 'སྣོན་ནས་ཡར་སྐུར་དགོས།',
        load: 'ཕབ་འཇུག',
        preview: 'སྔོན་ལྟ་',
        edit: 'རྩོམ་སྒྲིག',
        delete: 'སུབ་པ་',
        clues: 'ཡིག་ཆ་ཁེར་རྐྱང་གི་ཆེ་ཆུང་ལས་བརྒལ་མི་རུང་།',
        clues1: 'ཡིག་ཆ་ལས་མི་བརྒལ་བ་',
        getFileFailure: 'ཡིག་ཆའི་རེའུ་མིག་ཐོབ་པ་ཕམ་།',
        loadFailure: 'ཡིག་ཆ་བརྒྱུད་སྐྱེལ་ཕམ་',
        loadFailure1: 'ཡར་བསྐུར་ཕམ་,ཡིག་ཆ་ཁེར་རྐྱང་ལས་བརྒལ་མི་ཆོག',
        downloadFile: 'ཡིག་ཆ་ཕབ་ལེན་ཕམ་།',
        downloadFile1: 'ཡིག་ཆ་ཕབ་ལེན་ཕམ་།,ཡིག་ཆ་མ་ཐོབ།',
        deleteFile: 'བཀོལ་སྤྱོད་འདི་ཡིག་ཆ་དེ་ནམ་ཡང་བསུབ་རྒྱུ་།, མུ་མཐུད་ཡིན་ནམ།?',
        deleteFilePrompt: 'གསལ་འདེབས་',
        true: 'གཏན་ཁེལ་',
        false: 'མེད་པར་བཟོ་བ་',
        deleteFileFailure: 'ཡིག་ཆ་སུབ་པ་ཕམ་',
        updateFailure: 'སྡེབ་འབོར་གསར་སྒྱུར་ཡིག་ཆ་ཕམ་པ།',
      },
      diskImageUpload:{
        preview: 'སྔོན་ལྟ་',
        OCRdiscern: 'ORCངོས་འཛིན་',
        load: 'ཕབ་འཇུག',
        delete: 'སུབ་པ་',
        getImageFailure: 'པར་རིས་ཀྱི་རེའུ་མིག་ཐོབ་མ་ཐུབ།',
        loadImageFailure: 'ཕབ་ལེན་བསྡུས་རིས་ཕམ་།',
        loadImageFailure1: 'ཕབ་ལེན་བསྡུས་རིས་ཕམ་།,ཡིག་ཆ་མ་ཐོབ་པ།',
        loadImageFailure2:'པར་རིས་ཕབ་ལེན་ཕམ་།',
        loadImageFailure3:'པར་རིས་ཕབ་ལེན་ཕམ་།,པར་རིས་མ་རྙེད།',
        ImageIdNone: 'པར་རིས་idམི་འདུག',
        uploadImageFailure: 'ཡར་བསྐུར་པར་རིས་ཕམ་',
        uploadImageFailure1: 'ཡར་བསྐུར་ཕམ་,༢༠༠if.jpg，png，bmpརྣམ་པའི་པར་རིས། ',
        uploadFailure: 'ཡར་བསྐུར་ཕམ་,པར་རིས་གཅིག་ལས་བརྒལ་མི་ཆོག་།',
        notImageUrl: 'པར་རིས་urlགནས་མེད་།',
        deleteFile: 'བཀོལ་སྤྱོད་འདི་ཡིག་ཆ་དེ་ནམ་ཡང་བསུབ་རྒྱུ་།, མུ་མཐུད་ཡིན་ནམ།',
        deleteFilePrompt: 'གསལ་འདེབས་',
        true: 'གཏན་ཁེལ་',
        false: 'མེད་པར་བཟོ་བ་',
        deleteImageFailure:'པར་རིས་སུབ་པ་ཕམ་',
        updateFailure: 'སྡེབ་འབོར་གསར་སྒྱུར་ཡིག་ཆ་ཕམ་པ།',
      },
      appMapPosition: {
        submit: 'ངོས་འཛིན་',
        title: 'ཤག་གནས་འདེམས་རོགས་།'
      },
      appSortBar: {
        title: 'རིམ་སྒྲིག་'
      },
      appAfterTime:{
        minutesAgo: 'སྐར་མ་གོང་།',
        hoursAgo: 'ཆུ་ཚོད་ཀྱི་གོང་།',
        dayAgo: 'གནམ་གྱི་མདུན།',
        monthsAgo: 'ཟླ་བ་སྔོན་མ།',
        yearsAgo: 'ལོ་གསར་གོང་'
      }
  };
  return data;
}
export default getLocaleResourceBase;