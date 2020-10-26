export const appConfig = {
    //默认主题
    defaultTheme: 'app-default-theme',
    //默认字体
    defaultFont: 'Microsoft YaHei',
    //主题集合
    themes: [
        {
            tag: 'app-default-theme',
            title: 'light',
            color: '#f6f6f6',
        },
        {
            tag: 'app_theme_blue',
            title: 'Blue',
            color: '#6ba1d1'
        },
        {
            tag: 'app_theme_darkblue',
            title: 'Dark Blue',
            color: '#606d80'
        },
    ],
    //字体集合
    fonts: [
        {
            label: 'MicrosoftYaHei',
            value: 'Microsoft YaHei',
        },
        {
            label: 'SimHei',
            value: 'SimHei',
        },
        {
            label: 'YouYuan',
            value: 'YouYuan',
        },
    ],
    // 面包屑分隔符
    breadcrumbSeparator:"/"
}