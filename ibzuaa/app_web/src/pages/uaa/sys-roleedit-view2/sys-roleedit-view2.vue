<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_ROLEEditView2Base from './sys-roleedit-view2-base.vue';

import view_form from '@widgets/sys-role/main-form/main-form.vue';
import view_drbar from '@widgets/sys-role/default-drbar/default-drbar.vue';
@Component({
    components: {
        view_form, 
        view_drbar, 
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
export default class SYS_ROLEEditView2 extends SYS_ROLEEditView2Base {

}
</script>