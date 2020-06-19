import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/taskindexview/:taskindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'taskindexview';
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
                caption: 'app.views.taskindexview.title',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'taskindexview', parameterName: 'taskindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/task/task-index-view/task-index-view.vue'),
            children: [
                {
                    path: 'jobslogs/:jobslog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobslog.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'taskindexview', parameterName: 'taskindexview' },
                            { pathName: 'jobslogs', parameterName: 'jobslog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-log-grid-view/jobs-log-grid-view.vue'),
                },
                {
                    path: 'jobsregistries/:jobsregistry?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobsregistry.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'taskindexview', parameterName: 'taskindexview' },
                            { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-registry-edit-view/jobs-registry-edit-view.vue'),
                },
                {
                    path: 'jobsregistries/:jobsregistry?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobsregistry.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'taskindexview', parameterName: 'taskindexview' },
                            { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-registry-grid-view/jobs-registry-grid-view.vue'),
                },
                {
                    path: 'jobslogs/:jobslog?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobslog.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'taskindexview', parameterName: 'taskindexview' },
                            { pathName: 'jobslogs', parameterName: 'jobslog' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-log-edit-view/jobs-log-edit-view.vue'),
                },
                {
                    path: 'jobsinfos/:jobsinfo?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobsinfo.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'taskindexview', parameterName: 'taskindexview' },
                            { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-info-edit-view/jobs-info-edit-view.vue'),
                },
                {
                    path: 'jobsinfos/:jobsinfo?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobsinfo.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'taskindexview', parameterName: 'taskindexview' },
                            { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-info-grid-view/jobs-info-grid-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/jobsinfos/:jobsinfo?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobsinfo.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-info-grid-view/jobs-info-grid-view.vue'),
    },
    {
        path: '/jobsinfos/:jobsinfo?/editview/:editview?',
        meta: {
            caption: 'entities.jobsinfo.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-info-edit-view/jobs-info-edit-view.vue'),
    },
    {
        path: '/jobsregistries/:jobsregistry?/editview/:editview?',
        meta: {
            caption: 'entities.jobsregistry.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-registry-edit-view/jobs-registry-edit-view.vue'),
    },
    {
        path: '/jobslogs/:jobslog?/editview/:editview?',
        meta: {
            caption: 'entities.jobslog.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'jobslogs', parameterName: 'jobslog' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-log-edit-view/jobs-log-edit-view.vue'),
    },
    {
        path: '/jobsregistries/:jobsregistry?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobsregistry.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-registry-grid-view/jobs-registry-grid-view.vue'),
    },
    {
        path: '/jobslogs/:jobslog?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobslog.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'jobslogs', parameterName: 'jobslog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-log-grid-view/jobs-log-grid-view.vue'),
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
            path: '/404',
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            component: () => import('@components/500/500.vue')
        },
        {
            path: '*',
            redirect: 'taskindexview'
        },
    ],
});

export default router;
