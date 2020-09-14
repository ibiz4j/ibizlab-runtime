export const Environment = {
    // 原型示例数模式
    SampleMode: false,
    // 应用名称
    AppName: 'Web',
    // 应用 title
    AppTitle: 'ibizlab-runtime',
    // 应用基础路径
    BaseUrl: '',
    // 系统名称
    SysName: 'ibzrt',
    // 远程登录地址，本地开发调试使用
    RemoteLogin: '/ibizutil/login',
    // 文件导出
    ExportFile: '/ibizutil/download',
    // 文件上传
    UploadFile: '/ibizutil/upload',
    // 数据导入单次上传最大数量
    sliceUploadCnt: 100,
    // 是否为pc端应用
    isAppMode:true,
    //统一地址
    uniteAddress:"http://172.16.100.202:8114",
    // 是否为开发模式
    devMode: true,
    // 是否开启权限认证
    enablePermissionValid:false,
    // 项目模板地址
    ProjectUrl: "https://gitee.com/ibizlab/ibizlab-runtime",
    // 打开目标工具，可选参数：sln、mos
    debugOpenMode:'mos',
    // 配置平台地址
    StudioUrl: "http://mos.ibizlab.cn/mos/",
    // 中心标识
    SlnId: "01EE39A0-70C8-49CD-8733-A25C6901E658",
    // 系统标识
    SysId: "2AFD15C7-9AE2-4108-BCC4-6AE6F7BC6087",
    // 前端应用标识
    AppId: "d8c7cbb7c727d7e7d1dd239996e9745f",
    // 项目发布文件地址
    PublishProjectUrl: 'https://gitee.com/ibizlab/ibizlab-runtime.git',
    // ibiz开放平台地址
    ibizlabtUrl: 'https://www.ibizlab.cn',
    // ibiz论坛地址
    ibizbbstUrl: 'https://bbs.ibizlab.cn',
};
// 挂载外部配置文件
if ((window as any).Environment) {
    Object.assign(Environment, (window as any).Environment);
}