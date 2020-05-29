<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysAuthLogGridViewBase from './sys-auth-log-grid-view-base.vue';

import view_grid from '@widgets/sys-auth-log/main-grid/main-grid.vue';
import view_searchform from '@widgets/sys-auth-log/default-searchform/default-searchform.vue';
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
export default class SysAuthLogGridView extends SysAuthLogGridViewBase {

}
</script>