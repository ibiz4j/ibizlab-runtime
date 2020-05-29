<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_ROLEGridViewBase from './sys-rolegrid-view-base.vue';

import view_grid from '@widgets/sys-role/main-grid/main-grid.vue';
import view_searchform from '@widgets/sys-role/default-searchform/default-searchform.vue';
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
export default class SYS_ROLEGridView extends SYS_ROLEGridViewBase {

}
</script>