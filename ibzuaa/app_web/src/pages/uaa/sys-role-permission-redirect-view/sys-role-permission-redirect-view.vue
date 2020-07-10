<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysRolePermissionRedirectViewBase from './sys-role-permission-redirect-view-base.vue';

@Component({
    components: {
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
export default class SysRolePermissionRedirectView extends SysRolePermissionRedirectViewBase {

}
</script>