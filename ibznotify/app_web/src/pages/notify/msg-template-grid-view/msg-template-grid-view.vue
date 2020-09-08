<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import MsgTemplateGridViewBase from './msg-template-grid-view-base.vue';

import view_grid from '@widgets/msg-template/main-grid/main-grid.vue';
import view_searchform from '@widgets/msg-template/default-searchform/default-searchform.vue';
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
export default class MsgTemplateGridView extends MsgTemplateGridViewBase {

}
</script>