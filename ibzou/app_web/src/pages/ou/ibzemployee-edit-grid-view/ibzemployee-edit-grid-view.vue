<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZEmployeeEditGridViewBase from './ibzemployee-edit-grid-view-base.vue';

import view_grid from '@widgets/ibzemployee/edit-grid-grid/edit-grid-grid.vue';
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
export default class IBZEmployeeEditGridView extends IBZEmployeeEditGridViewBase {

}
</script>