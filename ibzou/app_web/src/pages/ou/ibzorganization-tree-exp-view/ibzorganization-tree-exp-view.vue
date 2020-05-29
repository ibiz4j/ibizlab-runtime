<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZOrganizationTreeExpViewBase from './ibzorganization-tree-exp-view-base.vue';

import view_treeexpbar from '@widgets/ibzorganization/tree-exp-viewtreeexpbar-treeexpbar/tree-exp-viewtreeexpbar-treeexpbar.vue';
@Component({
    components: {
        view_treeexpbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class IBZOrganizationTreeExpView extends IBZOrganizationTreeExpViewBase {

}
</script>