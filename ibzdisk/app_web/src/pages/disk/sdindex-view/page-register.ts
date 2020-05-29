export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('sdfile-grid-view', () => import('@pages/disk/sdfile-grid-view/sdfile-grid-view.vue'));
        Vue.component('sdfile-edit-view', () => import('@pages/disk/sdfile-edit-view/sdfile-edit-view.vue'));
    }
};