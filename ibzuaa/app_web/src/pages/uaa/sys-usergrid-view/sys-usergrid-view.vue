<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_USERGridViewBase from './sys-usergrid-view-base.vue';

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
export default class SYS_USERGridView extends SYS_USERGridViewBase {

}
</script>