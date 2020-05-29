<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_USERRedirectViewBase from './sys-userredirect-view-base.vue';

@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SYS_USERRedirectView extends SYS_USERRedirectViewBase {

}
</script>