<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OUIndexViewBase from './ouindex-view-base.vue';

import view_appmenu from '@widgets/app/ouindex-view-appmenu/ouindex-view-appmenu.vue';
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
export default class OUIndexView extends OUIndexViewBase {

}
</script>