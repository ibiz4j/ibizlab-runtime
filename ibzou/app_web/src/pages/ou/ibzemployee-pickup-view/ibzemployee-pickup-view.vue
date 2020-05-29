<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZEmployeePickupViewBase from './ibzemployee-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ibzemployee/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class IBZEmployeePickupView extends IBZEmployeePickupViewBase {

}
</script>