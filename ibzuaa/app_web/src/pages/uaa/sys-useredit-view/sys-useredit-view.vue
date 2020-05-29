<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_USEREditViewBase from './sys-useredit-view-base.vue';

import view_form from '@widgets/sys-user/main-form/main-form.vue';
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
export default class SYS_USEREditView extends SYS_USEREditViewBase {

}
</script>