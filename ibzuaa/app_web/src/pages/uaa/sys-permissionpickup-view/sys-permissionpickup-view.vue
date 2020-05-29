<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_PERMISSIONPickupViewBase from './sys-permissionpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-permission/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SYS_PERMISSIONPickupView extends SYS_PERMISSIONPickupViewBase {

}
</script>