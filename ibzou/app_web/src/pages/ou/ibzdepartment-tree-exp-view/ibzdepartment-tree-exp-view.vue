<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZDepartmentTreeExpViewBase from './ibzdepartment-tree-exp-view-base.vue';

import view_treeexpbar from '@widgets/ibzdepartment/tree-exp-viewtreeexpbar-treeexpbar/tree-exp-viewtreeexpbar-treeexpbar.vue';
@Component({
    components: {
        view_treeexpbar, 
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
export default class IBZDepartmentTreeExpView extends IBZDepartmentTreeExpViewBase {

}
</script>