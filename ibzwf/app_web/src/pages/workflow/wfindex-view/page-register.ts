export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('wfprocess-definition-edit-view', () => import('@pages/workflow/wfprocess-definition-edit-view/wfprocess-definition-edit-view.vue'));
        Vue.component('wfuser-pickup-grid-view', () => import('@pages/workflow/wfuser-pickup-grid-view/wfuser-pickup-grid-view.vue'));
        Vue.component('wfgroup-pickup-view', () => import('@pages/workflow/wfgroup-pickup-view/wfgroup-pickup-view.vue'));
        Vue.component('wfremodel-edit-view', () => import('@pages/workflow/wfremodel-edit-view/wfremodel-edit-view.vue'));
        Vue.component('wfgroup-pickup-grid-view', () => import('@pages/workflow/wfgroup-pickup-grid-view/wfgroup-pickup-grid-view.vue'));
        Vue.component('wftask-grid-view', () => import('@pages/workflow/wftask-grid-view/wftask-grid-view.vue'));
        Vue.component('wftask-edit-view', () => import('@pages/workflow/wftask-edit-view/wftask-edit-view.vue'));
        Vue.component('wfuser-mpickup-view', () => import('@pages/workflow/wfuser-mpickup-view/wfuser-mpickup-view.vue'));
        Vue.component('wfgroup-edit-view', () => import('@pages/workflow/wfgroup-edit-view/wfgroup-edit-view.vue'));
        Vue.component('wfprocess-definition-grid-view', () => import('@pages/workflow/wfprocess-definition-grid-view/wfprocess-definition-grid-view.vue'));
        Vue.component('wfmember-edit-view', () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'));
        Vue.component('wfgroup-grid-view', () => import('@pages/workflow/wfgroup-grid-view/wfgroup-grid-view.vue'));
        Vue.component('wfgroup-mpickup-view', () => import('@pages/workflow/wfgroup-mpickup-view/wfgroup-mpickup-view.vue'));
        Vue.component('wfuser-pickup-view', () => import('@pages/workflow/wfuser-pickup-view/wfuser-pickup-view.vue'));
        Vue.component('wfmember-grid-view', () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'));
    }
};