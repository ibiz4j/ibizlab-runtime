<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZDeptMemberGridViewBase from './ibzdept-member-grid-view-base.vue';

import view_grid from '@widgets/ibzdept-member/main-grid/main-grid.vue';
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class IBZDeptMemberGridView extends IBZDeptMemberGridViewBase {

}
</script>