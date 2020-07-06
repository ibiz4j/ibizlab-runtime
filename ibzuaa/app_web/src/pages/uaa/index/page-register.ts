export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('sys-app-grid-view', () => import('@pages/uaa/sys-app-grid-view/sys-app-grid-view.vue'));
        Vue.component('sys-rolepickup-view', () => import('@pages/uaa/sys-rolepickup-view/sys-rolepickup-view.vue'));
        Vue.component('sys-app-edit-view', () => import('@pages/uaa/sys-app-edit-view/sys-app-edit-view.vue'));
        Vue.component('sys-usermpickup-view', () => import('@pages/uaa/sys-usermpickup-view/sys-usermpickup-view.vue'));
        Vue.component('sys-role-permissioncustom-view', () => import('@pages/uaa/sys-role-permissioncustom-view/sys-role-permissioncustom-view.vue'));
        Vue.component('sys-userpickup-grid-view', () => import('@pages/uaa/sys-userpickup-grid-view/sys-userpickup-grid-view.vue'));
        Vue.component('sys-roleedit-view', () => import('@pages/uaa/sys-roleedit-view/sys-roleedit-view.vue'));
        Vue.component('sys-user-role-edit-view', () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'));
        Vue.component('sys-rolempickup-view', () => import('@pages/uaa/sys-rolempickup-view/sys-rolempickup-view.vue'));
        Vue.component('sys-auth-log-grid-view', () => import('@pages/uaa/sys-auth-log-grid-view/sys-auth-log-grid-view.vue'));
        Vue.component('sys-userpickup-view', () => import('@pages/uaa/sys-userpickup-view/sys-userpickup-view.vue'));
        Vue.component('sys-rolegrid-view', () => import('@pages/uaa/sys-rolegrid-view/sys-rolegrid-view.vue'));
        Vue.component('sys-useredit-view', () => import('@pages/uaa/sys-useredit-view/sys-useredit-view.vue'));
        Vue.component('sys-user-rolegrid-view', () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'));
        Vue.component('sys-rolepickup-grid-view', () => import('@pages/uaa/sys-rolepickup-grid-view/sys-rolepickup-grid-view.vue'));
        Vue.component('sys-usergrid-view', () => import('@pages/uaa/sys-usergrid-view/sys-usergrid-view.vue'));
    }
};