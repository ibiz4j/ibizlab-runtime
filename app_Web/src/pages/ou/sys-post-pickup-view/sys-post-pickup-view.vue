<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysPostPickupViewBase from './sys-post-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sys-post/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class SysPostPickupView extends SysPostPickupViewBase {

}
</script>