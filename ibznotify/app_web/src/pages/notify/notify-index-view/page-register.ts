export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('msg-open-access-grid-view', () => import('@pages/notify/msg-open-access-grid-view/msg-open-access-grid-view.vue'));
        Vue.component('msg-user-account-edit-view', () => import('@pages/notify/msg-user-account-edit-view/msg-user-account-edit-view.vue'));
        Vue.component('msg-user-account-grid-view', () => import('@pages/notify/msg-user-account-grid-view/msg-user-account-grid-view.vue'));
        Vue.component('msg-open-access-pickup-view', () => import('@pages/notify/msg-open-access-pickup-view/msg-open-access-pickup-view.vue'));
        Vue.component('msg-template-grid-view', () => import('@pages/notify/msg-template-grid-view/msg-template-grid-view.vue'));
        Vue.component('msg-open-access-pickup-grid-view', () => import('@pages/notify/msg-open-access-pickup-grid-view/msg-open-access-pickup-grid-view.vue'));
        Vue.component('msg-template-edit-view', () => import('@pages/notify/msg-template-edit-view/msg-template-edit-view.vue'));
        Vue.component('msg-open-access-edit-view', () => import('@pages/notify/msg-open-access-edit-view/msg-open-access-edit-view.vue'));
    }
};