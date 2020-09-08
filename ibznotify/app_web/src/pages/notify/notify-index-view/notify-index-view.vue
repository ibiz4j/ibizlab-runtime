<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import NotifyIndexViewBase from './notify-index-view-base.vue';

import view_appmenu from '@widgets/app/notify-index-view-appmenu/notify-index-view-appmenu.vue';
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
export default class NotifyIndexView extends NotifyIndexViewBase {

}
</script>