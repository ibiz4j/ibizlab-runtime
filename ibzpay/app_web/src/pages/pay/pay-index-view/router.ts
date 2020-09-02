import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/payindexview/:payindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'payindexview';
                const params: any = {};
                if (to.params && to.params[routerParamsName]) {
                    Object.assign(params, qs.parse(to.params[routerParamsName], { delimiter: ';' }));
                }
                const url: string = '/appdata';
                const auth: Promise<any> = AuthGuard.getInstance().authGuard(url, params, router);
                auth.then(() => {
                    next();
                }).catch(() => {
                    next();
                });
            },
            meta: {  
                caption: 'app.views.payindexview.caption',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'payindexview', parameterName: 'payindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/pay/pay-index-view/pay-index-view.vue'),
            children: [
                {
                    path: 'paytrades/:paytrade?/editview/:editview?',
                    meta: {
                        caption: 'entities.paytrade.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'payindexview', parameterName: 'payindexview' },
                            { pathName: 'paytrades', parameterName: 'paytrade' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-trade-edit-view/pay-trade-edit-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'payindexview', parameterName: 'payindexview' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-pickup-view/pay-open-access-pickup-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'payindexview', parameterName: 'payindexview' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-grid-view/pay-open-access-grid-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/editview/:editview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'payindexview', parameterName: 'payindexview' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-edit-view/pay-open-access-edit-view.vue'),
                },
                {
                    path: 'paytrades/:paytrade?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.paytrade.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'payindexview', parameterName: 'payindexview' },
                            { pathName: 'paytrades', parameterName: 'paytrade' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-trade-grid-view/pay-trade-grid-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'payindexview', parameterName: 'payindexview' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-pickup-grid-view/pay-open-access-pickup-grid-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/paytrades/:paytrade?/editview/:editview?',
        meta: {
            caption: 'entities.paytrade.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'paytrades', parameterName: 'paytrade' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-trade-edit-view/pay-trade-edit-view.vue'),
    },
    {
        path: '/paytrades/:paytrade?/gridview/:gridview?',
        meta: {
            caption: 'entities.paytrade.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'paytrades', parameterName: 'paytrade' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-trade-grid-view/pay-trade-grid-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/gridview/:gridview?',
        meta: {
            caption: 'entities.payopenaccess.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-grid-view/pay-open-access-grid-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.payopenaccess.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-pickup-grid-view/pay-open-access-pickup-grid-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.payopenaccess.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-pickup-view/pay-open-access-pickup-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/editview/:editview?',
        meta: {
            caption: 'entities.payopenaccess.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-edit-view/pay-open-access-edit-view.vue'),
    },
        ...globalRoutes,
        {
            path: '/login/:login?',
            name: 'login',
            meta: {  
                caption: '登录',
                viewType: 'login',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                router.app.$store.commit('resetRootStateData');
                next();
            },
            component: () => import('@components/login/login.vue'),
        },
        {
            path: '/lock',
            name: 'lock',
            meta: {  
                caption: '锁屏',
                viewType: 'lock',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                next();
            },
            component: () => import('@components/app-lock/app-lock.vue'),
        },
        {
            path: '/404',
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            component: () => import('@components/500/500.vue')
        },
        {
            path: '*',
            redirect: 'payindexview'
        },
    ],
});
// 解决路由跳转路由重复时报错
const originalPush = Router.prototype.push
Router.prototype.push = function push(location: any) {
    let result: any = originalPush.call(this, location);
    return result.catch((err: any) => err);
}
export default router;
