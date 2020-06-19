export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('jobs-log-grid-view', () => import('@pages/task/jobs-log-grid-view/jobs-log-grid-view.vue'));
        Vue.component('jobs-registry-edit-view', () => import('@pages/task/jobs-registry-edit-view/jobs-registry-edit-view.vue'));
        Vue.component('jobs-registry-grid-view', () => import('@pages/task/jobs-registry-grid-view/jobs-registry-grid-view.vue'));
        Vue.component('jobs-log-edit-view', () => import('@pages/task/jobs-log-edit-view/jobs-log-edit-view.vue'));
        Vue.component('jobs-info-edit-view', () => import('@pages/task/jobs-info-edit-view/jobs-info-edit-view.vue'));
        Vue.component('jobs-info-grid-view', () => import('@pages/task/jobs-info-grid-view/jobs-info-grid-view.vue'));
    }
};