export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('meta-dynamic-model-edit-view', () => import('@pages/lite/meta-dynamic-model-edit-view/meta-dynamic-model-edit-view.vue'));
        Vue.component('sdfile-edit-view', () => import('@pages/disk/sdfile-edit-view/sdfile-edit-view.vue'));
        Vue.component('meta-dynamic-model-dyna-inst-grid-view', () => import('@pages/lite/meta-dynamic-model-dyna-inst-grid-view/meta-dynamic-model-dyna-inst-grid-view.vue'));
        Vue.component('meta-dynamic-model-dyna-inst-edit-view', () => import('@pages/lite/meta-dynamic-model-dyna-inst-edit-view/meta-dynamic-model-dyna-inst-edit-view.vue'));
        Vue.component('meta-dynamic-model-grid-view', () => import('@pages/lite/meta-dynamic-model-grid-view/meta-dynamic-model-grid-view.vue'));
        Vue.component('sdfile-grid-view', () => import('@pages/disk/sdfile-grid-view/sdfile-grid-view.vue'));
    }
};