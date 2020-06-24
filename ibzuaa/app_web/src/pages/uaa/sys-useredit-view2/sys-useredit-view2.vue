<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_USEREditView2Base from './sys-useredit-view2-base.vue';

import view_form from '@widgets/sys-user/main-form/main-form.vue';
import view_drbar from '@widgets/sys-user/default-drbar/default-drbar.vue';
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
export default class SYS_USEREditView2 extends SYS_USEREditView2Base {

}
</script>