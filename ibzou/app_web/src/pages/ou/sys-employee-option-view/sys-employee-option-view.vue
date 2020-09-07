<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysEmployeeOptionViewBase from './sys-employee-option-view-base.vue';

import view_form from '@widgets/sys-employee/new-form-form/new-form-form.vue';
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
export default class SysEmployeeOptionView extends SysEmployeeOptionViewBase {

}
</script>