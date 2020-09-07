<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysDeptMemberGridViewBase from './sys-dept-member-grid-view-base.vue';

import view_grid from '@widgets/sys-dept-member/main-grid/main-grid.vue';
@Component({
    components: {
        view_grid, 
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
export default class SysDeptMemberGridView extends SysDeptMemberGridViewBase {

}
</script>