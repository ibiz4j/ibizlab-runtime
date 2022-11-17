<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WFProcessInstanceActiveInstanceOptionViewBase from './wfprocess-instance-active-instance-option-view-base.vue';

import view_form from '@widgets/wfprocess-instance/jump-form/jump-form.vue';
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
export default class WFProcessInstanceActiveInstanceOptionView extends WFProcessInstanceActiveInstanceOptionViewBase {

}
</script>