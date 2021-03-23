<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import MetaDynamicModelGridViewBase from './meta-dynamic-model-grid-view-base.vue';

import view_grid from '@widgets/meta-dynamic-model/main-grid/main-grid.vue';
import view_searchform from '@widgets/meta-dynamic-model/default-searchform/default-searchform.vue';
@Component({
    components: {
        view_grid, 
        view_searchform, 
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
export default class MetaDynamicModelGridView extends MetaDynamicModelGridViewBase {

}
</script>