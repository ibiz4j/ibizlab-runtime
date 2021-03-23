import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/sdindexview/:sdindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'sdindexview';
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
                caption: 'app.views.sdindexview.caption',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'sdindexview', parameterName: 'sdindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/disk/sdindex-view/sdindex-view.vue'),
            children: [
                {
                    path: 'metadynamicmodels/:metadynamicmodel?/editview/:editview?',
                    meta: {
                        caption: 'entities.metadynamicmodel.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/lite/meta-dynamic-model-edit-view/meta-dynamic-model-edit-view.vue'),
                },
                {
                    path: 'sdfiles/:sdfile?/editview/:editview?',
                    meta: {
                        caption: 'entities.sdfile.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'sdfiles', parameterName: 'sdfile' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/disk/sdfile-edit-view/sdfile-edit-view.vue'),
                },
                {
                    path: 'metadynamicmodels/:metadynamicmodel?/dynainstgridview/:dynainstgridview?',
                    meta: {
                        caption: 'entities.metadynamicmodel.views.dynainstgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                            { pathName: 'dynainstgridview', parameterName: 'dynainstgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/lite/meta-dynamic-model-dyna-inst-grid-view/meta-dynamic-model-dyna-inst-grid-view.vue'),
                },
                {
                    path: 'metadynamicmodels/:metadynamicmodel?/dynainsteditview/:dynainsteditview?',
                    meta: {
                        caption: 'entities.metadynamicmodel.views.dynainsteditview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                            { pathName: 'dynainsteditview', parameterName: 'dynainsteditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/lite/meta-dynamic-model-dyna-inst-edit-view/meta-dynamic-model-dyna-inst-edit-view.vue'),
                },
                {
                    path: 'metadynamicmodels/:metadynamicmodel?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.metadynamicmodel.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/lite/meta-dynamic-model-grid-view/meta-dynamic-model-grid-view.vue'),
                },
                {
                    path: 'sdfiles/:sdfile?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sdfile.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'sdfiles', parameterName: 'sdfile' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/disk/sdfile-grid-view/sdfile-grid-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/sdfiles/:sdfile?/editview/:editview?',
        meta: {
            caption: 'entities.sdfile.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sdfiles', parameterName: 'sdfile' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/disk/sdfile-edit-view/sdfile-edit-view.vue'),
    },
    {
        path: '/sdfiles/:sdfile?/gridview/:gridview?',
        meta: {
            caption: 'entities.sdfile.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sdfiles', parameterName: 'sdfile' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/disk/sdfile-grid-view/sdfile-grid-view.vue'),
    },
    {
        path: '/metadynamicmodels/:metadynamicmodel?/dynainsteditview/:dynainsteditview?',
        meta: {
            caption: 'entities.metadynamicmodel.views.dynainsteditview.caption',
            info:'',
            parameters: [
                { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                { pathName: 'dynainsteditview', parameterName: 'dynainsteditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/lite/meta-dynamic-model-dyna-inst-edit-view/meta-dynamic-model-dyna-inst-edit-view.vue'),
    },
    {
        path: '/metadynamicmodels/:metadynamicmodel?/gridview/:gridview?',
        meta: {
            caption: 'entities.metadynamicmodel.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/lite/meta-dynamic-model-grid-view/meta-dynamic-model-grid-view.vue'),
    },
    {
        path: '/metadynamicmodels/:metadynamicmodel?/dynainstgridview/:dynainstgridview?',
        meta: {
            caption: 'entities.metadynamicmodel.views.dynainstgridview.caption',
            info:'',
            parameters: [
                { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                { pathName: 'dynainstgridview', parameterName: 'dynainstgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/lite/meta-dynamic-model-dyna-inst-grid-view/meta-dynamic-model-dyna-inst-grid-view.vue'),
    },
    {
        path: '/metadynamicmodels/:metadynamicmodel?/editview/:editview?',
        meta: {
            caption: 'entities.metadynamicmodel.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/lite/meta-dynamic-model-edit-view/meta-dynamic-model-edit-view.vue'),
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
            redirect: 'sdindexview'
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
