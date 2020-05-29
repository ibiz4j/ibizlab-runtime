<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WFProcessDefinitionGridViewBase from './wfprocess-definition-grid-view-base.vue';

import view_grid from '@widgets/wfprocess-definition/main-grid/main-grid.vue';
import view_searchform from '@widgets/wfprocess-definition/default-searchform/default-searchform.vue';
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class WFProcessDefinitionGridView extends WFProcessDefinitionGridViewBase {

}
</script>