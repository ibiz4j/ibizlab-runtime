<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysUserPickupGridViewBase from './sys-user-pickup-grid-view-base.vue';

import view_grid from '@widgets/sys-user/main-grid/main-grid.vue';
import view_searchform from '@widgets/sys-user/default-searchform/default-searchform.vue';
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
export default class SysUserPickupGridView extends SysUserPickupGridViewBase {

}
</script>