<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysUserPickupViewBase from './sys-user-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-user/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class SysUserPickupView extends SysUserPickupViewBase {

}
</script>