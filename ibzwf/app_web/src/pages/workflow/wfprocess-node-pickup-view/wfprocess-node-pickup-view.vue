<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WFProcessNodePickupViewBase from './wfprocess-node-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/wfprocess-node/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
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
export default class WFProcessNodePickupView extends WFProcessNodePickupViewBase {

}
</script>