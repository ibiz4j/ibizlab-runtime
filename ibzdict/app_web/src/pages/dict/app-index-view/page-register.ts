export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('dict-option-grid-edit-view', () => import('@pages/dict/dict-option-grid-edit-view/dict-option-grid-edit-view.vue'));
        Vue.component('dict-catalog-pickup-grid-view', () => import('@pages/dict/dict-catalog-pickup-grid-view/dict-catalog-pickup-grid-view.vue'));
        Vue.component('dict-option-edit-view', () => import('@pages/dict/dict-option-edit-view/dict-option-edit-view.vue'));
        Vue.component('dict-option-grid-view', () => import('@pages/dict/dict-option-grid-view/dict-option-grid-view.vue'));
        Vue.component('dict-catalog-grid-view', () => import('@pages/dict/dict-catalog-grid-view/dict-catalog-grid-view.vue'));
        Vue.component('dict-catalog-pickup-view', () => import('@pages/dict/dict-catalog-pickup-view/dict-catalog-pickup-view.vue'));
        Vue.component('dict-catalog-edit-view', () => import('@pages/dict/dict-catalog-edit-view/dict-catalog-edit-view.vue'));
    }
};