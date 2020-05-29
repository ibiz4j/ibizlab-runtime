<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SysUserRoleEditViewBase from './sys-user-role-edit-view-base.vue';

import view_form from '@widgets/sys-user-role/main-form/main-form.vue';
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SysUserRoleEditView extends SysUserRoleEditViewBase {

}
</script>