<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysUserMPickupViewBase from './sys-user-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-user/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class SysUserMPickupView extends SysUserMPickupViewBase {

}
</script>