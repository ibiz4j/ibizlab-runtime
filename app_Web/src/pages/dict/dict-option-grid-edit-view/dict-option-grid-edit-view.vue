<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import DictOptionGridEditViewBase from './dict-option-grid-edit-view-base.vue';

import view_grid from '@widgets/dict-option/options-grid/options-grid.vue';
import view_searchform from '@widgets/dict-option/default-searchform/default-searchform.vue';
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
export default class DictOptionGridEditView extends DictOptionGridEditViewBase {

}
</script>