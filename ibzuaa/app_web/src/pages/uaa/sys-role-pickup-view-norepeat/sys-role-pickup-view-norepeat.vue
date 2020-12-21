<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysRolePickupView_norepeatBase from './sys-role-pickup-view-norepeat-base.vue';

import view_pickupviewpanel from '@widgets/sys-role/pickup-view-norepeatpickupviewpanel-pickupviewpanel/pickup-view-norepeatpickupviewpanel-pickupviewpanel.vue';
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
export default class SysRolePickupView_norepeat extends SysRolePickupView_norepeatBase {

}
</script>