<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PayIndexViewBase from './pay-index-view-base.vue';

import view_appmenu from '@widgets/app/pay-index-view-appmenu/pay-index-view-appmenu.vue';
@Component({
    components: {
        view_appmenu, 
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
export default class PayIndexView extends PayIndexViewBase {

}
</script>