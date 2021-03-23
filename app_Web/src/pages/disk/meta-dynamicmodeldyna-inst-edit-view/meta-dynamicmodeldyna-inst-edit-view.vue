<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import META_DYNAMICMODELDynaInstEditViewBase from './meta-dynamicmodeldyna-inst-edit-view-base.vue';

import view_form from '@widgets/meta-dynamic-model/dyna-inst-form/dyna-inst-form.vue';
@Component({
    components: {
        view_form, 
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
export default class META_DYNAMICMODELDynaInstEditView extends META_DYNAMICMODELDynaInstEditViewBase {

}
</script>