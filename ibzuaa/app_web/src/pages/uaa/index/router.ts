import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/index/:index?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'index';
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
                caption: 'app.views.index.caption',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'index', parameterName: 'index' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/uaa/index/index.vue'),
            children: [
                {
                    path: 'sysopenaccesses/:sysopenaccess?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysopenaccess.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-open-access-edit-view/sys-open-access-edit-view.vue'),
                },
                {
                    path: 'sysapps/:sysapp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysapp.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysapps', parameterName: 'sysapp' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-app-grid-view/sys-app-grid-view.vue'),
                },
                {
                    path: 'sysapps/:sysapp?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysapp.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysapps', parameterName: 'sysapp' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-app-edit-view/sys-app-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-rolepickup-view/sys-rolepickup-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-usermpickup-view/sys-usermpickup-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
                },
                {
                    path: 'syspermissions/:syspermission?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'syspermissions', parameterName: 'syspermission' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
                },
                {
                    path: 'sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-userpickup-grid-view/sys-userpickup-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
                },
                {
                    path: 'sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-edit-view/sys-role-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-rolempickup-view/sys-rolempickup-view.vue'),
                },
                {
                    path: 'sysauthlogs/:sysauthlog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysauthlog.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysauthlogs', parameterName: 'sysauthlog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-auth-log-grid-view/sys-auth-log-grid-view.vue'),
                },
                {
                    path: 'sysopenaccesses/:sysopenaccess?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysopenaccess.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-open-access-grid-view/sys-open-access-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-userpickup-view/sys-userpickup-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-grid-view/sys-role-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuser.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-edit-view/sys-user-edit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'),
                },
                {
                    path: 'sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-pickup-grid-view/sys-role-pickup-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuser.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-grid-view/sys-user-grid-view.vue'),
                },
            {
                path: 'sys_user_roleredirectview/:sys_user_roleredirectview?',
                meta: {
                    caption: 'entities.sysuserrole.views.redirectview.caption',
                    info:'',
                    parameters: [
                        { pathName: 'sys_user_roleredirectview', parameterName: 'sys_user_roleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-user-roleredirect-view/sys-user-roleredirect-view.vue'),
            },
            {
                path: 'sysrolepermissionredirectview/:sysrolepermissionredirectview?',
                meta: {
                    caption: 'entities.sysrolepermission.views.redirectview.caption',
                    info:'',
                    parameters: [
                        { pathName: 'sysrolepermissionredirectview', parameterName: 'sysrolepermissionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-role-permission-redirect-view/sys-role-permission-redirect-view.vue'),
            },
            {
                path: 'sys_userredirectview/:sys_userredirectview?',
                meta: {
                    caption: 'entities.sysuser.views.redirectview.caption',
                    info:'',
                    parameters: [
                        { pathName: 'sys_userredirectview', parameterName: 'sys_userredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-userredirect-view/sys-userredirect-view.vue'),
            },
            {
                path: 'sys_roleredirectview/:sys_roleredirectview?',
                meta: {
                    caption: 'entities.sysrole.views.redirectview.caption',
                    info:'',
                    parameters: [
                        { pathName: 'sys_roleredirectview', parameterName: 'sys_roleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-roleredirect-view/sys-roleredirect-view.vue'),
            },
            {
                path: 'sys_permissionredirectview/:sys_permissionredirectview?',
                meta: {
                    caption: 'entities.syspermission.views.redirectview.caption',
                    info:'',
                    parameters: [
                        { pathName: 'sys_permissionredirectview', parameterName: 'sys_permissionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-permissionredirect-view/sys-permissionredirect-view.vue'),
            },
            ...indexRoutes,
            ],
        },
    {
        path: '/sysauthlogs/:sysauthlog?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysauthlog.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysauthlogs', parameterName: 'sysauthlog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-auth-log-grid-view/sys-auth-log-grid-view.vue'),
    },
    {
        path: '/sysopenaccesses/:sysopenaccess?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysopenaccess.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-open-access-grid-view/sys-open-access-grid-view.vue'),
    },
    {
        path: '/sysapps/:sysapp?/editview/:editview?',
        meta: {
            caption: 'entities.sysapp.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysapps', parameterName: 'sysapp' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-app-edit-view/sys-app-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysrole.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-pickup-grid-view/sys-role-pickup-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
    },
    {
        path: '/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysuser.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-usermpickup-view/sys-usermpickup-view.vue'),
    },
    {
        path: '/sysopenaccesses/:sysopenaccess?/editview/:editview?',
        meta: {
            caption: 'entities.sysopenaccess.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-open-access-edit-view/sys-open-access-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-edit-view/sys-role-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysrole.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-rolepickup-view/sys-rolepickup-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysuser.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-userpickup-grid-view/sys-userpickup-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/editview/:editview?',
        meta: {
            caption: 'entities.sysuser.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-edit-view/sys-user-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-grid-view/sys-role-grid-view.vue'),
    },
    {
        path: '/sysapps/:sysapp?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysapp.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysapps', parameterName: 'sysapp' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-app-grid-view/sys-app-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuser.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-grid-view/sys-user-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysrole.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-rolempickup-view/sys-rolempickup-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysuser.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-userpickup-view/sys-userpickup-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
    },
    {
        path: '/syspermissions/:syspermission?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.caption',
            info:'',
            parameters: [
                { pathName: 'syspermissions', parameterName: 'syspermission' },
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
    },
    {
        path: '/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.caption',
            info:'',
            parameters: [
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'),
    },
    {
        path: '/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'),
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
            redirect: 'index'
        },
    ],
});

export default router;
