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
                caption: 'app.views.index.title',
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
                    path: 'sysapps/:sysapp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysapp.views.gridview.title',
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
                    path: 'sysroles/:sysrole?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupview.title',
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
                    path: 'sysapps/:sysapp?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysapp.views.editview.title',
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
                    path: 'sysusers/:sysuser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.mpickupview.title',
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
                        caption: 'entities.sysrolepermission.views.customview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'),
                },
                {
                    path: 'syspermissions/:syspermission?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'syspermissions', parameterName: 'syspermission' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'),
                },
                {
                    path: 'sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupgridview.title',
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
                    path: 'sysroles/:sysrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysrole.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-roleedit-view/sys-roleedit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-roleedit-view/sys-user-roleedit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-roleedit-view/sys-user-roleedit-view.vue'),
                },
                {
                    path: 'sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-roleedit-view/sys-user-roleedit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.mpickupview.title',
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
                        caption: 'entities.sysauthlog.views.gridview.title',
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
                    path: 'sysusers/:sysuser?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupview.title',
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
                        caption: 'entities.sysrole.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-rolegrid-view/sys-rolegrid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuser.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-useredit-view/sys-useredit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.title',
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
                        caption: 'entities.sysuserrole.views.gridview.title',
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
                        caption: 'entities.sysuserrole.views.gridview.title',
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
                        caption: 'entities.sysrole.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-rolepickup-grid-view/sys-rolepickup-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuser.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-usergrid-view/sys-usergrid-view.vue'),
                },
            {
                path: 'sys_user_roleredirectview/:sys_user_roleredirectview?',
                meta: {
                    caption: 'entities.sysuserrole.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'sys_user_roleredirectview', parameterName: 'sys_user_roleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-user-roleredirect-view/sys-user-roleredirect-view.vue'),
            },
            {
                path: 'sys_role_permissionredirectview/:sys_role_permissionredirectview?',
                meta: {
                    caption: 'entities.sysrolepermission.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'sys_role_permissionredirectview', parameterName: 'sys_role_permissionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/uaa/sys-role-permissionredirect-view/sys-role-permissionredirect-view.vue'),
            },
            {
                path: 'sys_userredirectview/:sys_userredirectview?',
                meta: {
                    caption: 'entities.sysuser.views.redirectview.title',
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
                    caption: 'entities.sysrole.views.redirectview.title',
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
                    caption: 'entities.syspermission.views.redirectview.title',
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
            caption: 'entities.sysauthlog.views.gridview.title',
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
        path: '/sysapps/:sysapp?/editview/:editview?',
        meta: {
            caption: 'entities.sysapp.views.editview.title',
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
            caption: 'entities.sysrole.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-rolepickup-grid-view/sys-rolepickup-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-roleedit-view/sys-user-roleedit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-roleedit-view/sys-user-roleedit-view.vue'),
    },
    {
        path: '/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-roleedit-view/sys-user-roleedit-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysuser.views.mpickupview.title',
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
        path: '/sysroles/:sysrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysrole.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-roleedit-view/sys-roleedit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysrole.views.pickupview.title',
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
            caption: 'entities.sysuser.views.pickupgridview.title',
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
            caption: 'entities.sysuser.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-useredit-view/sys-useredit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysrole.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-rolegrid-view/sys-rolegrid-view.vue'),
    },
    {
        path: '/sysapps/:sysapp?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysapp.views.gridview.title',
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
            caption: 'entities.sysuser.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-usergrid-view/sys-usergrid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysrole.views.mpickupview.title',
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
            caption: 'entities.sysuser.views.pickupview.title',
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
            caption: 'entities.sysrolepermission.views.customview.title',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'),
    },
    {
        path: '/syspermissions/:syspermission?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.title',
            info:'',
            parameters: [
                { pathName: 'syspermissions', parameterName: 'syspermission' },
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'),
    },
    {
        path: '/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.title',
            info:'',
            parameters: [
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.title',
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
            caption: 'entities.sysuserrole.views.gridview.title',
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
            caption: 'entities.sysuserrole.views.gridview.title',
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
