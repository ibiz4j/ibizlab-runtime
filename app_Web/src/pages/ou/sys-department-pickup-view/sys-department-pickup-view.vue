<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysDepartmentPickupViewBase from './sys-department-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-department/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
@Component({
    components: {
        view_pickupviewpanel, 
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
export default class SysDepartmentPickupView extends SysDepartmentPickupViewBase {

}
</script>