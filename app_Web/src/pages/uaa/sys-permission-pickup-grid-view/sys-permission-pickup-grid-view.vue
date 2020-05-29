<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysPermissionPickupGridViewBase from './sys-permission-pickup-grid-view-base.vue';

import view_grid from '@widgets/sys-permission/main-grid/main-grid.vue';
import view_searchform from '@widgets/sys-permission/default-searchform/default-searchform.vue';
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
export default class SysPermissionPickupGridView extends SysPermissionPickupGridViewBase {

}
</script>