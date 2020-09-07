<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysOrganizationOptionViewBase from './sys-organization-option-view-base.vue';

import view_form from '@widgets/sys-organization/new-form-form/new-form-form.vue';
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
export default class SysOrganizationOptionView extends SysOrganizationOptionViewBase {

}
</script>