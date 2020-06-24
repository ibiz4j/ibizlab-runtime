<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_ROLE_PERMISSIONEditViewBase from './sys-role-permissionedit-view-base.vue';

import view_form from '@widgets/sys-role-permission/main-form/main-form.vue';
@Component({
    components: {
        view_form, 
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
export default class SYS_ROLE_PERMISSIONEditView extends SYS_ROLE_PERMISSIONEditViewBase {

}
</script>