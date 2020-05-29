<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_ROLE_PERMISSIONRedirectViewBase from './sys-role-permissionredirect-view-base.vue';

@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SYS_ROLE_PERMISSIONRedirectView extends SYS_ROLE_PERMISSIONRedirectViewBase {

}
</script>