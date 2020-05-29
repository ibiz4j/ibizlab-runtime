<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZEmployeeMPickupViewBase from './ibzemployee-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ibzemployee/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class IBZEmployeeMPickupView extends IBZEmployeeMPickupViewBase {

}
</script>