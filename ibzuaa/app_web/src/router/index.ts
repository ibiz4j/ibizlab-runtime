//用户自定义全局路由
export const globalRoutes:Array<any> = [
    {
        path: '/register',
        component: ()=> import('@components/login/register.vue')
    }
];
//用户自定义首页路由
export const indexRoutes:Array<any> = [

];
