export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('pay-trade-edit-view', () => import('@pages/pay/pay-trade-edit-view/pay-trade-edit-view.vue'));
        Vue.component('pay-open-access-pickup-view', () => import('@pages/pay/pay-open-access-pickup-view/pay-open-access-pickup-view.vue'));
        Vue.component('pay-open-access-grid-view', () => import('@pages/pay/pay-open-access-grid-view/pay-open-access-grid-view.vue'));
        Vue.component('pay-open-access-edit-view', () => import('@pages/pay/pay-open-access-edit-view/pay-open-access-edit-view.vue'));
        Vue.component('pay-trade-grid-view', () => import('@pages/pay/pay-trade-grid-view/pay-trade-grid-view.vue'));
        Vue.component('pay-open-access-pickup-grid-view', () => import('@pages/pay/pay-open-access-pickup-grid-view/pay-open-access-pickup-grid-view.vue'));
    }
};