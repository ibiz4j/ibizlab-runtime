<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WFTaskGridViewBase from './wftask-grid-view-base.vue';

import view_grid from '@widgets/wftask/main-grid/main-grid.vue';
import view_searchform from '@widgets/wftask/default-searchform/default-searchform.vue';
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            if(!Object.is(vm.navModel,"route")){
                vm.initNavDataWithTab(vm.viewCacheData);
            }
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class WFTaskGridView extends WFTaskGridViewBase {

}
</script>