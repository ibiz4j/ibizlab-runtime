<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IBZDepartmentMPickupViewBase from './ibzdepartment-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ibzdepartment/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class IBZDepartmentMPickupView extends IBZDepartmentMPickupViewBase {

}
</script>