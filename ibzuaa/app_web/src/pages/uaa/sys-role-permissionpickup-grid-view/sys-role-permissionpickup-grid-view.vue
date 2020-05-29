<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_ROLE_PERMISSIONPickupGridViewBase from './sys-role-permissionpickup-grid-view-base.vue';

import view_grid from '@widgets/sys-role-permission/main-grid/main-grid.vue';
import view_searchform from '@widgets/sys-role-permission/default-searchform/default-searchform.vue';
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
export default class SYS_ROLE_PERMISSIONPickupGridView extends SYS_ROLE_PERMISSIONPickupGridViewBase {

}
</script>