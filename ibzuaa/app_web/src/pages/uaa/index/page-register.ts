export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('sys-open-access-edit-view', () => import('@pages/uaa/sys-open-access-edit-view/sys-open-access-edit-view.vue'));
        Vue.component('sys-app-grid-view', () => import('@pages/uaa/sys-app-grid-view/sys-app-grid-view.vue'));
        Vue.component('sys-app-edit-view', () => import('@pages/uaa/sys-app-edit-view/sys-app-edit-view.vue'));
        Vue.component('sys-rolepickup-view', () => import('@pages/uaa/sys-rolepickup-view/sys-rolepickup-view.vue'));
        Vue.component('sys-usermpickup-view', () => import('@pages/uaa/sys-usermpickup-view/sys-usermpickup-view.vue'));
        Vue.component('sys-role-permission-custom-view', () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'));
        Vue.component('sys-userpickup-grid-view', () => import('@pages/uaa/sys-userpickup-grid-view/sys-userpickup-grid-view.vue'));
        Vue.component('sys-user-role-edit-view', () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'));
        Vue.component('sys-role-edit-view', () => import('@pages/uaa/sys-role-edit-view/sys-role-edit-view.vue'));
        Vue.component('sys-rolempickup-view', () => import('@pages/uaa/sys-rolempickup-view/sys-rolempickup-view.vue'));
        Vue.component('sys-auth-log-grid-view', () => import('@pages/uaa/sys-auth-log-grid-view/sys-auth-log-grid-view.vue'));
        Vue.component('sys-open-access-grid-view', () => import('@pages/uaa/sys-open-access-grid-view/sys-open-access-grid-view.vue'));
        Vue.component('sys-userpickup-view', () => import('@pages/uaa/sys-userpickup-view/sys-userpickup-view.vue'));
        Vue.component('sys-role-grid-view', () => import('@pages/uaa/sys-role-grid-view/sys-role-grid-view.vue'));
        Vue.component('sys-user-edit-view', () => import('@pages/uaa/sys-user-edit-view/sys-user-edit-view.vue'));
        Vue.component('sys-user-rolegrid-view', () => import('@pages/uaa/sys-user-rolegrid-view/sys-user-rolegrid-view.vue'));
        Vue.component('sys-role-pickup-grid-view', () => import('@pages/uaa/sys-role-pickup-grid-view/sys-role-pickup-grid-view.vue'));
        Vue.component('sys-user-grid-view', () => import('@pages/uaa/sys-user-grid-view/sys-user-grid-view.vue'));
    }
};