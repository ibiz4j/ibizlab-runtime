import Vue from 'vue';
import Vuex from 'vuex';

import { rootstate } from './state';
// import * as actions from './actions';
import * as mutations from './mutations';
import * as getters from './getters';

import viewaction from './modules/view-action'
import unifiedresource from './modules/unified-resource'

const state = {
    ...rootstate
};

Vue.use(Vuex);

const store = new Vuex.Store({
    state,
    // actions,
    mutations,
    getters,
    modules: {
        viewaction,
        unifiedresource
    },
});

export default store;
