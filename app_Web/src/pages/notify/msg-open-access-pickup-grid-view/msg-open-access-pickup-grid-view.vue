<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import MsgOpenAccessPickupGridViewBase from './msg-open-access-pickup-grid-view-base.vue';

import view_grid from '@widgets/msg-open-access/main-grid/main-grid.vue';
import view_searchform from '@widgets/msg-open-access/default-searchform/default-searchform.vue';
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
export default class MsgOpenAccessPickupGridView extends MsgOpenAccessPickupGridViewBase {

}
</script>