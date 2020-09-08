import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/notifyindexview/:notifyindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'notifyindexview';
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
                caption: 'app.views.notifyindexview.caption',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/notify/notify-index-view/notify-index-view.vue'),
            children: [
                {
                    path: 'msgopenaccesses/:msgopenaccess?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-grid-view/msg-open-access-grid-view.vue'),
                },
                {
                    path: 'msguseraccounts/:msguseraccount?/editview/:editview?',
                    meta: {
                        caption: 'entities.msguseraccount.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-user-account-edit-view/msg-user-account-edit-view.vue'),
                },
                {
                    path: 'msguseraccounts/:msguseraccount?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.msguseraccount.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-user-account-grid-view/msg-user-account-grid-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-pickup-view/msg-open-access-pickup-view.vue'),
                },
                {
                    path: 'msgtemplates/:msgtemplate?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.msgtemplate.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-template-grid-view/msg-template-grid-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-pickup-grid-view/msg-open-access-pickup-grid-view.vue'),
                },
                {
                    path: 'msgtemplates/:msgtemplate?/editview/:editview?',
                    meta: {
                        caption: 'entities.msgtemplate.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-template-edit-view/msg-template-edit-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/editview/:editview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'notifyindexview', parameterName: 'notifyindexview' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-edit-view/msg-open-access-edit-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/msgopenaccesses/:msgopenaccess?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.msgopenaccess.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-pickup-grid-view/msg-open-access-pickup-grid-view.vue'),
    },
    {
        path: '/msgopenaccesses/:msgopenaccess?/gridview/:gridview?',
        meta: {
            caption: 'entities.msgopenaccess.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-grid-view/msg-open-access-grid-view.vue'),
    },
    {
        path: '/msgtemplates/:msgtemplate?/gridview/:gridview?',
        meta: {
            caption: 'entities.msgtemplate.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-template-grid-view/msg-template-grid-view.vue'),
    },
    {
        path: '/msgtemplates/:msgtemplate?/editview/:editview?',
        meta: {
            caption: 'entities.msgtemplate.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-template-edit-view/msg-template-edit-view.vue'),
    },
    {
        path: '/msguseraccounts/:msguseraccount?/editview/:editview?',
        meta: {
            caption: 'entities.msguseraccount.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-user-account-edit-view/msg-user-account-edit-view.vue'),
    },
    {
        path: '/msgopenaccesses/:msgopenaccess?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.msgopenaccess.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-pickup-view/msg-open-access-pickup-view.vue'),
    },
    {
        path: '/msgopenaccesses/:msgopenaccess?/editview/:editview?',
        meta: {
            caption: 'entities.msgopenaccess.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-edit-view/msg-open-access-edit-view.vue'),
    },
    {
        path: '/msguseraccounts/:msguseraccount?/gridview/:gridview?',
        meta: {
            caption: 'entities.msguseraccount.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-user-account-grid-view/msg-user-account-grid-view.vue'),
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
            redirect: 'notifyindexview'
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
