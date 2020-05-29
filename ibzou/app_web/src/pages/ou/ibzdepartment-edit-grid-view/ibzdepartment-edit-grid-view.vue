<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZDepartmentEditGridViewBase from './ibzdepartment-edit-grid-view-base.vue';

import view_grid from '@widgets/ibzdepartment/edit-grid-grid/edit-grid-grid.vue';
import view_searchform from '@widgets/ibzdepartment/default-searchform/default-searchform.vue';
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
export default class IBZDepartmentEditGridView extends IBZDepartmentEditGridViewBase {

}
</script>