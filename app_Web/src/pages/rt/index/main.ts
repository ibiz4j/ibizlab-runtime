import Vue from 'vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';
import App from '@/App.vue';
import ElementUi from 'element-ui';
import ViewUI from 'view-design';
import ibizLab from 'ibiz-vue-lib';
import axios from "axios";
import { Interceptors } from '@/utils';
import  {Print} from '@/utils/print';
import i18n from '@/locale'

import 'element-ui/lib/theme-chalk/index.css';
import 'view-design/dist/styles/iview.css';
import 'ibiz-vue-lib/lib/ibiz-vue-lib.css';
import '@/styles/default.less';

import VueAMap from 'vue-amap';
Vue.use(VueAMap);

VueAMap.initAMapApiLoader({
  key: '6ab2751103aea67e817c90a5528181b5',
  plugin: ["AMap.Geolocation","AMap.PlaceSearch","AMap.Geocoder", "AMap.Autocomplete"],
  uiVersion: '1.1'
});

// 模拟数据
if (process.env.NODE_ENV === 'development') {
  require('@/mock');
}

const pathToRegExp = require('path-to-regexp');
import { AppComponents } from '@/app-register';
import { PageComponents } from './page-register';
import { UserComponent } from '@/user-register';
import { PortletComponent } from '@/portlet-register';
import store from '@/store';
import router from './router';

const win: any = window;
win.axios = axios;

Vue.config.errorHandler = function (err: any, vm: any, info: any) {
  console.log(err);
}

Vue.config.productionTip = false;
Vue.use(Print);
Vue.use(ibizLab);
Vue.use(Vuex);
Vue.use(win.AVUE);
Vue.use(VueRouter);;
Vue.use(ElementUi, {
  i18n: (key: any, value: any) => i18n.t(key, value)
});
Vue.use(ViewUI, {
  i18n: (key: any, value: any) => i18n.t(key, value)
});

// Vue.use(utils);
Vue.prototype.$pathToRegExp = pathToRegExp;
Vue.use(AppComponents);
Vue.use(PageComponents);
Vue.use(UserComponent);
Vue.use(PortletComponent);

router.beforeEach((to: any, from: any, next: any) => {
  if(sessionStorage.getItem('lockState') && to.path != '/lock'){
    next({ path: '/lock'});
  }else{
    if (to.meta && !to.meta.ignoreAddPage) {
      router.app.$store.commit('addPage', to);
    }
    next();
  }
});

Interceptors.getInstance(router,store);

const init = async () => {
  new Vue({
      i18n,
      store,
      router,
      render: (h: any) => h(App),
  }).$mount('#app');
};
init();