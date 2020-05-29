<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_PERMISSIONEditViewBase from './sys-permissionedit-view-base.vue';

import view_form from '@widgets/sys-permission/main-form/main-form.vue';
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
export default class SYS_PERMISSIONEditView extends SYS_PERMISSIONEditViewBase {

}
</script>