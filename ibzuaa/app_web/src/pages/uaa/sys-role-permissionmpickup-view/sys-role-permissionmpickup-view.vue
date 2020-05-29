<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_ROLE_PERMISSIONMPickupViewBase from './sys-role-permissionmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-role-permission/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class SYS_ROLE_PERMISSIONMPickupView extends SYS_ROLE_PERMISSIONMPickupViewBase {

}
</script>