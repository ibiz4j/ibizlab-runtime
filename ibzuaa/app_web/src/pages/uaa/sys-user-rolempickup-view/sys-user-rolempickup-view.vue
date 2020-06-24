<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_USER_ROLEMPickupViewBase from './sys-user-rolempickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-user-role/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class SYS_USER_ROLEMPickupView extends SYS_USER_ROLEMPickupViewBase {

}
</script>