<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZEmployeeGridViewBase from './ibzemployee-grid-view-base.vue';

import view_grid from '@widgets/ibzemployee/main-grid/main-grid.vue';
import view_searchform from '@widgets/ibzemployee/default-searchform/default-searchform.vue';
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
export default class IBZEmployeeGridView extends IBZEmployeeGridViewBase {

}
</script>