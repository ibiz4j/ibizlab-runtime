<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_PERMISSIONEditView2Base from './sys-permissionedit-view2-base.vue';

import view_form from '@widgets/sys-permission/main-form/main-form.vue';
import view_drbar from '@widgets/sys-permission/default-drbar/default-drbar.vue';
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
export default class SYS_PERMISSIONEditView2 extends SYS_PERMISSIONEditView2Base {

}
</script>