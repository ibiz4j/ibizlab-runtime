<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysRoleMPickupViewBase from './sys-role-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-role/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class SysRoleMPickupView extends SysRoleMPickupViewBase {

}
</script>